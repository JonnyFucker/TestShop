<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dvd store</title>

    <!-- Bootstrap Core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../css/full-width-pics.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="nav">

</div>
<!-- Image backgrounds are set within the full-width-pics.css file. -->
<header class="image-bg-fluid-height">
</header>

<!-- Content Section -->
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-lg-4">
                <p class="lead">Dvd online shop categories</p>
                <div class="list-group" id="categories">

                </div>
            </div>
            <div class="col-lg-8 col-md-9">
                <div class="table-responsive">
                    <p class="lead">Movie description or something</p>
                    <table id="example" class="table table-bordered table-hover table-striped ">
                        <tbody id="movies">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Fixed Height Image Aside -->
<!-- Image backgrounds are set within the full-width-pics.css file. -->
<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</footer>

<!-- jQuery -->
<script src="../../js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/paginathing.js"></script>

DataTables designed and created by SpryMedia Ltd © 2007-2016. MIT licensed. Our Supporters
<script type="text/javascript">
    jQuery(document).ready(function ($) {

        $.get("/category", function (data) {
            $.each(data, function (index, val) {
                $('#categories').append("<a class='list-group-item'>" + val.name + "</a>");

            });
            $('#categories').paginathing({
                perPage: 4,
                limitPagination: 4
            });
        });

        getFilmsByCategoryId(1);


    });
</script>
<script type="text/javascript">
    $('#categories').on('click','a',function () {
        var index = $(this).index()+1;
        getFilmsByCategoryId(index);


    })
</script>

<script type="text/javascript">
    function getFilmsByCategoryId(id) {
        $('#movies').empty();
        $('.movies-container').remove();
        $.get("/category/"+id, function (data) {
            $.each(data, function (index, val) {
                $('#movies').append("<tr><td class='col-md-2'>"+val.title+" </td> " +
                        "<td class='col-md-5'><i>"+val.description+"</i></td>" +
                        " <td class='col-md-1'>"+val.replacementCost+" $ </td> " +
                        "<td class='col-md-1'> <button class='btn  btn-info type=button'>Details</button></td> " +
                        "<td class='col-md-3'> <button class='btn btn-success type=button'>Add to card</button> <span class='glyphicon glyphicon-shopping-cart'></span> </td></tr>");
            });
            $('#movies').paginathing({
                perPage : 4,
                limitPagination: 4,
                insertAfter: '.table',
                containerClass: 'movies-container'
            });
        });
    }
</script>

<script src="../../script/navbar.js" type="text/javascript">
</script>

</body>

</html>
