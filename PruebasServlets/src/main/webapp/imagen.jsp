<%-- 
    Document   : imagen
    Created on : Jul 5, 2023, 1:53:43 PM
    Author     : Joel Antonio Lopez Cota ID:228926
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <img src="./imageServlet?action=cargar&id=${requestScope.bytes}" alt="Uploaded Image" />
    </body>
</html>
