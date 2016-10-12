package shop.entities;

import javax.persistence.*;

/**
 * Created by Tomek on 2016-10-11.
 */
@Entity
@Table(name = "ordered_product", schema = "sakila")
@IdClass(OrderedProductEntityPK.class)
public class OrderedProductEntity {
    private int customerOrderId;
    private short filmFilmId;
    private short quantity;
    private CustomerOrderEntity customerOrderByCustomerOrderId;

    @Id
    @Column(name = "customer_order_id")
    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    @Id
    @Column(name = "film_film_id")
    public short getFilmFilmId() {
        return filmFilmId;
    }

    public void setFilmFilmId(short filmFilmId) {
        this.filmFilmId = filmFilmId;
    }

    @Basic
    @Column(name = "quantity")
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderedProductEntity that = (OrderedProductEntity) o;

        if (customerOrderId != that.customerOrderId) return false;
        if (filmFilmId != that.filmFilmId) return false;
        if (quantity != that.quantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerOrderId;
        result = 31 * result + (int) filmFilmId;
        result = 31 * result + (int) quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer_order_id", referencedColumnName = "id", nullable = false)
    public CustomerOrderEntity getCustomerOrderByCustomerOrderId() {
        return customerOrderByCustomerOrderId;
    }

    public void setCustomerOrderByCustomerOrderId(CustomerOrderEntity customerOrderByCustomerOrderId) {
        this.customerOrderByCustomerOrderId = customerOrderByCustomerOrderId;
    }
}
