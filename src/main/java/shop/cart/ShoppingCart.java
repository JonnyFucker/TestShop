package shop.cart;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shop.entities.FilmEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * Created by Tomek on 2016-10-05.
 */
@Component
@Scope("session")
public class ShoppingCart {
    private List<ShoppingCartItem> shoppingCartItems;
    private int numberOfItems = 0;
    private double total = 0;
    private double surcharge = 0;

    public ShoppingCart() {
        this.shoppingCartItems = new ArrayList<>();
    }

    public synchronized void addItem(FilmEntity product) {

        ShoppingCartItem shoppingCartItem = getShoppingCartItem(product);

        if (shoppingCartItem != null) {
            shoppingCartItem.incrementQuantity();
        } else {
            shoppingCartItem = new ShoppingCartItem(product);
            shoppingCartItems.add(shoppingCartItem);
        }

    }

    public synchronized void update(FilmEntity product, short quantity) {
        ShoppingCartItem shoppingCartItem = getShoppingCartItem(product);
        if (quantity > 0) {
            shoppingCartItem.setQuantity(quantity);
        } else
            shoppingCartItems.remove(shoppingCartItem);

    }

    public synchronized List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public synchronized int getNumberOfItems() {
        updateNumberOfItems();
        return numberOfItems;
    }

    private void updateNumberOfItems() {
        int totalItems = 0;
        for (ShoppingCartItem item : shoppingCartItems) {
            totalItems += item.getQuantity();
        }
        this.numberOfItems = totalItems;
    }

    public synchronized double getSubTotal() {
        double amount = 0;
        for (ShoppingCartItem item : shoppingCartItems) {
            amount += item.getTotalPrice();
        }
        return new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }


    public synchronized double getTotal() {
        calculateTotal();
        return this.total;
    }

    public synchronized ShoppingCartItem getShoppingCartItem(FilmEntity product) {
        return shoppingCartItems.stream()
                .filter(p -> p.getProduct().equals(product))
                .findAny()
                .orElse(null);
    }

    public synchronized void clear() {
        shoppingCartItems.clear();
        numberOfItems = 0;
        total = 0;
    }

    public synchronized void remove(FilmEntity filmEntity) {
        ShoppingCartItem shoppingCartItem = getShoppingCartItem(filmEntity);
        shoppingCartItems.remove(shoppingCartItem);
    }

    private synchronized void calculateTotal() {
        this.total = this.surcharge + this.getSubTotal();
        this.total = new BigDecimal(total)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }


}
