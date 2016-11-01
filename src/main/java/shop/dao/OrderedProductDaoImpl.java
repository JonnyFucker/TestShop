package shop.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.entities.OrderedProductEntity;

import java.util.List;

/**
 * Created by Tomek on 2016-11-01.
 */
@Repository
public class OrderedProductDaoImpl extends AbstractDao implements OrderedProductDao {
    @Override
    @Transactional
    public List<OrderedProductEntity> getOrderedProductsByOrderId(int orderId) {
        Query query = getSession().createQuery("from OrderedProductEntity op where op.customerOrderId=" + orderId);
        return query.list();
    }

    @Override
    @Transactional
    public void save(OrderedProductEntity orderedProduct) {
        persist(orderedProduct);
    }
}
