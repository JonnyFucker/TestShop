package shop.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.entities.CustomerOrderEntity;

/**
 * Created by Tomek on 2016-11-01.
 */
@Repository
public class CustomerOrderDaoImpl extends AbstractDao implements CustomerOrderDao {
    @Override
    @Transactional
    public void save(CustomerOrderEntity customerOrderEntity) {
        persist(customerOrderEntity);
    }

    @Override
    @Transactional
    public CustomerOrderEntity getCustomerOrderById(int id) {
        Query query = getSession().createQuery("from CustomerOrderEntity co where co.id=" + id);
        return (CustomerOrderEntity) query.uniqueResult();
    }
}
