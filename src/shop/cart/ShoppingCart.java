package shop.cart;

import shop.entities.FilmEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomek on 2016-10-05.
 */
public class ShoppingCart {
    private List<ShoppingCartItem> cartItems;
    private int numberOfItems = 0;
    private double total = 0;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public synchronized void addItem(FilmEntity product) {

        ShoppingCartItem shoppingCartItem = cartItems.stream()
                .filter(p -> p.getProduct().equals(product))
                .findAny()
                .orElse(null);

        if (shoppingCartItem != null) {
            shoppingCartItem.incrementQuantity();
        } else {
            shoppingCartItem = new ShoppingCartItem(product);
            cartItems.add(shoppingCartItem);
        }
    }

    public List<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public double getTotal() {
        return total;
    }
}
