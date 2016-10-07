package shop.cart;

import shop.entities.FilmEntity;

import java.math.BigDecimal;

/**
 * Created by Tomek on 2016-10-05.
 */
public class ShoppingCartItem {
    private short quantity;
    private FilmEntity product;

    public ShoppingCartItem(FilmEntity product) {
        this.product = product;
        this.quantity = 1;
    }

    public void incrementQuantity() {
        this.setQuantity(++quantity);
    }

    public void decrementQuantity() {
        quantity--;
    }

    public void setQuantity(short quantity) {
        if (quantity <= 10 && quantity > 0)
            this.quantity = quantity;
        else
            this.quantity = 10;
    }

    public short getQuantity() {
        return quantity;
    }

    public FilmEntity getProduct() {
        return product;
    }

    public double getTotalPrice() {
        double totalPrice = this.quantity * this.product.getReplacementCost().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        totalPrice = new BigDecimal(totalPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return totalPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCartItem that = (ShoppingCartItem) o;

        return product != null ? product.equals(that.product) : that.product == null;

    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }
}
