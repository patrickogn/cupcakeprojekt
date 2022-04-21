<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen til forsiden!
    </jsp:attribute>

    <jsp:attribute name="footer">
        Velkommen til forsiden!
    </jsp:attribute>

    <jsp:body>

        <c:if test="${sessionScope.user != null}">
            <p>Du er logget ind med rollen: "${sessionScope.user.roleId}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind endnu, du kan gøre det her: <a
                    href="login.jsp">Login</a></p>
            <br>
            <br>
            <p>Ellers kan du oprette en bruger: </p>
            <form action="OpretBrugerKnapServlet" method="get">
                <input type="submit"  value="Opret bruger"/>
            </form>
        </c:if>

        <br>
        <br>
        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.email}".</p>
        </c:if>

    </jsp:body>

</t:pagetemplate>