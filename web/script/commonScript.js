/**
 * Created by Tomek on 2016-10-06.
 */
function updateSubTotal() {

    $.get("/shoppingCart", function (shoppingCart) {
        $('#subTotal').empty();
        $('#subTotal').append("<span class='col-lg-offset-8 text-center label label-info subtotal'> <strong> subtotal : " + shoppingCart.subTotal + "$</strong> </span>")
    });

}
function updateNavbarShoppingCart() {
        $.get("/shoppingCart", function (shoppingCart) {
            console.log(shoppingCart.numberOfItems);
            $('#shoppingCartNavbar').empty();
            $('#shoppingCartNavbar').append("<a href='#!'><i class='fa fa-shopping-cart fa-2x'> " + shoppingCart.numberOfItems + "</i></a>")
        })
}