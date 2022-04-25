<%--
  Created by IntelliJ IDEA.
  User: patricknielsen
  Date: 21/04/2022
  Time: 00.29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Ordreside
    </jsp:attribute>

    <jsp:attribute name="footer">
        Ordreside
    </jsp:attribute>

    <jsp:body>

<html>
<head>
    <title>Opret Ordre</title>

    <h1>Information</h1>
</head>
<body>

<label for="userid1"><b>Userid: </b></label>
<input readonly type="text" name="userid1" value="${sessionScope.user.user_id}" id="userid1" required>
<br>
<br>
<label for="fornavn1"><b>Fornavn: </b></label>
<input readonly type="text"  name="fornavn1" value="${sessionScope.user.firstname}" id="fornavn1" required>
<br>
<br>
<label for="efternavn"><b>Efternavn: </b></label>
<input readonly type="text" name="efternavn" value="${sessionScope.user.lastname}" id="efternavn" required>
<br>
<br>
<label for="balance"><b>Saldo</b></label>
<input readonly type="text" name="balance" id="balance" value="${sessionScope.user.balance}" checked required>
<br>
<br>
<div class="col-4 p-4" style="border:1px solid rgba(255,0,0,0)">
    <div class="jumbotron">
        <h2>Indkøbskurv</h2>
        <c:forEach var="cartitem" items="${sessionScope.cartDTOList}">
            <p>${cartitem.quantity} stk - Bund: ${cartitem.buttom.flavor},
                Topping: ${cartitem.topping.flavor} - ${cartitem.price} kr</p>
        </c:forEach>


        <c:set var="total" value="${0}"/>
        <c:forEach var="cartitem" items="${sessionScope.cartDTOList}">
            <c:set var="total" value="${total + cartitem.price}"/>
        </c:forEach>

        <c:set var="samletpris" value="${total}"/>
        <p>Samlet pris: ${total} kr.</p>

        </form>

        <form action="OpretOrdreServlet" method="get">
            <input type="submit"  value="opret bestilling"/>
        </form>
    </div>



</body>
</html>


    </jsp:body>

</t:pagetemplate>


