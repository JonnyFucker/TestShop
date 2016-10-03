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
                            <tbody>
                                <tr>
                                    <td class="col-lg-2"> Title
                                    </td>
                                    <td class="col-lg-1">
                                        <input type="number" class="form-control" id="exampleInputNumber" value="3">
                                    </td>
                                    <td class="col-lg-1 text-center"><strong>$4.87</strong></td>
                                    <td class="col-lg-2 text-center"><strong>$14.61</strong></td>
                                    <td class="col-lg-2">
                                        <button type="button" class="btn btn-danger">
                                            <span class="glyphicon glyphicon-remove"></span> Remove
                                        </button></td>
                                </tr>
                                <tr>
                                    <td class="col-lg-2"> Title 2
                                    </td>
                                    <td class="col-lg-1" style="text-align: center">
                                        <input type="number" class="form-control" id="exampleInputNumber2" value="2">
                                    </td>
                                    <td class="col-lg-1 text-center"><strong>$4.99</strong></td>
                                    <td class="col-lg-2 text-center"><strong>$9.98</strong></td>
                                    <td class="col-lg-2">
                                        <button type="button" class="btn btn-danger">
                                            <span class="glyphicon glyphicon-remove"></span> Remove
                                        </button></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="col-lg-8 col-md-offset-1">

                            <span id="subtotal" class="col-lg-offset-8 text-center label label-info subtotal" >
                                <strong> subtotal : 9$</strong>
                            </span>

                        </div>
                        <div  class="col-lg-8 col-lg-offset-4 shoppingButtons">
                            <button type="button" class="btn btn-danger ">Clear cart
                                <span class="glyphicon glyphicon-remove"></span>
                            </button>
                            <button type="button" class="btn btn-default col-lg-offset-1">
                                <span class="glyphicon glyphicon-shopping-cart"></span>Continue Shopping
                            </button>
                            <button type="button" class="btn btn-success col-lg-offset-1 ">Checkout 
                                <span class="glyphicon glyphicon-play"></span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="../../js/jquery.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/paginathing.js"></script>
        <script src="../../script/navbar.js" type="text/javascript">
        </script>
    </body>
</html>
