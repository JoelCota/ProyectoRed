<%-- 
    Document   : login
    Created on : 24 jun. 2023, 5:18:14 p. m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="shortcut icon" href="./iconos/LogoTipo_app-icon.ico"/>
        <link href="./estilos/login_styles.css" rel="stylesheet" />
    </head>

    <body>
        <header class="cabecera">
            <div class="nombre-aplicacion">
                <div class="titulo-aplicacion">
                    <h2>TalkBoard</h2>
                </div>
                <div class="imagen-aplicacion">
                    <img src="./iconos/LogoTipo_app-png.png" alt="Logo">
                </div>
            </div>
        </header>
        <div class="contenedor">
            <h2>Login</h2>
            <form id="forma" action="./usuario?action=iniciar-sesion" method="post">
                <div class="elemento">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required placeholder="Escribe tu email aqui" />
                </div>
                <div class="elemento">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required placeholder="Escribe tu contraseña" />
                </div>
                <div class="elemento">
                    <div class="elemento">
                        <input type="submit" value="Iniciar Sesión">               
                    </div>
                    <div>
                        <label for="registro">Eres nuevo?</label>
                        <a href="usuario?action=registrar" id="registro" >Registrarse</a>
                    </div>
                </div>
            </form>
        </div>
        <footer class="pie-pagina">
            <h1>ᓚᘏᗢ</h1>
        </footer>
    </body>
</html>
