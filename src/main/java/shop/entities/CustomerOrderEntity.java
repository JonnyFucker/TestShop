package shop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Tomek on 2016-10-11.
 */
@Entity
@Table(name = "customer_order", schema = "sakila")
public class CustomerOrderEntity {
    private int id;
    private BigDecimal amount;
    private Timestamp dateCreated;
    private int confirmationNumber;
    private CustomerEntity customerByCustomerId;
    private Collection<OrderedProductEntity> orderedProductsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date_created")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "confirmation_number")
    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrderEntity that = (CustomerOrderEntity) o;

        if (id != that.id) return false;
        if (confirmationNumber != that.confirmationNumber) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + confirmationNumber;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @OneToMany(mappedBy = "customerOrderByCustomerOrderId")
    public Collection<OrderedProductEntity> getOrderedProductsById() {
        return orderedProductsById;
    }

    public void setOrderedProductsById(Collection<OrderedProductEntity> orderedProductsById) {
        this.orderedProductsById = orderedProductsById;
    }
}
