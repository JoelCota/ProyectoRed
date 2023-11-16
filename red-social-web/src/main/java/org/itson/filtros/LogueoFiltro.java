/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package org.itson.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebFilter(filterName = "LogueoFiltro", urlPatterns = {"/*"})
public class LogueoFiltro implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    @Override
    public void destroy() {
    }
    private final static String[] pathsPublicos = { "index.html", "login.jsp", "registro.jsp", "usuario", "iconos", "estilos", "scripts","picture", "comentarioV2Servlet", "publicacionesV2Servlet"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String path = this.getPathSolicitado(httpRequest);
        boolean isPathPrivado = this.isPathPrivado(path);
        boolean isUsuarioLogueado = this.isUsuarioLogueado(httpRequest);
        if(isPathPrivado && !isUsuarioLogueado){
            request.getServletContext()
                    .getRequestDispatcher("/paginas/login.jsp")
                    .forward(request, response);
            return;
        }
        // avanza normalmente
        chain.doFilter(request, response);
    }
    
    private String getPathSolicitado(HttpServletRequest request){
        String uriSolicitada = request.getRequestURI();
        String path = uriSolicitada.substring(request.getContextPath().length());
        return path;
    }
    
    private boolean isPathPrivado(String path){
        for(String pathPublico: LogueoFiltro.pathsPublicos){
            if(path.startsWith("/"+pathPublico)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isUsuarioLogueado(HttpServletRequest request){
        HttpSession sesion = request.getSession(false);
        return (sesion != null && sesion.getAttribute("usuario") != null);
    }
    
}
