<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <p>Startcode for 2nd semester </p>



        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.roleId}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
            <br>
            <br>

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