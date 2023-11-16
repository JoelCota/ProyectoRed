<%-- 
    Document   : registro
    Created on : Jun 23, 2023, 12:52:56 PM
    Author     : Joel Antonio Lopez Cota ID:228926
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse</title>
        <link rel="shortcut icon" href="./iconos/LogoTipo_app-icon.ico"/>
        <link rel="stylesheet" href="./estilos/registro_styles.css"/>
        <script src="./scripts/registrar-usuario.js"></script>
    </head>
    <body>
        <header class="header-web">
            <div class="header_titulo-aplicacion">
                <h2>Talk Board</h2>
            </div>
        </header>
        <section>
            <c:if test="${requestScope.error != null}">
                <div class="error">
                    <span>
                        ${requestScope.error}
                    </span>
                </div>
            </c:if>
            <div class="container">
                <header>
                    <div class="titulo-registrar">
                        <h4>Registrarme</h4>
                    </div>
                </header>
                <form enctype="multipart/form-data">
                    <div class="dos-columnas">
                        <div class="nombre">
                            <div class="input-nombre">
                                <input type="text" name="nombre" placeholder="Nombre" maxlength="50 requiered value="${requestScope.nombre}">
                            </div>
                        </div>
                        <div class="apellido">
                            <div class="input-apellido">
                                <input type="text" name="apellido" placeholder="Apellido" maxlength="50" requiered value="${requestScope.apellido}">
                            </div>
                        </div>
                    </div>
                    <div class="dos-columnas">
                        <div class="Ciudad">
                            <div class="input-ciudad">
                                <input type="text" name="ciudad" placeholder="Ciudad" maxlength="25" requiered value="${requestScope.ciudad}">
                            </div>
                        </div>
                        <div class="municipio">
                            <div class="select-municipio">
                                <select name="municipio" id="municipio"  >
                                    <c:forEach items="${requestScope.listaMunicipios}" var="municipio">
                                        <option value=${municipio.nombre}>${municipio.nombre}</option>   
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="dos-columnas">
                        <div class="email">
                            <div class="input-email">
                                <input type="email" name="correo" placeholder="Correo" maxlength="50" requiered value="${requestScope.correo}">
                            </div>
                        </div>
                        <div class="celular">
                            <div class="input-celular">
                                <input type="tel" name="celular" placeholder="Celular" min="0" maxlength="15" requiered value="${requestScope.celular}"> 
                            </div>
                        </div>
                    </div>
                    <div class="dos-columnas">
                        <div class="contrasena">
                            <div class="input-contrasena">
                                <input type="password" name="contrasena" placeholder="Contraseña" requiered>
                            </div>
                        </div>
                        <div class="confirmar-contrasena">
                            <div class="input-contrasena">
                                <input type="password" name="confirmar-contrasena" placeholder="Confirmar contraseña" requiered>
                            </div>
                        </div>
                    </div>
                    <div class="dos-columnas">
                        <div class="genero">
                            <div class="label-genero">
                                <label for="#">Genero</label>
                            </div>
                            <div class="input-radio-genero">
                                
                                <div class="genero-masculino">
                                    <input type="radio" name="genero" id="masculino" value="MASCULINO" requiered>
                                    <label for="masculino" id="genero">
                                        Masculino
                                    </label>
                                </div>
                                <div class="genero-masculino">
                                    <input type="radio" name="genero" id="femenino" value="FEMENINO" requiered>
                                    <label for="femenino" id="genero">
                                        Femenino
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="fecha-nacimiento">
                            <div class="label-fecha-nacimiento">
                                <label for="fechaNacimiento">Fecha de nacimiento</label>
                            </div>
                            <div class="input-date-fecha-nacimiento">
                                <input type="date" name="fechaNacimiento" id="fecha-nacimiento"  min="1960-01-01" max="2023-12-31" requiered value="${requestScope.fechaNacimiento}">
                            </div>
                        </div>
                    </div>
                    <div class="una-columna">
                        <div class="input-imagen-perfil">
                            <input type="file" name="imageFile" id="imagen-perfil"  accept="image/*">
                        </div>
                    </div>
                    <div class="dos-columnas">
                        <div class="iniciar-sesion">
                            <p>Ya tengo cuenta</p>
                            <a href="usuario?action=login" formmethod="get">Iniciar Sesión</a>
                        </div>
                        <div class="enviar-formulario">
                            <div class="input-submit">
                                <button type="submit" formaction="usuario?action=registrar" formmethod="post">Register</button>             
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
</html>
