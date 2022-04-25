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

        <div class="container d-flex align-items-center justify-content-center">
            <div class="row">
                <div class="col-8" style="border:1px solid rgba(255,0,0,0)">
                    <form action="ChooseCupcakeServlet" method="get">
                        <div class="col " style="border:1px solid rgba(255,0,0,0)">
                            <div class="row">
                                <h2>Vælg bund</h2>
                                <div class="card-group">
<%--                                <div class="card-group d-flex justify-content-center">--%>
                                    <c:forEach var="cupcakebuttom" items="${requestScope.cupcakebuttomlist}">
                                        <div class="row">
                                            <div class="card m-1" style="width: 11rem">
                                                <img src="${pageContext.request.contextPath}/images/${cupcakebuttom.buttom_picture_id}"
                                                     class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <p class="card-text"><input type="radio"
                                                                                id="buttom${cupcakebuttom.flavor}"
                                                                                name="flavorpricebuttom"
                                                                                value="${cupcakebuttom.buttom_id}">
                                                        <label for="buttom${cupcakebuttom.flavor}">${cupcakebuttom.flavor} ${cupcakebuttom.price}
                                                            kr</label><br>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="col" style="border:1px solid rgba(255,0,0,0)">
                            <h2>Vælg topping</h2>
                            <div class="card-group">
                                <c:forEach var="cupcaketopping" items="${requestScope.cupcaketoppinglist}">
                                    <div class="row">
                                        <div class="card m-1" style="width: 11rem">
                                            <img src="${pageContext.request.contextPath}/images/${cupcaketopping.topping_picture_id}"
                                                 class="card img-top">
                                            <div class="card-body">
                                                <p class="card-text"><input type="radio"
                                                                            id="topping${cupcaketopping.flavor}"
                                                                            name="flavorpricetopping"
                                                                            value="${cupcaketopping.topping_id}">
                                                    <label for="topping${cupcaketopping.flavor}">${cupcaketopping.flavor} ${cupcaketopping.price},-</label>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>


<%--                        Her kan man vælge antal cupcakes (kun for brugere)--%>
                        <c:if test="${sessionScope.user.user_id != null}">
                        <label for="quantity">Vælg antal mellem 1-20):</label>
                        <input type="number" id="quantity" name="quantity" min="1" max="20">

                        <input type="submit" value="Vælg cupcake">
                        </c:if>
        </div>
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

                    </div>

                    </form>


<%--                    Checker om kunden har råd til ordren --> hvis ikke kan kunden rydde ordren.--%>

                    <c:if test="${total > sessionScope.user.balance}">
                        <strong>Du har ikke nok penge til denne ordre</strong>
                        <input type="submit" value="Ryd ordre" formaction="${sessionScope.cartDTOList.clear()}">
                    </c:if>


<%--                    Hvis kunden har nok penge kan kunden gå til bestilling.--%>

                    <c:if test="${total <= sessionScope.user.balance}">
                    <form action="OpretOrdreServlet" method="post">
                        <input type="submit"  value="Gå til bestilling"/>
                    </form>

                    </c:if>


                    <c:if test="${sessionScope.user.user_id == null}">
                        ${sessionScope.cartDTOList.clear()}
                        <strong>Log ind for at oprette en ordre</strong>
                    </c:if>

                </div>
                    </div>
                </div>
            </div>
        </div>


    </jsp:body>
</t:pagetemplate>