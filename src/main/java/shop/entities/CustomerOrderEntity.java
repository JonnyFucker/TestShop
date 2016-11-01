package shop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Tomek on 2016-11-01.
 */
@Entity
@Table(name = "customer_order", schema = "sakila", catalog = "")
public class CustomerOrderEntity {
    private Integer id;
    private BigDecimal amount;
    private Timestamp dateCreated;
    private Integer confirmationNumber;
    private CustomerEntity customerByCustomerId;
    private Collection<OrderedProductEntity> orderedProductsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public Integer getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(Integer confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrderEntity that = (CustomerOrderEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (confirmationNumber != null ? !confirmationNumber.equals(that.confirmationNumber) : that.confirmationNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (confirmationNumber != null ? confirmationNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade = CascadeType.ALL)
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
