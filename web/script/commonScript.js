/**
 * Created by Tomek on 2016-10-06.
 */
function updateSubTotal() {

    $.get("/shoppingCart", function (shoppingCart) {
        $('#subTotal').empty();
        $('#subTotal').append("<span class='col-lg-offset-8 text-center label label-info subtotal'> <strong> subtotal : " + shoppingCart.subTotal + "$</strong> </span>")
    });


}