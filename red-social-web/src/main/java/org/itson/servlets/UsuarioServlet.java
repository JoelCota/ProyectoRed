/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.itson.excepciones.BOException;
import org.itson.implementaciones.FachadaBO;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Estado;
import org.itson.red.dominio.Genero;
import org.itson.red.dominio.Municipio;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Usuario;
import org.itson.utils.Encriptador;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // Size threshold for storing files in memory
    maxFileSize = 5 * 1024 * 1024, // Maximum file size allowed
    maxRequestSize = 20 * 1024 * 1024 // Maximum request size allowed
)
@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {

    Encriptador encriptador = new Encriptador();
    FachadaBO fachadaBO = new FachadaBO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("registrar")) {
            this.cargarRegistro(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("logout")) {
            this.proccessLogout(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("login")) {
            this.cargarLogin(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("irPerfil")) {
            this.cargarPerfil(request, response);
//            this.cargarVerPublicacionesPerfil(request, response);
            return;
        }
    }

    private void cargarVerPublicacionesPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int cantidadAnclados = 2;
        int cantidadComunes = 4;

        boolean atras = false;
        boolean siguiente = true;
        
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario)sesion.getAttribute("usuario");

        List<Anclado> anclados = new LinkedList<>();
        List<Comun> comunes = new LinkedList<>();

        try {
            anclados = fachadaBO.consultarPostsAncladosPorUsuarioPaginadoRecientes(usuario, cantidadComunes, cantidadComunes);
            comunes = fachadaBO.consultarPostsComunesPorUsuarioPaginadoRecientes(usuario, cantidadComunes, cantidadComunes);

            if (anclados.size() < cantidadAnclados && comunes.size() < cantidadComunes) {
                siguiente = false;
            }

        } catch (BOException e) {
            request.setAttribute("error", e.getMessage());
            this.getServletContext()
                    .getRequestDispatcher("/paginas/error.jsp")
                    .forward(request, response);
        }

        String url = "/paginas/perfil.jsp";
        request.setAttribute("anclados", anclados);
        request.setAttribute("comunes", comunes);
        request.setAttribute("siguiente", siguiente);
        request.setAttribute("atras", atras);
        request.setAttribute("pagina", 1);
        this.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
   
    private void cargarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();       
        Usuario usuario = (Usuario)sesion.getAttribute("usuario");
        sesion.removeAttribute("usuario");
        usuario = fachadaBO.consultarUsuarioPorId(usuario.getId());
        sesion.setAttribute("usuario", usuario);
        String pagina = "/paginas/perfil.jsp";
        this.getServletContext()
                .getRequestDispatcher(pagina)
                .forward(request, response);
    }

    private void cargarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "/paginas/login.jsp";
        this.getServletContext()
                .getRequestDispatcher(pagina)
                .forward(request, response);
    }

    private void cargarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "/paginas/registro.jsp";
        List<Municipio> listaMunicipios = fachadaBO.consultaListaMunicipios();
        request.setAttribute("listaMunicipios", listaMunicipios);
        this.getServletContext()
                .getRequestDispatcher(pagina)
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("iniciar-sesion")) {
            this.proccessLogin(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("registrar")) {
            try {
                this.processRegistration(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
    }

    private void proccessLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            HttpSession sesion = request.getSession();

        // EXTRAER DATOS
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        password=encriptador.encriptar(password);

        // VALIDAR DATOS
        if (email == null || email.isBlank() || email.trim().length() > 255
                || password == null || password.isBlank() || password.trim().length() > 255) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        // PROCESAR NEGOCIO
        try {
            Usuario usuario = fachadaBO.consultarUsuarioParaLogin(email, password);
            if (usuario == null) {
                getServletContext().getRequestDispatcher("/paginas/login.jsp").forward(request, response);
                return;
            }

            if (usuario instanceof Normal) {
                sesion.setAttribute("tipoUsuario", "normal");
            }

            if (usuario instanceof Administrador) {
                sesion.setAttribute("tipoUsuario", "administrador");
            }
            // GENERAR RESPUESTA

            sesion.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/posts?action=ver-publicaciones");
        } catch (BOException e) {
            // Manejar la excepción adecuadamente
            getServletContext()
                    .getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        }
    }

    private void proccessLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("usuario");
        session.invalidate();

        getServletContext().getRequestDispatcher("/paginas/login.jsp").forward(request, response);
    }

    private void processRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String ciudad = request.getParameter("ciudad");
        String municipio = request.getParameter("municipio");
        String correo = request.getParameter("correo");
        String celular = request.getParameter("celular");
        String contrasena = request.getParameter("contrasena");
        String confirmarContrasena = request.getParameter("confirmar-contrasena");
        String genero = request.getParameter("genero");
        byte[] imagen = processImage(request,response);
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        List<Estado> listaMunicipios = fachadaBO.consultaListaEstados();
        request.setAttribute("listaMunicipios", listaMunicipios);
        Map<String, String[]> parametros = request.getParameterMap();
        for (String key : parametros.keySet()) {
            String[] strArr = (String[]) parametros.get(key);
            for (String val : strArr) {
                request.setAttribute(key, val);
            }
        }
        if (validarNombre(nombre, request) && validarApellido(apellido, request) && validarCiudad(ciudad, request)
                && validarMunicipio(municipio, request) && validarCorreo(correo, request) && validarCelular(celular, request)
                && validarContrasena(contrasena, confirmarContrasena, request) && validarGenero(genero, request)
                && validarFecha(fechaNacimiento, request)) {
           
            Calendar fechaNacimientoUsuario = convertirCalendar(fechaNacimiento);
            Municipio municipioUser = fachadaBO.buscarMunicipioNombre(municipio);
            Genero generoUser= consultarGenero(genero);
            contrasena=encriptador.encriptar(contrasena);
            Normal user = new Normal(nombre, apellido, imagen,generoUser,fechaNacimientoUsuario, celular, ciudad, correo, contrasena, municipioUser);
            fachadaBO.registrarUsuarioNormal(user);
        } else {
            getServletContext().getRequestDispatcher("/paginas/registro.jsp").forward(request, response);
            return;
        } 
        getServletContext().getRequestDispatcher("/paginas/login.jsp").forward(request, response);
    }

    private Calendar convertirCalendar(String fechaNacimiento) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date = dateFormat.parse(fechaNacimiento);
        calendar.setTime(date);
        return calendar;
    }

    private boolean validarNombre(String nombre, HttpServletRequest request) {
        if (nombre==null) {
            request.setAttribute("error", "Ingrese un nombre");
            return false;
        }
        if (nombre.length() > 50) {
            request.setAttribute("error", "El nombre es demasiado largo");
            return false;
        }
        return true;
    }

    private boolean validarApellido(String apellido, HttpServletRequest request) {
        if (apellido==null) {
            request.setAttribute("error", "Ingrese un apellido");
            return false;
        }
        if (apellido.length() > 50) {
            request.setAttribute("error", "El apellido es demasiado largo");
            return false;

        }
        return true;
    }

    private boolean validarCiudad(String ciudad, HttpServletRequest request) {
        if (ciudad.isBlank()) {
            request.setAttribute("error", "Ingrese una ciudad");
            return false;
        }
        if (ciudad.length() > 50) {
            request.setAttribute("error", "La ciudad es demasiado larga");
            return false;

        }

        return true;
    }

    private boolean validarMunicipio(String estado, HttpServletRequest request) {
        if (estado.isEmpty()) {
            request.setAttribute("error", "Seleccione un municipio");
            return false;
        }
        return true;
    }

    private boolean validarCelular(String celular, HttpServletRequest request) {
        if (celular.isBlank()) {
            request.setAttribute("error", "Ingrese un numero de celular");
            return false;
        }
        if (celular.length() != 10) {
            request.setAttribute("error", "Ingrese un numero de celular valido (10 numeros)");
            return false;

        }
        return true;
    }

    private boolean validarCorreo(String correo, HttpServletRequest request) {
        if (correo.isBlank()) {
            request.setAttribute("error", "Ingrese un correo");
            return false;
        }
        if (correo.length() > 50) {
            request.setAttribute("error", "El correo no es valido");
            return false;

        }
        return true;
    }

    private boolean validarContrasena(String contrasena, String confirmarContrasena, HttpServletRequest request) {
        if (!contrasena.equals(confirmarContrasena)) {
            request.setAttribute("error", "Las contraseñas no coinciden");
            return false;
        }
        if (contrasena.isBlank() || confirmarContrasena.isBlank()) {
            request.setAttribute("error", "Ingrese una contraseña valida");
            return false;
        }
        if (contrasena.length() < 8) {
            request.setAttribute("error", "Contraseña muy corta");
            return false;

        }
        return true;
    }

    private boolean validarGenero(String genero, HttpServletRequest request) {
        if (genero == null) {
            request.setAttribute("error", "Seleccione un genero");
            return false;
        }
        return true;
    }

    private boolean validarFecha(String fechaNacimiento, HttpServletRequest request) {
        if (fechaNacimiento.isBlank()) {
            request.setAttribute("error", "Seleccione una fecha de nacimiento");
            return false;
        }
        return true;
    }

   

    private Genero consultarGenero(String genero) {
        if (genero.equals("MASCULINO")) {
            return Genero.MASCULINO;
        }
        return Genero.FEMENINO;
    }

     private byte[] processImage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      InputStream imageStream = request.getPart("imageFile").getInputStream();
      byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        while ((bytesRead = imageStream.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
