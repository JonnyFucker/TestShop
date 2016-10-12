package shop.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Tomek on 2016-10-11.
 */
public class OrderedProductEntityPK implements Serializable {
    private int customerOrderId;
    private short filmFilmId;

    @Column(name = "customer_order_id")
    @Id
    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    @Column(name = "film_film_id")
    @Id
    public short getFilmFilmId() {
        return filmFilmId;
    }

    public void setFilmFilmId(short filmFilmId) {
        this.filmFilmId = filmFilmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderedProductEntityPK that = (OrderedProductEntityPK) o;

        if (customerOrderId != that.customerOrderId) return false;
        if (filmFilmId != that.filmFilmId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerOrderId;
        result = 31 * result + (int) filmFilmId;
        return result;
    }
}
