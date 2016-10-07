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
    console.log('call update nv bar')
    $.get("/shoppingCart", function (shoppingCart) {
        console.log('call  get update nv bar')

        $('#shoppingCartNavbar').empty();
        $('#shoppingCartNavbar').append("<a href='cart'><i class='fa fa-shopping-cart '> " + shoppingCart.numberOfItems + " ITEM(S)</i></a>")
    })
}