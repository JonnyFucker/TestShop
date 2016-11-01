package shop.dao;

import shop.entities.OrderedProductEntity;

import java.util.List;

/**
 * Created by Tomek on 2016-11-01.
 */
public interface OrderedProductDao {
    void save (OrderedProductEntity orderedProduct);
    List<OrderedProductEntity> getOrderedProductsByOrderId(int orderId);
}
