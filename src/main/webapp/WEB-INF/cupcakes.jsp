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

        <%--    <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Vælg bund</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <style>
                        .thumbnail{
                        // min-width: 240px;
                        }
                    </style>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
    &lt;%&ndash;                                Recently added&ndash;%&gt;
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class=" col-md-4">
                                            <div class="thumbnail">
    &lt;%&ndash;                                            <img src="<?php echo base_url()."assets/images/placeholder.jpg" ?>" alt="...">&ndash;%&gt;
                                                    <img src="${pageContext.request.contextPath}/images/chokolademuffins-hjemmebagte.jpg" width="150px;" class="img-fluid"/>
                                                <div class="caption">
                                                    <input type="radio" id="chocolate" name="flavor" value="Chokolade">
                                                    <label for="chocolate">Chokolade 5 kr</label><br>
    &lt;%&ndash;                                                <h3>Chokolade</h3>&ndash;%&gt;
    &lt;%&ndash;                                                Skal vel hentes fra databasen og ikke hardcodes&ndash;%&gt;
    &lt;%&ndash;                                                <p>...</p>&ndash;%&gt;
    &lt;%&ndash;                                                <p><a href="#" class="btn btn-primary" role="button">Go to page</a> <a href="#" class="btn btn-default pull-right" role="button">View Details</a></p>&ndash;%&gt;
                                                </div>
                                            </div>
                                        </div>
                                        <div class=" col-md-4">
                                            <div class="thumbnail">
                                                <img src="<?php echo base_url()."assets/images/placeholder.jpg" ?>" alt="...">
                                                <div class="caption">
                                                    <h3>Thumbnail label</h3>
                                                    <p>...</p>
                                                    <p><a href="#" class="btn btn-primary" role="button">Go to page</a> <a href="#" class="btn btn-default pull-right" role="button">View Details</a></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class=" col-md-4">
                                            <div class="thumbnail">
                                                <img src="<?php echo base_url()."assets/images/placeholder.jpg" ?>" alt="...">
                                                <div class="caption">
                                                    <h3>Thumbnail label</h3>
                                                    <p>...</p>
                                                    <p><a href="#" class="btn btn-primary" role="button">Go to page</a> <a href="#" class="btn btn-default pull-right" role="button">View Details</a></p>
                                                </div>
                                            </div>
                                        </div>
                                        <!--                            </div>
                                                                    <div class="row">-->
                                        <div class=" col-md-4">
                                            <div class="thumbnail">
                                                <img src="<?php echo base_url()."assets/images/placeholder.jpg" ?>" alt="...">
                                                <div class="caption">
                                                    <h3>Thumbnail label</h3>
                                                    <p>...</p>
                                                    <p><a href="#" class="btn btn-primary" role="button">Go to page</a> <a href="#" class="btn btn-default pull-right" role="button">View Details</a></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class=" col-md-4">
                                            <div class="thumbnail">
                                                <img src="<?php echo base_url()."assets/images/placeholder.jpg" ?>" alt="...">
                                                <div class="caption">
                                                    <h3>Thumbnail label</h3>
                                                    <p>...</p>
                                                    <p><a href="#" class="btn btn-primary" role="button">Go to page</a> <a href="#" class="btn btn-default pull-right" role="button">View Details</a></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class=" col-md-4">
                                            <div class="thumbnail">
                                                <img src="<?php echo base_url()."assets/images/placeholder.jpg" ?>" alt="...">
                                                <div class="caption">
                                                    <h3>Thumbnail label</h3>
                                                    <p>...</p>
                                                    <p><a href="#" class="btn btn-primary" role="button">Go to page</a> <a href="#" class="btn btn-default pull-right" role="button">View Details</a></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Top courses
                                </div>
                                <div class="panel-body">
                                    List top uploaded courses
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->

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
    &lt;%&ndash;            <td><button name="bogid" formaction="laanbog" value="${bog.bogId}" class="btn btn-secondary">Lån bog</button></td>&ndash;%&gt;
            </tr>
        </c:forEach>--%>
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

                <form action="/">
        <div class="container">
            <h2>Vælg bund</h2>

                <%--        <p>The .thumbnail class can be used to display an image gallery.</p>--%>
                <%--        <p>The .caption class adds proper padding and a dark grey color to text inside thumbnails.</p>--%>
                <%--        <p>Click on the images to enlarge them.</p>--%>


            <div class="row">
                    <c:forEach var="cupcakebuttom" items="${requestScope.cupcakebuttomlist}">
                        <%-- <tr>
                             <td>${cupcakebuttom.flavor} ${cupcakebuttom.price} kr</td>
                             <td></td>
                         </tr>--%>
                        <div class="col-md-3">
                            <div class="thumbnail">
                                    <%--                    <a href="${pageContext.request.contextPath}/images/${cupcakebuttom.buttom_picture_id}" target="_blank">--%>
                                <img src="${pageContext.request.contextPath}/images/${cupcakebuttom.buttom_picture_id}"
                                     alt="Lights" style="width:150px">
                                <div class="caption">
                                    <input type="radio" id="flavorprice" name="flavor" value="flavor">
                                    <label for="flavorprice">${cupcakebuttom.flavor} ${cupcakebuttom.price}
                                        kr</label><br>
                                        <%--                            <p> ${cupcakebuttom.flavor} ${cupcakebuttom.price} kr</p>--%>
                                </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                    <input type="submit" value="Submit">
                </form>

       <%-- </body>
        </html>--%>


        </tbody>
        </table>
        </body>
        </html>
    </jsp:body>
</t:pagetemplate>