<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Comentario Jesús Aldea 13/01/2020:
    Este menú es invocado directamente como página de inicio de la aplicación desde
    el 'redirect.jsp'
    El listado se compone de una cabecera fija y, una línea de listado por cada fila
    recuperada de la tabla motores a través de la select realizada en la clase 
    'listadoController', enlazada con esta página .jsp a través del archivo 
    'dispatcher-servlet.xml'.
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <div class="row">
        <h1>Listado de motores</h1>
        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th>Modelo</th>
                <th>Fabricante</th>
                <th>Potencia</th>
                <th>Peso</th>
                <th>Cantidad</th>
                <th>Optimo</th>
            </tr>
            <c:forEach items="${motores}" var="motores">
                <tr>
                    <td><c:out value="${motores.modelo}"></c:out></td>
                    <td><c:out value="${motores.fabricante}"></c:out></td>
                    <td><c:out value="${motores.potencia}"></c:out></td>
                    <td><c:out value="${motores.peso}"></c:out></td>
                    <td><c:out value="${motores.cantidad}"></c:out></td>
                    <td><c:out value="${optimo}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
        </div>
            <p>
               <a href="alta.htm" class="btn btn-primary"><i class="fas fa-plus-square"></i> Nuevo motor</a>
            </p>
        </div>
    </body>
</html>
