<%-- 
    Document   : login
    Created on : 10-19-2017, 07:41:22 PM
    Author     : Erick
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     <!--LIBRERIA para formularios-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!--Libreria de JSTL-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Iniciar Sesion</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <center><img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" /></center>
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="validardatos.jsp" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <!--
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                -->
                Usuario: <input type="text" name="usuario" id="usuario" class="form-control" placeholder="Usuario"/>
                <br/><br/> 
                Contraseña:<input type="password" name="contrasena" id="contrasena" class="form-control" placeholder="Password"/>
                <br/><br/> 
                <input type="submit" value="Entrar" class="btn btn-lg btn-primary btn-signin">
                
                <!--
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" >Sign in</button>
                -->
             
            </form><!-- /form -->
             <!--
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
            -->
            <!--QUITAR ESTOOOOOOO!!!!!!!!!1 -->
            <!--
            <p>
                <li><a href="<c:url value="empresas.htm"/> ">Listado de Empresas</a></li>
            </p>
            -->
            
        </div><!-- /card-container -->
    </div><!-- /container -->
    </body>
</html>
