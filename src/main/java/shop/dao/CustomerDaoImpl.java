package shop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.entities.CityEntity;
import shop.entities.CustomerEntity;

/**
 * Created by Tomek on 2016-10-12.
 */
@Repository
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {
    @Override
    @Transactional
    public void saveCustomer(CustomerEntity customerEntity) {
        persist(customerEntity);
    }
}
