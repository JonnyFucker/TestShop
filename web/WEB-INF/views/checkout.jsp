<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
    <title>Checkout</title>
    <!-- Bootstrap Core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../css/full-width-pics.css" rel="stylesheet">
</head>
<body>
<div id="nav">
</div>
<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <form id="checkoutForm" action="confirmation">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input name="name" type="text" class="form-control" id="name" placeholder="Name" required>
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
            <div class="col-lg-4">
                <ol id="myList">
                    <li>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vitae, aliquid.</p>
                    </li>
                    <li>
                        <p>Quos nostrum provident ex quisquam aliquid, hic odio repellendus atque.</p>
                    </li>
                    <li>
                        <p>Facilis, id dolorum distinctio, harum accusantium atque explicabo quidem consectetur.</p>
                    </li>
                </ol>
                <div id="panelInfo" class="panel panel-info">
                    <div class="panel-body">
                        <div class="col-lg-6">
                            <p>subtotal : </p>
                            <p class="thick-line"> delivery bonus : </p>
                        </div>
                        <div class="col-lg-6 ">
                            <p class="toRight"> $5</p>
                            <p class="toRight"> $5</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</section>


<script src="../../js/jquery-3.1.1.js"></script>
<script src="../../js/jquery.validate.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/paginathing.js"></script>

<script src="../../script/navbar.js" type="text/javascript"></script>
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
                }
            }
        });
    });
</script>
</body>
</html>
