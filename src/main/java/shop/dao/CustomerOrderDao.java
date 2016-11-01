package shop.dao;

import shop.entities.CustomerOrderEntity;

/**
 * Created by Tomek on 2016-11-01.
 */
public interface CustomerOrderDao {
    void save(CustomerOrderEntity customerOrderEntity);
    CustomerOrderEntity getCustomerOrderById(int id);
}
