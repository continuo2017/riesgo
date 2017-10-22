<%-- 
    Document   : agregarEmpresa
    Created on : 10-19-2017, 08:02:11 PM
    Author     : Erick
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     <!--LIBRERIA para formularios-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!--Libreria de JSTL-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar Empresa</title>
        <!-- Latest compiled and minified CSS 
        COPIAR EN le HEAD, desde:
        https://getbootstrap.com/docs/3.3/getting-started/-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="empresas.htm"/> ">Listado de Empresas</a></li>
                <li class="active">Agregar Empresa</li>
            </ol>
                                
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario</div>
                <div class="panel-body">
                    
                    <form:form method="post" commandName="empresa"> <!--commandNAme: El nombre q pasamos en el ADDOBJECT: empresa-->
                        <h1>Complete el Formulario</h1>
                        
                        <!--<form:errors path="*" element="div" cssClass="alert alert-danger" />-->
                        <!--Que muestre todos los errores, en un div-->
                        
                        <p>
                            <form:label path="nombreempresa">Nombre Empresa</form:label>
                            <form:input path="nombreempresa" cssClass="form-control" /> <!--Atributo de la clase:nombreempresa-->
                            <form:errors path="nombreempresa" element="div" cssClass="alert alert-danger"/> <!--El ERROR aparece al lado del campo nombre-->
                        </p>
                        
                        <p>
                            <form:label path="politicaempresa">Politica de la Empresa</form:label>
                            <form:input path="politicaempresa" cssClass="form-control" /> 
                            <form:errors path="politicaempresa" element="div" cssClass="alert alert-danger"/>
                        </p>
                        
                        <p>
                            <form:label path="objetivoempresa">Objetivo(s) de la Empresa</form:label>
                            <form:input path="objetivoempresa" cssClass="form-control" /> 
                            <form:errors path="objetivoempresa" element="div" cssClass="alert alert-danger" />
                        </p>
                        
                        <p>
                            <form:label path="alcanceempresa">Alcance de la Empresa</form:label>
                            <form:input path="alcanceempresa" cssClass="form-control" /> 
                            <form:errors path="alcanceempresa" element="div" cssClass="alert alert-danger"/>
                        </p>
                        
                        <hr/>
                        <input type="submit" value="Enviar" class="btn btn-danger" /> <!--Para enviar el formulario-->
                        
                    </form:form>
                </div>
                                    
            </div>
        </div>
    </body>
</html>