<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
--%>
<html>
    <head>
        <title>Confirmation</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="/resources/css/font-awesome.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="/resources/css/full-width-pics.css" rel="stylesheet">
    </head>
    <body>
        <div id="nav">
        </div>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-lg-10">
                        <div class="panel panel-warning">
                            <div class="panel-heading">
                                <h3 class="panel-title">Order information</h3>
                            </div>
                            <div class="panel-body">
                                No data related to the order is displayed on the confirmation page. 
                                In fact, in its current state the application doesn't do anything with
                                the data from the checkout form. By the end of this tutorial unit, 
                                the application will gather customer data and use it to process an order.
                                In its final state, the application will display 
                                a summary of the processed order on the confirmation page, 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-10">
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <!-- Default panel contents -->
                                <div class="panel-heading">order summary</div>
                                <!-- Table -->
                                <table class="table table-responsive table-bordered ">
                                    <thead>
                                        <tr>
                                            <th>product</th>
                                            <th>quantity</th>
                                            <th>price</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="orderedProduct" items="${orderedProducts}" varStatus="iter">
                                        <tr>
                                            <td>${products[iter.index].title}</td>
                                            <td>${orderedProduct.quantity}</td>
                                            <td>${products[iter.index].replacementCost * orderedProduct.quantity} $</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div class="panel-footer ">
                                    <p class="toRight"><strong>delivery surcharge : 5$</strong></p>
                                    <p class="toRight thick-line"><strong>total : ${orderRecord.amount} $</strong></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div id="addressPanel" class="panel panel-default">
                                <!-- Default panel contents -->
                                <div class="panel-heading">delivery address</div>
                                <div class="jumbotron">
                                    <p>${customer.firstName} ${customer.lastName}</p>

                                    <p>${customer.addressByAddressId.postalCode} ${customer.addressByAddressId.cityByCityId.city}</p>
                                    <p>${customer.addressByAddressId.address}</p>
                                    <p>${customer.email}</p>
                                    <p>${customer.addressByAddressId.phone}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="/resources/js/jquery-3.1.1.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="/resources/js/bootstrap.min.js"></script>
        <script src="/resources/js/paginathing.js"></script>
        <script src="/resources/script/commonScript.js" type="text/javascript"></script>
        <script src="/resources/script/navbar.js" type="text/javascript">
        </script>
    </body>
</html>
