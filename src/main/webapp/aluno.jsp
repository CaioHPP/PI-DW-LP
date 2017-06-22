<%-- 
    Document   : aluno
    Created on : 08/06/2017, 20:45:46
    Author     : Caio Henrique
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="login" scope="session" value="${session}"></c:set>
<c:if test="${sessionScope.login == null}">
    <c:redirect url="index.jsp"></c:redirect>

</c:if>
<c:if test="${sessionScope.login != null}">
    <c:out value="Seja bem-vindo ${sessionScope.login}" />

</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aluno</title>
    </head>
    <body>

    </body>
</html>
