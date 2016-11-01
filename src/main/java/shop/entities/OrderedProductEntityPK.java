package shop.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Tomek on 2016-11-01.
 */
public class OrderedProductEntityPK implements Serializable {
    private Integer customerOrderId;
    private Integer filmFilmId;

    @Column(name = "customer_order_id")
    @Id
    public Integer getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Integer customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    @Column(name = "film_film_id")
    @Id
    public Integer getFilmFilmId() {
        return filmFilmId;
    }

    public void setFilmFilmId(Integer filmFilmId) {
        this.filmFilmId = filmFilmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderedProductEntityPK that = (OrderedProductEntityPK) o;

        if (customerOrderId != null ? !customerOrderId.equals(that.customerOrderId) : that.customerOrderId != null)
            return false;
        if (filmFilmId != null ? !filmFilmId.equals(that.filmFilmId) : that.filmFilmId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerOrderId != null ? customerOrderId.hashCode() : 0;
        result = 31 * result + (filmFilmId != null ? filmFilmId.hashCode() : 0);
        return result;
    }
}
