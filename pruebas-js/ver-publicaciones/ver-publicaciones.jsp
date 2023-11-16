<%-- 
    Document   : Ver-publicaciones
    Created on : Jun 24, 2023, 1:09:41 PM
    Author     : Daniel Armando Peña Garcia ID:229185
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

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
                    <form action="action">
                        <input type="text" placeholder="Qué buscas?">
                    </form>
                    <img src="./iconos/forget-icon.png" alt="lupa"/>
                </div>
            </div>
            <nav class="Navegador-cabecera">
                <div class="Mi-perfil">
                    <!-- Esto dirige al perfil del usuario -->
                    <a href="./usuario?action=irPerfil"><img src="./iconos/user-icon.png" alt="Usuario"></a>
                </div>
                <div class="Salir">
                    <a href="./usuario?action=logout"><img src="./iconos/exit-icon.png" alt="Salir"></a>
                </div>
            </nav>
        </header>
        <section>
            <aside>
                <div class="Form-orden-post">
                    <form>
                        <input type="text" name="action" value="crear-publicacion" hidden>
                        <button type="submit"  formaction="posts" formmethod="get">
                            Crear Post
                            <img src="./iconos/pencil-icon.png" alt="Subir">
                        </button>
                        <button type="submit">
                            Ver anclados
                            <img src="./iconos/anchor-icon.png" alt="Anclados">
                        </button>
                        <button type="submit">
                            Ver comunes 
                            <img src="./iconos/calendar-icon.png" alt="Subir">
                        </button>
                    </form>
                </div>
            </aside>
            <main>
                <c:forEach items="${requestScope.anclados}" var="post">
                    <div class="Post">
                        <div class="Encabezado-post">
                            <div class="Titulo-post">
                                <h3>${post.titulo}</h3>
                                <p>${post.getAdministrador().getNombreCompleto()}</p>
                             </div>
                                <c:if test="${sessionScope.usuario.id == post.getAdministrador().getId()}">
                                <%@include file="../WEB-INF/jspf/opcionesAnclado.jspf" %>
                            </c:if>
                        </div>
                        <article>
                            <div class="Post-contenido">
                                <div class="Contenido">
                                    <p>${post.contenido}</p>
                                </div>
                            </div>
                        </article>
                    </div>
                </c:forEach>
                <c:forEach items="${requestScope.comunes}" var="post">
                    <div class="Post">
                        <div class="Encabezado-post">
                            <div class="Titulo-post">
                                <h3>${post.titulo}</h3>
                                <p>${post.usuario.getNombreCompleto()}</p>
                            </div>
                            <c:if test="${sessionScope.usuario.id == post.getUsuario().id}">
                                <%@include file="../WEB-INF/jspf/opcionesPostComunes.jspf" %>
                            </c:if>
                        </div>
                        <article>
                            <div class="Post-contenido">
                                <div class="Contenido">
                                    <p>${post.contenido}</p>
                                </div>
                            </div>
                            <div class="Post-comentarios">
                                <div class="Abrir-comentarios">
                                    <details>
                                        <summary>Comentar<img src="./iconos/comentario-icon.png" alt="icono-comentario"></summary>
                                        <div class="Comentar">
                                            <div class="Form-comentario">
                                                <form id="comentarioForm" action="./comentarios?action=comentar&idPost=${post.id}&idUsuario=${sessionScope.usuario.id}" method="post">
                                                    <div class="Input-Comentario">
                                                        <input type="text" name="comentario" placeholder="Escribe algo...">
                                                    </div>
                                                    <div class="Enviar-comentario">
                                                        <button type="submit"><img src="./iconos/send-icon.png" alt="Enviar"></button>
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
                                                                <p>${comentario.contenido}</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <c:if test = "${sessionScope.usuario.id == comentario.usuarioNormal.id}">

                                                    </c:if>
                                                </div>
                                                <div class="Comentario-parte-inferior">
                                                    <div class="Abrir-respuestas">
                                                        <details>
                                                            <summary>Responder</summary>
                                                            <div class="Responder-comentario">
                                                                <div class="Form-respuesta-comentario">
                                                                    <form action="./comentarios?action=responder&idComentario=${comentario.id}&idUsuario=${requestScope.usuario.id}" method="post">
                                                                        <div class="Input-respuesta">
                                                                            <input type="text" name = "respuesta" placeholder="Escribe algo...">
                                                                        </div>
                                                                        <div class="Enviar-respuesta">
                                                                            <button type="submit"><img src="./iconos/send-icon.png"
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
                                                                                <p>${respuesta.contenido}</p>
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
                <div class="Post">
                    <div class="Encabezado-post">
                        <div class="Titulo-post">
                            <h3>Usuario admin</h3>
                        </div>
                        <div class="Opciones-post">
                            <details>
                                <summary>•••</summary>
                                <div class="Opciones-details">
                                    <ul>
                                        <li>Anclar</li>
                                        <li>Desanclar</li>
                                        <li>Eliminar</li>
                                    </ul>
                                </div>
                            </details>
                        </div>
                    </div>
                    <article>
                        <div class="Post-contenido">
                            <div class="Contenido">
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Harum, neque iure deserunt
                                    possimus quia odit vero dolor officiis aperiam quibusdam, eius rerum asperiores
                                    provident dolores hic distinctio nostrum quis ea?</p>
                            </div>
                        </div>
                        <div class="Post-comentarios">
                            <div class="Abrir-comentarios">
                                <details>
                                    <summary>Comentarios<img src="./iconos/comentario-icon.png" alt="icono-comentario"></summary>
                                    <div class="Comentarios">
                                        <div class="Comentario">
                                            <div class="Comentario-parte-superior">
                                                <div class="Contenido-comentario">
                                                    <div class="Nombre-usuario-comentario">
                                                        <label for="nombre-usuario-comentario">
                                                            Nombre usuario
                                                        </label>
                                                    </div>
                                                    <div class="Contenido-mensaje-comentario">
                                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Earum
                                                            accusamus rem veritatis neque aspernatur. Eos animi, repudiandae
                                                            aliquid vitae illo, libero reiciendis ratione quod, eaque maxime
                                                            beatae cumque in recusandae?</p>
                                                    </div>
                                                </div>
                                                <div class="Opciones-respuesta">
                                                    <div class="Opciones">
                                                        <details>
                                                            <summary>•••</summary>
                                                            <div class="Opciones-details">
                                                                <ul>
                                                                    <li>Eliminar</li>
                                                                </ul>
                                                            </div>
                                                        </details>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="Comentario-parte-inferior">
                                            <div class="Abrir-respuestas">
                                                <details>
                                                    <summary>Respuestas</summary>
                                                    <div class="Respuestas-comentario">
                                                        <div class="Respuesta">
                                                            <div class="Contenido-respuesta">
                                                                <div class="Nombre-usuario-respuesta">
                                                                    <label for="nombre-usuario-respuesta">
                                                                        Nombre usuario respuesta
                                                                    </label>
                                                                </div>
                                                                <div class="Contenido-mensaje-respuesta">
                                                                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing
                                                                        elit. Necessitatibus est dolores, nihil ipsam
                                                                        tempore recusandae odit alias ab suscipit quidem
                                                                        accusamus dolorem qui eos. Magni dolore cum atque
                                                                        voluptate laborum.</p>
                                                                </div>
                                                            </div>
                                                            <div class="Opciones-respuesta">
                                                                <div class="Opciones">
                                                                    <details>
                                                                        <summary>•••</summary>
                                                                        <div class="Opciones-details">
                                                                            <ul>
                                                                                <li>Eliminar</li>
                                                                            </ul>
                                                                        </div>
                                                                    </details>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </details>
                                            </div>
                                        </div>
                                    </div>
                                </details>
                            </div>
                        </div>
                    </article>
                </div>
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
    </body>
</html>
