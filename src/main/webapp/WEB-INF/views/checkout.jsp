<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page pageEncoding="UTF-8"%>

<html>
<head>
    <title>Checkout</title>
    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/full-width-pics.css" rel="stylesheet">
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
<div id="nav">
</div>
<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <form id="checkoutForm" action="purchase">
                    <div class="form-group">
                        <label for="firstName">Name</label>
                        <input name="firstName" type="text" class="form-control" id="firstName" placeholder="first name" required>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Name</label>
                        <input name="lastName" type="text" class="form-control" id="lastName" placeholder="last name" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input name="email" type="email" class="form-control" id="email" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input name="phone" type="tel" class="form-control" id="phone" placeholder="Telephone">
                    </div>
                    <div class="form-group">
                        <label for="city">City / Town</label>
                        <input id="city" class="form-control" name="city" type="text" placeholder="city">
                    </div>
                    <div class="form-group">
                        <label for="postalCode">Postal code</label>
                        <input id="postalCode" class="form-control" name="postalCode" type="text" placeholder="postal code">
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input name="address" type="text" class="form-control" id="address" placeholder="Address">
                    </div>
                    <div class="checkbox">
                        <label>
                            <input id="box" type="checkbox"> Check me out
                        </label>
                    </div>
                    <input id="submit" type="submit" class="btn btn-warning " disabled="disabled" value="Submit">
                </form>
            </div>
            <div id="deliveryInfo" class="col-lg-4 section-lead">
                <ol id="myList">
                    <li>
                        <p>Next-day delivery is guaranteed</p>
                    </li>
                    <li>
                        <p>A 5.00$ delivery surcharge is applied to all purchase orders</p>
                    </li>
                    <li>
                        <p>All dvd movies are in HD quality, 1080p resolution </p>
                    </li>
                </ol>
                <div id="panelInfo" >
                    <div class="panel-body">
                        <div class="col-lg-6">
                            <p >subtotal : </p>
                            <p class="thick-line"> delivery bonus : </p>
                        </div>
                        <div class="col-lg-6 ">
                            <p id="subTotal" class="toRight"> $5</p>
                            <p class="toRight "> $5</p>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>
</section>


<script src="/resources/js/jquery-3.1.1.js"></script>
<script src="/resources/js/jquery.validate.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/paginathing.js"></script>
<script src="/resources/script/commonScript.js" type="text/javascript"></script>

<script src="/resources/script/navbar.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#box').click(function () {
            if (document.getElementById('box').checked) {
                $('#submit').prop("disabled", false).addClass('btn-success').removeClass('btn-warning');
            } else {
                $('#submit').prop("disabled", true).addClass('btn-warning').addClass('btn-success');
            }
        });
    });
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $.validator.addMethod( "postcodeUK", function( value, element ) {
            return this.optional( element ) || /^((([A-PR-UWYZ][0-9])|([A-PR-UWYZ][0-9][0-9])|([A-PR-UWYZ][A-HK-Y][0-9])|([A-PR-UWYZ][A-HK-Y][0-9][0-9])|([A-PR-UWYZ][0-9][A-HJKSTUW])|([A-PR-UWYZ][A-HK-Y][0-9][ABEHMNPRVWXY]))\s?([0-9][ABD-HJLNP-UW-Z]{2})|(GIR)\s?(0AA))$/i.test( value );
        }, "Please specify a valid PL postcode" );
        $('#checkoutForm').validate({
            errorClass: "my-error-class",
            validClass: "my-valid-class",
            rules: {
                phone: {
                    required: true,
                    number: true,
                    minlength: 9,
                    maxlength: 9
                },
                address: {
                    required: true
                },
                city: {
                    required: true
                },
                postalCode:{
                    required: true
                }


            }
        });
        $.get("/shoppingCart", function (shoppingCart) {
            $('#subTotal').empty();
            $('#subTotal').append("<p id='subTotal'> <strong>" + shoppingCart.subTotal + "$</strong> </p>")
        });
    });
</script>
</body>
</html>
