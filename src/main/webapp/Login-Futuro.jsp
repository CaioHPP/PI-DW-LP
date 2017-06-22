<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="CSS/css.css" rel="stylesheet">
        <c:set var="msg" value="${x}"></c:set>
    </head>
    <body class="backin">
        <img  src="Imagens/Banner.png" alt="" > 
        <div id="divCenter">
              <form name="input" action="ServletLogin" method="post" >
                Login
                <input type="text" name="login" value=""> <br/>
                Senha
                <input type="password" value="" name="senha"><br/>
                <c:out  value="${x}"></c:out>
                <input type="submit" value="Enviar" name="botao"  />
            </form>
        </div>

    </body>
</html>
