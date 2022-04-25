<%--
  Created by IntelliJ IDEA.
  User: markgonzalesnielsen
  Date: 18/04/2022
  Time: 11.14
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Ordrer</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<a href="${pageContext.request.contextPath}/login.jsp">Tilbage</a>--%>

<%--<h1>Her er alle ordrer</h1>--%>

<%--<table>--%>
<%--    <c:forEach var="order" items="${sessionScope.ordrerList}">--%>
<%--        <tr>--%>
<%--            <td>${order.order_id}</td>--%>
<%--            <td>${order.user_id}</td>--%>
<%--            <td>${order.totalPrice}</td>--%>
<%--            <td>${order.timestamp}</td>--%>
<%--            <td>${order.status_id}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Lånere
    </jsp:attribute>

    <jsp:attribute name="footer">
            Footertekst
    </jsp:attribute>

    <jsp:body>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>order_id</th>
                <th>user_id</th>
                <th>totalPrice</th>
                <th>timestamp</th>
                <th>status_id</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="order" items="${sessionScope.ordrerList}">
                <tr>
                    <td>${order.order_id}</td>
                    <td>${order.user_id}</td>
                    <td>${order.totalPrice}</td>
                    <td>${order.timestamp}</td>
                    <td>${order.status_id}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </jsp:body>
</t:pagetemplate>
