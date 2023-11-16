/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.pruebasservlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // Size threshold for storing files in memory
    maxFileSize = 5 * 1024 * 1024, // Maximum file size allowed
    maxRequestSize = 20 * 1024 * 1024 // Maximum request size allowed
)
@WebServlet(name = "ImageServlet", urlPatterns = {"/imageServlet"})
public class ImageServlet extends HttpServlet {

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
            out.print("hola");
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
        String action=request.getParameter("action");
        if (action!=null || action.equalsIgnoreCase("subir")) {
            processImage(request, response);
            return;
        }
        if (action!=null || action.equalsIgnoreCase("cargar")) {
            if () {
                
            }
            showImage(request, response);
            return;
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
        String action=request.getParameter("action");
        if (action!=null || action.equalsIgnoreCase("subir")) {
            processImage(request, response);
            return;
        }

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

    private void processImage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Retrieve the input stream of the uploaded image file
        InputStream imageStream = request.getPart("imageFile").getInputStream();

        // Convert the image stream to byte array
        byte[] imageBytes = convertInputStreamToBytes(imageStream);
        request.setAttribute("bytes", imageBytes);
        getServletContext().getRequestDispatcher("/imagen.jsp").forward(request, response);
        return;
        // Write the image data to the response output stream
        // Optionally, you can send a response back to the client
    }

    private byte[] convertInputStreamToBytes(InputStream inputStream) throws IOException {
        // Read the image stream and convert it into a byte array
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }

        return output.toByteArray();
    }
}
