package shop.dao;

import org.springframework.stereotype.Repository;
import shop.entities.CustomerEntity;

/**
 * Created by Tomek on 2016-10-12.
 */
@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {
    @Override
    public void saveCustomer(CustomerEntity customerEntity) {
        persist(customerEntity);
    }
}
