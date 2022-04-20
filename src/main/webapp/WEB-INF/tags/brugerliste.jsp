<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
              Kundeliste
    </jsp:attribute>

    <jsp:attribute name="footer">
            Kundelisten
    </jsp:attribute>

    <jsp:body>
        <form method="post">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Bruger Id</th>
                    <th>Email</th>
                    <th>Fornavn</th>
                    <th>Efternavn</th>
                    <th>Saldo</th>

                </tr>

                </thead>
                <tbody>
                <c:forEach var="bruger" items="${sessionScope.brugerliste}">
                    <tr>
                        <td>${bruger.user_id}</td>
                        <td>${bruger.email}</td>
                        <td>${bruger.firstname}</td>
                        <td>${bruger.lastname}</td>
                        <td>${bruger.balance}</td>
                        <td>
                            <button name="rediger" value="${bruger.user_id}" formaction="RedigerBrugerServlet">Rediger Bruger</button>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>


    </jsp:body>
</t:pagetemplate>