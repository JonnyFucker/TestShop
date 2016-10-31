<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/full-width-pics.css" rel="stylesheet">
    <!-- jQuery -->
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet">



    <title>Dvd store</title>

</head>
<body>
<div id="nav">
</div>
<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-sm-6 col-md-6 col-lg-6">
                    <table id="cartTable" class="table-hover table table-striped">
                        <thead>
                        <tr>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                            <th class="text-center">Remove</th>
                        </tr>
                        </thead>
                        <tbody id="cartTableBody">

                        </tbody>
                    </table>
                    <div id="subTotal" class="col-lg-8  subtotal">
                    </div>
                    <div class=" shoppingButtons col-lg-offset-3 ">
                        <a href="checkout" id="checkoutButton" type="button" class="btn btn-success  text-center">Checkout
                            <span class="glyphicon glyphicon-play"></span>
                        </a>

                        <a href="index" id="continueShoppingButton" type="button"
                           class="btn btn-default text-center">
                            <span class="glyphicon glyphicon-shopping-cart"></span>Continue Shopping
                        </a>
                        <button id="clearCartButton" type="button" class="btn btn-danger text-center">Clear cart
                            <span class="glyphicon glyphicon-remove"></span>
                        </button>
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
<script src="/resources/script/navbar.js" type="text/javascript"></script>
<script src="/resources/script/commonScript.js" type="text/javascript"></script>
<!-- get json with shopping cart, iterate through list contains products, each product is FilmEntity, get proper value -->
<script type="text/javascript">
    $(document).ready(function () {
        showShoppingCart();
        updateSubTotal();
    });

</script>
<script type="text/javascript">
    function changeQuantity(filmId, quantity) {
        $.ajax({
            type: "POST",
            data: {"filmId": filmId, "quantity": quantity},
            dataType: "json",
            url: "/updateQuantityInCart",
            success: function (shoppingCartItem) {
                removeAndAddTotalPrice(shoppingCartItem);
                updateSubTotal();
                updateNavbarShoppingCart();
            }
        });
    }
    ;

    function updateTable(shoppingCart) {
        $.each(shoppingCart.shoppingCartItems, function (index, shoppingCartItem) {

            $('#cartTableBody').append("<tr> <td class='col-lg-2'>" + shoppingCartItem.product.title + "</td> " +
                    "<td class='col-lg-1'><input min='1' max='10' oninput='changeQuantity(" + shoppingCartItem.product.filmId + ",$(this).val())' type='number' class='form-control' id='exampleInputNumber' value='" + shoppingCartItem.quantity + "'> </td>" +
                    "<td class='col-lg-1 text-center'><strong>" + shoppingCartItem.product.replacementCost + " $</strong></td>" +
                    "<td id=totalPrice" + shoppingCartItem.product.filmId + " class='col-lg-2 text-center'><strong>" + shoppingCartItem.totalPrice + " $</strong></td>" +
                    " <td class='col-lg-2 text-center'><button onclick='removeItemFromCart(" + shoppingCartItem.product.filmId + ")' type='button' class='btn btn-danger'>" +
                    " <span class='glyphicon glyphicon-remove'></span> Remove" +
                    "</button> </td> </tr>")
        });
    }
    function showShoppingCart() {
        $('#cartTableBody').empty();
        $.get("/shoppingCart", function (shoppingCart) {
            updateTable(shoppingCart);
        });

    }


    function removeAndAddTotalPrice(shoppingCartItem) {
        console.log('#totalPrice' + shoppingCartItem.product.filmId);
        $('#totalPrice' + shoppingCartItem.product.filmId).replaceWith("<td id=totalPrice" + shoppingCartItem.product.filmId + " class='col-lg-2 text-center'><strong>" + shoppingCartItem.totalPrice + " $</strong></td>");
    }

    function removeItemFromCart(id) {
        $.ajax({
            type: "POST",
            data: {"filmId": id},
            url: "/removeItem",
            success: function () {
                showShoppingCart();
                updateSubTotal();
                updateNavbarShoppingCart();
            }
        });

    }

    $('#clearCartButton').click(function () {
        $.get("/clearCart");
        location.reload();
    });

</script>
</body>
</html>
