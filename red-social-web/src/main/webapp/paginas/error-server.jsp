<%-- 
    Document   : error-server
    Created on : Jul 9, 2023, 5:22:13 PM
    Author     : Daniel Armando Peña Garcia ID:229185
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./estilos/error-server-style.css">
    </head>

    <body>
        <div class="titulo-error">
            <div class="disculpa">
                <h2>Lo sentimos <span><img src="./iconos/bad-emoji.png" alt="Triste"></span></h2>
            </div>
            <div class="notificacion">
                <h1>Algo salió mal</h1>
            </div>
        </div>
        <div class="solucion-error">
            <div class="parrafo-solucion">
                <p>Por favor intentenlo nuevamente o vuela a la página de <span><a href="usuario?action=logout">login</a></span></p>
            </div>
        </div>
    </body>

</html>
