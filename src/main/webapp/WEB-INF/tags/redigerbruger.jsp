<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
              Rediger Bruger
    </jsp:attribute>

    <jsp:attribute name="footer">
            Rediger Bruger
    </jsp:attribute>

    <jsp:body>
        <form method="post" action="OpdaterBrugerServlet">
            <label for="id">BrugerId:</label>
            <input type="text" id="id" readonly name="id" value="${requestScope.user.user_id}"/><br/>

            <label for="kodeord">Password:</label>
            <input type="text" id="kodeord" name="kodeord" value="${requestScope.user.password}"/><br/>

            <label for="roleid">Role ID (roleid 1 = Admin roleid 2= Bruger):</label>
            <input type="text" id="roleid" name="roleid" value="${requestScope.user.role_id}"/><br/>

            <label for="fornavn">Fornavn:</label>
            <input type="text" id="fornavn" name="fornavn" value="${requestScope.user.firstname}"/><br/>

            <label for="efternavn">Efternavn: </label>
            <input type="text" id="efternavn" name="efternavn" value="${requestScope.user.lastname}"/><br/>

            <label for="telefonnummer">Telefonnummer: </label>
            <input type="text" id="telefonnummer" name="telefonnummer" value="${requestScope.user.phone_no}"/><br/>

            <label for="email">Telefonnummer: </label>
            <input type="text" id="email" name="email" value="${requestScope.user.email}"/><br/>

            <label for="saldo">Saldo: </label>
            <input type="text" id="saldo" name="saldo" value="${requestScope.user.balance}"/><br/>

            <input type="submit" value="Opdater"/>

<%--            <button name="fjern" value="${user.user_id}" formaction="fjernbog">fjern</button>--%>
        </form>
    </jsp:body>
</t:pagetemplate>