<%-- 
    Document   : agregarActivo
    Created on : 10-19-2017, 07:59:39 PM
    Author     : Erick
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     <!--LIBRERIA para formularios-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!--Libreria de JSTL-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar activo</title>
        <!-- Latest compiled and minified CSS 
        COPIAR EN le HEAD, desde:
        https://getbootstrap.com/docs/3.3/getting-started/-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="activos.htm"/> ">Inventario de Activos</a></li>
                <li class="active">Agregar Activo</li>
            </ol>
                                
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario</div>
                <div class="panel-body">
                    
                    <form:form method="post" commandName="activo"> <!--commandNAme: El nombre q pasamos en el ADDOBJECT: empresa-->
                        <h1>Complete el Formulario</h1>
                        
                        <!--<form:errors path="*" element="div" cssClass="alert alert-danger" />-->
                        <!--Que muestre todos los errores, en un div-->
                        
                        <p>
                            <form:label path="nombreactivo">Nombre Activo</form:label>
                            <form:input path="nombreactivo" cssClass="form-control" /> <!--Atributo de la clase:nombreactivo-->
                            <form:errors path="nombreactivo" element="div" cssClass="alert alert-danger"/> <!--El ERROR aparece al lado del campo nombre-->
                        </p>
                        
                        <p>
                            <form:label path="descripcionactivo">Descripcion Activo</form:label>
                            <form:input path="descripcionactivo" cssClass="form-control" /> 
                            <form:errors path="descripcionactivo" element="div" cssClass="alert alert-danger"/>
                        </p>
                        
                        <p>
                            <form:label path="*">Tipo Activo</form:label>
                            <form:select path="*" cssClass="form-control" > <!--CAMPO DE TIPO SELECT-->
                                <form:option value="0">Seleccione...</form:option>
                               <!-- <<form:options items="${tipoActivoLista}" /> -->
                            </form:select>
                        </p>
                        
                        <p>
                            <form:label path="*">Empresa</form:label>
                            <form:select path="*" cssClass="form-control" > 
                                <form:option value="0">Seleccione...</form:option>
                                <!--<<form:options items="${paisLista}" />-->
                            </form:select>
                        </p>
                    
                   
                        
                        
                        <hr/>
                        <input type="submit" value="Enviar" class="btn btn-danger" /> <!--Para enviar el formulario-->
                        
                    </form:form>
                </div>
                                    
            </div>
        </div>
    </body>
</html>
