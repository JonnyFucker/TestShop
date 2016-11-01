<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!-- Navigation -->

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a>
                        <img class="img-size" src="/resources/images/tz.jpeg" alt="">
                    </a>
                </li>
                <li>
                    <a href="index">About</a>
                </li>
                <li>
                    <a href="cart">Cart</a>
                </li>
                <li>
                    <a href="checkout">Checkout</a>
                </li>
<%--                <li>
                    <a href="confirmation">Confirmation</a>
                </li>--%>
                <li id="shoppingCartNavbar">
                    <a href="cart"><i class="fa fa-shopping-cart fa-2x"> 10 ITEM(S)</i></a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->

    <script type="text/javascript">
        $(document).ready(function () {
            updateNavbarShoppingCart();
        })
    </script>
</nav>
