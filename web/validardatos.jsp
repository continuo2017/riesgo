<%-- 
    Document   : validardatos
    Created on : 10-19-2017, 07:38:05 PM
    Author     : Erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Menu</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />  <!--Libreria de BOOTSTRAP-->
    </head>
    <body background="dragon24.jpg"  >

  <%

   pkMenu.admin p= new pkMenu.admin();

       p.setUsuario(request.getParameter("usuario"));
       p.setcontrasena(request.getParameter("contrasena"));


       String res=p.insertar3();


if(res.equals("-1")) {
      ; %>
      <br/><br/>
      <p class="text-center">
        <font size=5 class="breadcrumb">Bienvenido</font><br/><br/>
      </p>
        
        <hr/>
        <ol class="breadcrumb" >
            <a href="empresas.htm" class="btn btn-default">Listado de Empresas</a>
            <br/>
            <br/>
            <a href="login.htm" class="btn btn-success"><span class="glyphicon glyphicon-home" ></span> Salir</a>
        </ol>
        
<%
      }
       else if (res.equals("1")){
         ; %>
        <ol >
            <p>
                <br/>
                <font size=5>Nombre de usuario o contraseña incorrectos.</font><br/><br/>
                <a href="login.htm">Regresar</a>
            </p>
        </ol>
<%
        }
       else{
           out.print("algo pasa ");
           }

                %>
    </body>
</html>
