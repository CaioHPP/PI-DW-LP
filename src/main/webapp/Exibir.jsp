<%-- 
    Document   : Exibir
    Created on : 22/05/2017, 20:14:27
    Author     : Caio Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibir</title>
        <%@include file = "imports.jsp" %>
    </head>
    <body>
        <section class="h1"> 
            <h1>Cadastros Realizados</h1>
        </section> 
    <center>
        <table border="1">
            <tr> 
            <th><center>Id</th></center>   
            <th><center>Nome</th></center>   
            <th><center>Telefone</th></center>   
            <th><center>Sexo</th></center>   
            <th><center>Cpf</th></center>   
            <th><center>Email</th></center>   
            <th><center>Data de Nascimento</th></center>   
            <th><center>Endereço</th></center>   
            <th><center>Instrumento</th></center>   
            </tr>
            <c:forEach var="clientes" items="${clientes}"><tr>
            <td><center>${clientes.idCliente}</td></center>
            <td><center>${clientes.nome}</td></center>
            <td><center>${clientes.telefone}</td></center>
            <td><center>${clientes.sexo}</td></center>
            <td><center>${clientes.cpf}</td></center>
            <td><center>${clientes.email}</td></center>
            <td><center>${clientes.dataN}</td></center>
            <td><center>${clientes.endereco}</td></center>
            <td><center>${clientes.instrumento}</td></center>
            </tr>
        </c:forEach>
        </table>
    </center>
    </body>
</html>
