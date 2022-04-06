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


        <br><br>


        <!DOCTYPE html>
        <html lang="en">
        <head>
            <title>Bootstrap Example</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        </head>
        <body>

        <br><br><br><br>
        <h2>Vælg bund</h2>
        <form action="ChooseCupcakeServlet" method="get">
            <div class="container">

                    <%--        <p>The .thumbnail class can be used to display an image gallery.</p>--%>
                    <%--        <p>The .caption class adds proper padding and a dark grey color to text inside thumbnails.</p>--%>
                    <%--        <p>Click on the images to enlarge them.</p>--%>


                <div class="row">
                    <c:forEach var="cupcakebuttom" items="${requestScope.cupcakebuttomlist}">
                        <div class="col-md-2">
                            <div class="">
                                    <%--                    <a href="${pageContext.request.contextPath}/images/${cupcakebuttom.buttom_picture_id}" target="_blank">--%>
                                <img src="${pageContext.request.contextPath}/images/${cupcakebuttom.buttom_picture_id}"
                                     alt="Buttoms" style="width:150px">
                                <div class="caption">
                                    <input type="radio" id="buttom${cupcakebuttom.flavor}" name="flavorpricebuttom" value="buttom${cupcakebuttom.flavor}">
                                    <label for="buttom${cupcakebuttom.flavor}">${cupcakebuttom.flavor} ${cupcakebuttom.price}
                                        kr</label><br>
                                </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
<%--            <input type="submit" value="Vælg bund">--%>
<%--        </form>--%>

        <br><br><br><br>
        <h2>Vælg topping</h2>
<%--        <form action="ChooseCupcakeServlet" method="get">--%>
            <div class="container">
                <div class="row">
                    <c:forEach var="cupcaketopping" items="${requestScope.cupcaketoppinglist}">
                        <div class="col-md-2">
                            <div class="">
                                    <%--                    <a href="${pageContext.request.contextPath}/images/${cupcakebuttom.buttom_picture_id}" target="_blank">--%>
                                <img src="${pageContext.request.contextPath}/images/${cupcaketopping.topping_picture_id}"
                                     alt="Buttoms" style="width:150px">
                                <div class="caption">
                                    <input type="radio" id="topping${cupcaketopping.flavor}" name="flavorpricetopping" value="topping${cupcaketopping.flavor}">
                                    <label for="topping${cupcaketopping.flavor}">${cupcaketopping.flavor} ${cupcaketopping.price}
                                        kr</label><br>
                                </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <br><br>
            <input type="submit" value="Vælg cupcake">
        </form>


        </body>
        </html>

    </jsp:body>
</t:pagetemplate>