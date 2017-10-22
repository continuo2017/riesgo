<%-- 
    Document   : empresas
    Created on : 10-19-2017, 08:04:12 PM
    Author     : Erick
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--TAGLIB de JSTL-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Empresas</title>
        
        <!--PARA usar estilos de BOOTSTRAP: copiar de:
        https://getbootstrap.com/docs/3.3/getting-started/ -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <center><h1><STRONG>EMPRESAS</STRONG></h1></center>
                <hr/>
                
                <c:forEach items="${datos}" var="dato">
                    <p>
                    <center><a href="<c:url value="activos.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> <c:out value="${dato.nombreempresa}" /></a></center>
                        
                    </p>
                    
                </c:forEach>
                
                <p>
                    <a href="<c:url value="agregarEmpresa.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                </p>
                
            </div>
            
        </div>
    </body>
</html>
