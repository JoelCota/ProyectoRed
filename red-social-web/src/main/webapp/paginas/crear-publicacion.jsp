<%-- 
    Document   : crear-publicacion
    Created on : 24 jun 2023, 22:06:15
    Author     : oscar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.itson.red.dominio.Administrador" %>
<!DOCTYPE html>
<html lang="es-MX">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crear publicación</title>
        <link rel="shortcut icon" href="./iconos/LogoTipo_app-icon.ico"/>
        <link rel="stylesheet" href="./estilos/crear-publicacion.css">
    </head>
    <body>
        <main class="main">
            <section class="main__section">
                <div class="main__section-container">
                    <form class="main__section-form" method="POST" action="posts?action=create&idUsuario=${sessionScope.usuario.id}">
                        <div class="main__section-form-titulo">
                            <label class="main__section-form-titulo-label" for="titulo">Título:</label>
                            <c:if test="${requestScope.titulo != null}">
                                <input class="main__section-form-titulo-input" type="text" name="titulo" id="titulo" placeholder="Escribe un título" value="${requestScope.titulo}">
                            </c:if>
                            <c:if test="${requestScope.titulo == null}">
                                <input class="main__section-form-titulo-input" type="text" name="titulo" id="titulo" placeholder="Escribe un título">
                            </c:if>
                        </div>
                        <div class="main__section-form-contenido">
                            <label class="main__section-form-contenido-label" for="contenido">Contenido:</label>
                            <c:if test="${requestScope.contenido != null}">
                                <textarea class="main__section-form-contenido-textarea" name="contenido" id="contenido" cols="30" rows="10" placeholder="¿Qué estás pensando?">${requestScope.contenido}</textarea>
                            </c:if>
                            <c:if test="${requestScope.contenido == null}">
                                <textarea class="main__section-form-contenido-textarea" name="contenido" id="contenido" cols="30" rows="10" placeholder="¿Qué estás pensando?"></textarea>
                            </c:if>
                        </div>
                        <div class="main__section-form-publicar">
                            <button class="main__section-form-publicar-confirmar" id="btn-guardar-post" type="button">Publicar</button>
                            <c:if test="${sessionScope.usuario.getClass().simpleName eq 'Administrador'}">
                                <%@include file="../WEB-INF/jspf/opcionAnclar.jspf" %>
                            </c:if>
                            <div class="main__section-form-publicar-cancelar" id="btn-cancelar-post"><a href="./posts?action=ver-publicaciones">Cancelar</a></div>
                        </div>
                    </form>
                </div>
            </section>
        </main>
        <script src="./scripts/publicar-post.js" type="module"></script>
    </body>
</html>
