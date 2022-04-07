<%--
  Created by IntelliJ IDEA.
  User: patricknielsen
  Date: 06/04/2022
  Time: 19.16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Brugerside
    </jsp:attribute>

    <jsp:attribute name="footer">
        Brugerside
    </jsp:attribute>

    <jsp:body>

        <c:if test="${sessionScope.user != null}">

            <br>
            <strong style="font-size: 25px;">Velkommen tilbage:  ${sessionScope.user.firstname} ${sessionScope.user.lastname}</strong>
            <br>
            <br>
            <strong style="font-size:25px;">Din nuværende saldo er: ${sessionScope.user.balance} kr.</strong>
            <br>

            <br>
            <p>Rolle: "${sessionScope.user.roleId}".</p>

        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget på endnu, log på her : <a
                    href="login.jsp">Login</a></p>
            <br>
            <br>
            <p1>Har du ikke en bruger endnu?</p1>
            <form action="OpretBrugerKnapServlet" method="get">
                <input type="submit"  value="Opret bruger"/>
            </form>

        </c:if>

    </jsp:body>

</t:pagetemplate>

