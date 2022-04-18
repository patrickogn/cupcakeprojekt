<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

button {
background-color: #04AA6D;
color: white;
padding: 14px 20px;
margin: 8px 0;
border: none;
cursor: pointer;
width: 100%;
}


<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <form action="login" method="post">
            <label for="email"> </label>
            <input type="email" id="email" name="email" placeholder="E-mail"/>
            <label for="password"> </label>
            <input type="password" id="password" name="password" placeholder="Adgangskode"/>
            <br>
            <input type="submit"  value="Log På"/>
        </form>
        <br>
        <h3>Har du ikke en konto endnu?</h3>
        <form action="OpretBrugerKnapServlet" method="get">
            <input type="submit"  value="Opret bruger"/>
        </form>


    </jsp:body>
</t:pagetemplate>