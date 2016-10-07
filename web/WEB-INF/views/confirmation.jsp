<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Confirmation</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../../css/bootstrap.min.css" rel="stylesheet">
        <link href="../../css/font-awesome.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../../css/full-width-pics.css" rel="stylesheet">
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
                                        <tr>
                                            <td>movie</td>
                                            <td>1</td>
                                            <td>5 $</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="panel-footer ">
                                    <p class="toRight"><strong>delivery surcharge : 5$</strong></p>
                                    <p class="toRight thick-line"><strong>total : 10$</strong></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div id="addressPanel" class="panel panel-default">
                                <!-- Default panel contents -->
                                <div class="panel-heading">delivery address</div>
                                <div class="jumbotron">
                                    <p>Wiśniowa 9, 63-700 Krotoszyn</p>
                                    <p>tomasz@gmail.com</p>
                                    <p>112-222-222</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <script src="../../js/jquery-3.1.1.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/paginathing.js"></script>
        <script src="../../script/commonScript.js" type="text/javascript"></script>
        <script src="../../script/navbar.js" type="text/javascript">
        </script>    </body>
</html>
