<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de motores</h1>
        <a href="alta.htm">Nuevo motor</a>
        <table>
            <tr>
                <th>Modelo</th>
                <th>Fabricante</th>
                <th>Potencia</th>
                <th>Peso</th>
                <th>Cantidad</th>
            </tr>
            <c:forEach items="${motores}" var="motores">
                <tr>
                    <td><c:out value="${motores.modelo}"></c:out></td>
                    <td><c:out value="${motores.fabricante}"></c:out></td>
                    <td><c:out value="${motores.potencia}"></c:out></td>
                    <td><c:out value="${motores.peso}"></c:out></td>
                    <td><c:out value="${motores.cantidad}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
