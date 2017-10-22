<%-- 
    Document   : activos
    Created on : 10-19-2017, 07:46:30 PM
    Author     : Erick
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--TAGLIB de JSTL-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Inventario</title>
        <!--PARA usar estilos de BOOTSTRAP: copiar de:
        https://getbootstrap.com/docs/3.3/getting-started/ -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Inventario</h1>
                <p>
                    <a href="<c:url value="agregarActivo.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                    
                </p>
                
                <div class="panel panel-primary">
                    <div class="panel-heading">Activos</div>
                    <div class="panel-body">
                        <table class="table table-bordered table-striped table-hover">

                            <thead> <!--Encabezado-->
                                <tr> <!--FILAS-->
                                    <!--<th>ID</th> <!--COLUMNAS-->
                                    <th>Nombre</th>
                                    <th>Tipo</th>
                                    <th>Descripcion</th>
                                    <th></th>
                                   
                                </tr>
                            </thead>

                            <!--CARGAR LAS FILAS, con el objeto que pasamos (datos) -->
                            
                            <tbody>
                               
                                <!--Recorrer la lista-->
                                <c:forEach items="${datos}" var="dato"> <!--forEach recorre la lista con la variable "dato" -->
                                    
                                    <tr>
                                        <!--<td><c:out value="${dato.idactivo}" /></td>-->
                                        <td><c:out value="${dato.nombreactivo}" /></td> <!--variable.nombre del campo-->
                                        <td><c:out value="${dato.idtipoactivo}" /></td>
                                        <td><c:out value="${dato.descripcionactivo}" /></td>
                                        
                                        <!--<td>botones; agregar, editar, eliminar</td>-->
                                        <td>
                                            <a href="<c:url value="reportarRiesgo.htm?id=${dato.idactivo}" />" class="btn btn-success"><span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span> Reportar Riesgo</a> <!--BOTON EDITARR-->
                                          <!--  <a href="<c:url value="delete.htm?id=${dato.id}" />" onclick="return confirm('¿Seguro que desea Eliminar?')" class="btn btn-success"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> </a> --> <!--BOTON ELIMINAR-->
                                            <!--<input type="submit" onclick="return confirm('seguro que desea submit?')"-->
                                        </td> 
                                        

                                    </tr>
                                </c:forEach>
                            </tbody>
                            

                        </table>
                    </div>
                                    
                </div>
            
            </div>
            
        </div>
        
    </body>
</html>
