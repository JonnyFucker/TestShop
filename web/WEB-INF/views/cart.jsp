<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap Core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../css/full-width-pics.css" rel="stylesheet">
    <!-- jQuery -->


    <title>Dvd store</title>

</head>
<body>
<div id="nav">
</div>
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-md-8 col-lg-8 col-md-offset-1">
                <table class="table-hover table table-bordered table-striped">
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
                <div id="subTotal" class="col-lg-8 col-md-offset-1">


                </div>
                <div class="col-lg-8 col-lg-offset-4 shoppingButtons">
                    <button id="clearCartButton" type="button" class="btn btn-danger ">Clear cart
                        <span class="glyphicon glyphicon-remove"></span>
                    </button>
                    <a href="index" id="continueShoppingButton" type="button" class="btn btn-default col-lg-offset-1">
                        <span class="glyphicon glyphicon-shopping-cart"></span>Continue Shopping
                    </a>
                    <a href="checkout" id="checkoutButton" type="button" class="btn btn-success col-lg-offset-1 ">Checkout
                        <span class="glyphicon glyphicon-play"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="../../js/jquery-3.1.1.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/paginathing.js"></script>
<script src="../../script/navbar.js" type="text/javascript">
</script>

<!-- get json with shopping cart, iterate through lis contains products, each product is FilmEntity, get proper value -->
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
                    " <td class='col-lg-2'><button onclick='removeItemFromCart(" + shoppingCartItem.product.filmId + ")' type='button' class='btn btn-danger'>" +
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

    function updateSubTotal() {

        $.get("/shoppingCart", function (shoppingCart) {
            $('#subTotal').empty();
            $('#subTotal').append("<span class='col-lg-offset-8 text-center label label-info subtotal'> <strong> subtotal : " + shoppingCart.subTotal + "$</strong> </span>")
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
            dataType: "json",
            url: "/removeItem"
        });
        showShoppingCart();
        updateSubTotal();
    }
    
    $('#clearCartButton').click(function () {
        $.get("/clearCart");
        location.reload();
    });
    
</script>
</body>
</html>
