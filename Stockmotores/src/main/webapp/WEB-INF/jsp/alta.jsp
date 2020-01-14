<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Comentario Jesús Aldea:
    A este menú de alta se llega desde 'listado.jsp', tras pasar por 'dispatcher.xml'
    que contiene las coordenadas para redirigir al controller 'altaController'.
-->
<html>
    <head>
        <meta charset="utf-8" />
        <title>Hola desde Spring Web MVC</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/listado.htm" />">Listado de motores</a></li>
                <li class="active">Alta de motores</li>
            </ol>
                              
                        <form:form method="post" commandName="motores">
                              <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            <h1>Complete el formulario</h1>
                            
                                                       
                            <p>
                                <form:label path="modelo">Modelo:</form:label>
                                <form:input path="modelo" cssClass="form-control"/>
                                
                            </p>
                            
                            <p>
                                <form:label path="fabricante">Fabricante</form:label>
                                <input type="text" id="fabricante" name="fabricante">
                            </p>
                            
                            <p>
                                <form:label path="potencia">Potencia</form:label>
                                <input type="text" id="potencia" name="potencia">
                            </p
                            <p>
                                <form:label path="peso">Peso</form:label>
                                <input type="text" id="peso" name="peso">
                            </p>
                            <p>
                                <form:label path="cantidad">Cantidad</form:label>
                                <input type="text" id="cantidad" name="cantidad">
                            </p>
                            <br/>
                            <input type="submit" value="Enviar" class="btn btn-danger" />
                        </form:form>
                </div>
        </body>
</html>

