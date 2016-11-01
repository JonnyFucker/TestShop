package shop.entities;

import javax.persistence.*;

/**
 * Created by Tomek on 2016-11-01.
 */
@Entity
@Table(name = "ordered_product", schema = "sakila", catalog = "")
@IdClass(OrderedProductEntityPK.class)
public class OrderedProductEntity {
    private Integer customerOrderId;
    private Integer filmFilmId;
    private Short quantity;
    private CustomerOrderEntity customerOrderByCustomerOrderId;

    @Id
    @Column(name = "customer_order_id", insertable = false, updatable = false)
    public Integer getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Integer customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    @Id
    @Column(name = "film_film_id")
    public Integer getFilmFilmId() {
        return filmFilmId;
    }

    public void setFilmFilmId(Integer filmFilmId) {
        this.filmFilmId = filmFilmId;
    }

    @Basic
    @Column(name = "quantity")
    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderedProductEntity that = (OrderedProductEntity) o;

        if (customerOrderId != null ? !customerOrderId.equals(that.customerOrderId) : that.customerOrderId != null)
            return false;
        if (filmFilmId != null ? !filmFilmId.equals(that.filmFilmId) : that.filmFilmId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerOrderId != null ? customerOrderId.hashCode() : 0;
        result = 31 * result + (filmFilmId != null ? filmFilmId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer_order_id", referencedColumnName = "id", nullable = false, insertable = false,updatable = false)
    public CustomerOrderEntity getCustomerOrderByCustomerOrderId() {
        return customerOrderByCustomerOrderId;
    }

    public void setCustomerOrderByCustomerOrderId(CustomerOrderEntity customerOrderByCustomerOrderId) {
        this.customerOrderByCustomerOrderId = customerOrderByCustomerOrderId;
    }
}
