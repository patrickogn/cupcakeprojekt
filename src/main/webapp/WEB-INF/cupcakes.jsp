<%--
  Created by IntelliJ IDEA.
  User: marie_t5vmzpd
  Date: 05-04-2022
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pagetemplate>
 <jsp:attribute name="header">
         Cupcakes
    </jsp:attribute>

    <jsp:attribute name="footer">
        Cupcakes
    </jsp:attribute>
    <jsp:body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>CupcakeButtom-Id</th>
        <th>Flavor</th>
        <th>Price</th>
        <th></th>
    </tr>

    </thead>
    <tbody>
    <c:forEach var="cupcakebuttom" items="${requestScope.cupcakebuttomlist}">
        <tr>
            <td>${cupcakebuttom.buttom_id}</td>
            <td>${cupcakebuttom.flavor}</td>
            <td>${cupcakebuttom.price}</td>
<%--            <td><button name="bogid" formaction="laanbog" value="${bog.bogId}" class="btn btn-secondary">Lån bog</button></td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
</jsp:body>
</t:pagetemplate>