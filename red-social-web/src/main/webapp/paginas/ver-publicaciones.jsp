<%-- 
    Document   : Ver-publicaciones
    Created on : Jun 24, 2023, 1:09:41 PM
    Author     : Daniel Armando Peña Garcia ID:229185
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-MX">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio</title>
        <link rel="shortcut icon" href="./iconos/LogoTipo_app-icon.ico"/>
        <link rel="stylesheet" href="./estilos/ver-publicaciones-style.css"/>
    </head>

    <body>
        <header class="Cabecera">
            <div class="nombre-aplicacion">
                <div class="titulo-aplicacion">
                    <h2>TalkBoard</h2>
                </div>
                <div class="imagen-aplicacion">
                    <img src="./iconos/LogoTipo_app-png.png" alt="Salir">
                </div>
            </div>
            <div class="Buscador-header">
                <div class="contenedor-buscador">
                    <form>
                        <input id="buscador-input" type="text" placeholder="Qué buscas?">
                    </form>
                    <button id="buscador-button" type="button"><img src="./iconos/forget-icon.png" alt="lupa"/></button>
                </div>
            </div>
            <nav class="Navegador-cabecera">
                <div class="Mi-perfil">
                    <!-- Esto dirige al perfil del usuario -->
                    <a href="./usuario?action=irPerfil"> <img id="avatar" src="./iconos/user-icon.png" alt="Usuario"></a>
                </div>
                <div class="Salir">
                    <a href="./usuario?action=logout"><img src="./iconos/exit-icon.png" alt="Salir"></a>
                </div>
            </nav>
        </header>
        <section>
            <aside>
                <div class="Form-orden-post">
                    <div class="Informacion-session">
                        <div class="Bienvenida-usuario">
                            <h4>Te damos la bienvenida</h4>
                        </div>
                        <div class="Imagen-usuario">
                            <c:if test="${sessionScope.usuario.imagenUsuario == null}">
                                <img src="./iconos/icono-perfil-default.jpg" alt="Mi foto">
                            </c:if>
                            <c:if test="${sessionScope.usuario.imagenUsuario != null}">
                                <img src="./picture?action=avatar&idUsuario=${sessionScope.usuario.id}" alt="Mi foto">
                            </c:if>
                        </div>
                        <div class="Nombre-usuario-session">
                            <p>${sessionScope.usuario.nombres}</p>
                            <p>${sessionScope.usuario.apellidos}</p>
                        </div>
                    </div>
                    <form class="form-crear-publicacion">
                        <div type="button" class="Button-crear-publicacion">
                            <a href="./posts?action=crear-publicacion">Crear Post</a>
                            <img src="./iconos/pencil-icon.png" alt="Subir">
                        </div>
                    </form>
                </div>
            </aside>
            <main>
                <c:forEach items="${requestScope.anclados}" var="post">
                    <div class="Post" id="Post-${post.id}">
                        <div class="Encabezado-post">
                            <div class="Titulo-post">
                                <div class="Datos-post">
                                    <h3><span id="titulo-post-${post.id}"><c:out value="${post.titulo}"/></span></h3>
                                    <p><c:out value="${post.getAdministrador().getNombreCompleto()}" /></p>
                                </div>
                                <div class="FechaCreacion">
                                    <p>${post.getFechaCreacionToString()}</p>
                                </div>
                            </div>
                            <c:if test="${sessionScope.usuario.id == post.getAdministrador().id}">
                                <%@include file="../WEB-INF/jspf/opciones-post-usuario-administrador.jspf"%>
                            </c:if>             
                        </div>
                        <article>
                            <div class="Post-contenido">
                                <div class="Contenido">
                                    <p><span id="contenido-post-${post.id}" contenteditable="false">${post.contenido}</span></p>
                                </div>
                                <div class="button-actualizar">
                                    <button id="actualizar-post-${post.id}" hidden><img src="./iconos/update-icon.png" alt="Enviar"></button>
                                </div>
                            </div>
                        </article>
                        <div class="Imagen-anclado-post">
                            <img src="./iconos/anchor-icon.png" alt="anclado"/>
                        </div>
                    </div>
                </c:forEach>
                <c:forEach items="${requestScope.comunes}" var="post">
                    <div class="Post" id="Post-${post.id}">
                        <div class="Encabezado-post">
                            <div class="Titulo-post">
                                <div class="Datos-post">
                                    <h3><span id="titulo-post-${post.id}"><c:out value="${post.titulo}"/></span></h3>
                                    <p><c:out value="${post.usuario.getNombreCompleto()}" /></p>
                                </div>
                                <div class="FechaCreacion">
                                    <p>${post.getFechaCreacionToString()}</p>
                                </div>
                            </div>
                            <c:if test="${sessionScope.usuario.id == post.getUsuario().id && sessionScope.tipoUsuario == 'normal'}">
                                <%@include file="../WEB-INF/jspf/opciones-post-usuario-normal.jspf" %>
                            </c:if>
                            <c:if test="${sessionScope.usuario.id == post.getUsuario().id && sessionScope.tipoUsuario == 'administrador'}">
                                <%@include file="../WEB-INF/jspf/opciones-post-usuario-normal.jspf" %>
                            </c:if>
                        </div>
                        <article>
                            <div class="Post-contenido">
                                <div class="Contenido">
                                    <p><span id="contenido-post-${post.id}" contenteditable="false"><c:out value="${post.contenido}" /></span></p>
                                </div>
                                <div class="button-actualizar">
                                    <button id="actualizar-post-${post.id}" hidden><img src="./iconos/update-icon.png" alt="Enviar"></button>
                                </div>
                            </div>
                            <div class="Post-comentarios">
                                <div class="Abrir-comentarios">
                                    <details>
                                        <c:if test="${sessionScope.tipoUsuario == 'normal'}">
                                            <summary>Comentar<img src="./iconos/comentario-icon.png" alt="icono-comentario"></summary>
                                            <div class="Comentar">
                                                <div class="Form-comentario">
                                                    <form id="comentarioForm">
                                                        <div class="Input-Comentario">
                                                            <input type="text" name="comentario" id="input-comentar-post-${post.id}" placeholder="Escribe algo...">
                                                        </div>
                                                        <div class="Enviar-comentario">
                                                            <button class="btn-enviar-comentario" type="button" id="btn-comentar-${post.id}"><img src="./iconos/send-icon.png" alt="Enviar"></button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${sessionScope.tipoUsuario == 'administrador'}">
                                            <summary>Comentarios<img src="./iconos/comentario-icon.png" alt="icono-comentario"></summary>
                                            </c:if>
                                        <div class="Comentarios" id="comentario-${post.id}">
                                            <c:forEach items="${post.comentarios}" var="comentario">
                                                <div class="Comentario">
                                                    <div class="Comentario-parte-superior">
                                                        <div class="Contenido-comentario">
                                                            <div class="Nombre-usuario-comentario">
                                                                <label for="nombre-usuario-comentario">
                                                                    ${comentario.usuarioNormal.getNombreCompleto()}
                                                                </label>
                                                            </div>
                                                            <div class="Contenido-mensaje-comentario">
                                                                <p><c:out value="${comentario.contenido}" /></p>
                                                            </div>
                                                        </div>
                                                        <c:if test = "${sessionScope.usuario.id == comentario.usuarioNormal.id}">
                                                            <%@include file="../WEB-INF/jspf/opciones-comentario.jspf" %>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="Comentario-parte-inferior">
                                                    <div class="Abrir-respuestas">
                                                        <details>
                                                            <summary>Responder</summary>
                                                            <div class="Responder-comentario">
                                                                <div class="Form-respuesta-comentario">
                                                                    <form>
                                                                        <div class="Input-respuesta">
                                                                            <input type="text" name = "respuesta" placeholder="Escribe algo...">
                                                                        </div>
                                                                        <div class="Enviar-respuesta">
                                                                            <button type="button"><img src="./iconos/send-icon.png"
                                                                                                       alt="Enviar"></button>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                            <div class="Respuestas-comentario">
                                                                <c:forEach items="${comentario.respuestas}" var="respuesta">
                                                                    <div class="Respuesta">
                                                                        <div class="Contenido-respuesta">
                                                                            <div class="Nombre-usuario-respuesta">
                                                                                <label for="nombre-usuario-respuesta">
                                                                                    ${respuesta.usuarioNormal.getNombreCompleto()}
                                                                                </label>
                                                                            </div>
                                                                            <div class="Contenido-mensaje-respuesta">
                                                                                <p><c:out value="${respuesta.contenido}" /></p>
                                                                            </div>
                                                                        </div>
                                                                    </div> 
                                                                    <c:if test="${respuesta.getUsuarioNormal().id == sessionScope.usuario.id}">
                                                                        <%@include file="../WEB-INF/jspf/opciones-respuesta.jspf" %>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </div>
                                                        </details>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </details>
                                </div>
                            </div>
                        </article>
                    </div>
                </c:forEach>
            </main>
            <div class="Paginado">
                <div class="Imagen-paginado">
                    <c:if test="${requestScope.pagina != null && requestScope.atras == true}">
                        <a href="./posts?action=ver-publicaciones-anterior&pagina=${requestScope.pagina-1}"><img src="./iconos/arrow-left.png" alt="Anterior"></a>
                        </c:if>
                        <c:if test="${requestScope.pagina ==  null  || requestScope.atras == false}">
                        <a href="./posts?action=ver-publicaciones"><img src="./iconos/arrow-left.png" alt="Anterior"></a>
                        </c:if>
                </div>
                <div class="Imagen-paginado">
                    <c:if test="${requestScope.pagina != null && requestScope.siguiente == true}">
                        <a href="./posts?action=ver-publicaciones-siguiente&pagina=${requestScope.pagina+1}"><img src="./iconos/arrow-rigth.png" alt="Siguiente"></a>
                        </c:if>
                        <c:if test="${requestScope.pagina ==  null || requestScope.siguiente == false}">
                        <a href="./posts?action=ver-publicaciones-siguiente&pagina=1"><img src="./iconos/arrow-rigth.png" alt="Siguiente"></a>
                        </c:if>
                </div>
            </div>
        </section>
        <footer></footer>
        <script src="./scripts/eliminar-post.js"></script>
        <script src="./scripts/crud.js"></script>
    </body>
</html>
