package shop.dao;

import shop.entities.CityEntity;
import shop.entities.CustomerEntity;

/**
 * Created by Tomek on 2016-10-12.
 */
public interface CustomerDao {
    public void saveCustomer(CustomerEntity customerEntity);
}
