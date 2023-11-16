<%-- 
    Document   : perfil
    Created on : 30 jun. 2023, 11:09:01 p. m.
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Perfil</title>
        <link rel="shortcut icon" href="./iconos/LogoTipo_app-icon.ico"/>
        <link rel="stylesheet" href="./estilos/perfil_styles.css">
    </head>
    <body>
        <header class="cabecera">
            <div class="nombre-aplicacion">
                <div class="titulo-aplicacion">
                    <h2>TalkBoard</h2>
                </div>
                <div class="imagen-aplicacion">
                    <a href="./posts?action=ver-publicaciones"><img src="./iconos/LogoTipo_app-png.png" alt="Logo"></a>
                </div>
            </div>
            <nav class="navegador-cabecera">
                <div class="ver-publicaciones">
                    <a href="./posts?action=ver-publicaciones"><img src="./iconos/home-icon.png" alt="ver-publicaciones"></a>
                </div>
                <div class="salir">
                    <a href="./usuario?action=logout"><img src="./iconos/exit-icon.png" alt="Salir"></a>
                </div>
            </nav>
        </header>
        <section>
            <div class="Container">
                <div class="Barra-lateral-izq">
                    <div class="Imagen-perfil">
                        <c:if test="${sessionScope.usuario.imagenUsuario == null}">
                            <div class="Imagen">
                                <img src="./iconos/icono-perfil-default.jpg" alt="yo">
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.usuario.imagenUsuario != null}">
                            <div class="Imagen">
                                <img src="./picture?action=avatar&idUsuario=${sessionScope.usuario.id}" alt="Mi foto">
                            </div>
                        </c:if>
                    </div>
                    <div class="Datos-personales">
                        <div class="Nombre">
                            <Label id="titulo">Nombre: <p id="contenido">${sessionScope.usuario.getNombreCompleto()}</p></Label>
                        </div>
                        <div class="Fecha-nacimiento">
                            <Label id="titulo">Fecha de nacimiento: <p id="contenido">${sessionScope.usuario.getFechaNacimientoToString()}</p></Label>
                        </div>
                        <div class="Genero">
                            <Label id="titulo">Genero: <p id="contenido">${sessionScope.usuario.genero}</p></Label>
                        </div>
                        <div class="Ciudad">
                            <Label id="titulo">Ciudad: <p id="contenido">${sessionScope.usuario.ciudad}</p></Label>
                        </div>
                        <div class="Correo">
                            <Label id="titulo">Correo: <p id="contenido">${sessionScope.usuario.correo}</p></Label>
                        </div>
                    </div>
                </div>
                <div class="Publicaciones-usuario">
                    <div class="Contenedor-publicaciones">
                        <c:if test="${sessionScope.tipoUsuario=='administrador'}">                            
                            <c:forEach items="${sessionScope.usuario.listaPostAnclados}" var="post">
                                <div class="Post">
                                    <div class="Encabezado-post">
                                        <div class="Titulo-post">
                                            <div class="Datos-post">
                                                <h3><span id="titulo-post-${post.id}"><c:out value="${post.titulo}"/></span></h3>
                                                <p>${post.getAdministrador().getNombreCompleto()}</p>
                                            </div>
                                            <div class="FechaCreacion">
                                                <p>${post.getFechaCreacionToString()}</p>
                                            </div>
                                        </div> 
                                        <%@include file="../WEB-INF/jspf/opciones-post-usuario-administrador.jspf" %>
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
                                    </article>
                                    <div class="Imagen-anclado-post">
                                        <img src="./iconos/anchor-icon.png" alt="anclado"/>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                        <c:forEach items="${sessionScope.usuario.listaPostComunes}" var="post">
                            <div class="Post">
                                <div class="Encabezado-post">
                                    <div class="Titulo-post">
                                        <div class="Datos-post">
                                            <h3><span id="titulo-post-${post.id}"><c:out value="${post.titulo}"/></span></h3>
                                            <p>${post.usuario.getNombreCompleto()}</p>
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
                                                <summary>Comentar<img src="./iconos/comentario-icon.png" alt="icono-comentario"></summary>
                                                <div class="Comentar">
                                                    <div class="Form-comentario">
                                                        <form id="comentarioForm">
                                                            <div class="Input-Comentario">
                                                                <input type="text" name="comentario" placeholder="Escribe algo...">
                                                            </div>
                                                            <div class="Enviar-comentario">
                                                                <button type="button"><img src="./iconos/send-icon.png" alt="Enviar"></button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <div class="Comentarios">
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
                                                                                        <p><c:out value="${comentario.contenido}" /></p>
                                                                                    </div>
                                                                                </div>
                                                                            </div> 
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
                    </div>
                </div>
            </div>
        </section>
        <footer></footer>
        <script src="./scripts/crud.js"></script>
    </body>
</html>