package shop.cart;

import shop.entities.FilmEntity;

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
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public short getQuantity() {
        return quantity;
    }

    public FilmEntity getProduct() {
        return product;
    }

    public double getTotalPrice() {
        return (double) this.quantity * this.product.getReplacementCost().doubleValue();
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
