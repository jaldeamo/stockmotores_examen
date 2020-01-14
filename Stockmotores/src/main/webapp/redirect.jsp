<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("listado.htm"); %>

<!-- Comentario Jesús Aldea 13/01/2020:
    Redirigimos la ejecución de la aplicación al archivo 'listado.jsp' como 
    página de inicio.
-->