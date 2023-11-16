/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.servlets;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.itson.implementaciones.FachadaBO;

/**
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // Size threshold for storing files in memory
    maxFileSize = 5 * 1024 * 1024, // Maximum file size allowed
    maxRequestSize = 20 * 1024 * 1024 // Maximum request size allowed
)
@WebServlet(name = "picture", urlPatterns = {"/picture"})
public class PictureServlet extends HttpServlet {
    FachadaBO fachadaBO = new FachadaBO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PictureServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PictureServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
          String actionParam = request.getParameter("action");
        // /pictures?action=avatar&id=6498a7ebce302d27e8c99b2e
        if (actionParam != null && actionParam.equalsIgnoreCase("avatar")) {
         this.showPicture(request, response);
        }
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
        processRequest(request, response);
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

    private void showPicture(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Retrieve the input stream of the uploaded image file
        Long idUsuario=Long.valueOf(request.getParameter("idUsuario"));
        // Convert the image stream to byte array
        byte[] imageBytes = fachadaBO.consultarUsuarioPorId(idUsuario).getImagenUsuario();
        // Write the image data to the response output stream
         try (OutputStream out = response.getOutputStream()) {
            out.write(imageBytes);
            out.flush();
        } catch (IOException ex) {
            // TODO redirect to java error page.
            return;
        }
       
    }

}
