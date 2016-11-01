package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.cart.ShoppingCart;
import shop.cart.ShoppingCartItem;
import shop.entities.*;
import utils.OrderParameters;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Tomek on 2016-10-12.
 */
@Repository
public class OrderManager {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private FilmDAO filmDAO;
    @Autowired
    private CustomerOrderDao customerOrderDao;
    @Autowired
    private OrderedProductDao orderedProductDao;

    @Transactional
    public int placeOrder(OrderParameters orderParameters) {

        try {
            CustomerEntity customer = addCustomer(orderParameters);
            CustomerOrderEntity customerOrder = addOrder(customer, orderParameters.getShoppingCart());
            addOrderedItem(customerOrder, orderParameters.getShoppingCart());
            return customerOrder.getId();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public Map<String, Object> getOrderDetails(int orderId) {
        Map orderMap = new HashMap();
        CustomerOrderEntity customerOrderEntity = customerOrderDao.getCustomerOrderById(orderId);
        CustomerEntity customerEntity = customerOrderEntity.getCustomerByCustomerId();
        List<OrderedProductEntity> orderedProducts = orderedProductDao.getOrderedProductsByOrderId(orderId);
        List<FilmEntity> films = new ArrayList<>();

        for (OrderedProductEntity product : orderedProducts){
            FilmEntity filmEntity = filmDAO.getFilmById(product.getFilmFilmId());
            films.add(filmEntity);
        }

        // add each item to orderMap
        orderMap.put("orderRecord", customerOrderEntity);
        orderMap.put("customer", customerEntity);
        orderMap.put("orderedProducts", orderedProducts);
        orderMap.put("products", films);

        System.out.println(customerOrderEntity.getId());
        System.out.println(customerEntity.getCustomerId());

        return orderMap;
    }

    private void addOrderedItem(CustomerOrderEntity customerOrder, ShoppingCart shoppingCart) {

        for (ShoppingCartItem shoppingCartItem : shoppingCart.getShoppingCartItems()) {
            int productId = shoppingCartItem.getProduct().getFilmId();

            OrderedProductEntity orderedProductEntity = new OrderedProductEntity();
            orderedProductEntity.setFilmFilmId(productId);
            orderedProductEntity.setCustomerOrderId(customerOrder.getId());
            orderedProductEntity.setQuantity(shoppingCartItem.getQuantity());
            orderedProductDao.save(orderedProductEntity);
        }
    }

    private CustomerOrderEntity addOrder(CustomerEntity customer, ShoppingCart shoppingCart) {
        CustomerOrderEntity customerOrderEntity = new CustomerOrderEntity();
        customerOrderEntity.setCustomerByCustomerId(customer);
        customerOrderEntity.setAmount(BigDecimal.valueOf(shoppingCart.getTotal()));

        // create confirmation number
        Random random = new Random();
        int i = random.nextInt(999999999);
        customerOrderEntity.setConfirmationNumber(i);

        //data created
        customerOrderEntity.setDateCreated(new Timestamp(new Date().getTime()));

        customerOrderDao.save(customerOrderEntity);

        return customerOrderEntity;
    }

    private CustomerEntity addCustomer(OrderParameters orderParameters) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setEmail(orderParameters.getEmail());
        customerEntity.setFirstName(orderParameters.getFirstName());
        customerEntity.setLastName(orderParameters.getLastName());
        customerEntity.setLastUpdate(new Timestamp(new Date().getTime()));

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress(orderParameters.getAddress());
        addressEntity.setPhone(orderParameters.getPhone());
        addressEntity.setPostalCode(orderParameters.getPostalCode());
        addressEntity.setLastUpdate(new Timestamp(new Date().getTime()));

        CityEntity cityEntity = new CityEntity();
        cityEntity.setLastUpdate(new Timestamp(new Date().getTime()));
        cityEntity.setCity(orderParameters.getCity());
        cityEntity.setCountryId((short) 76);

        addressEntity.setCityByCityId(cityEntity);
        customerEntity.setAddressByAddressId(addressEntity);

        customerEntity.setActive((byte) 1);
        customerEntity.setStoreId((short) 1);
        customerEntity.setCreateDate(new Timestamp(new Date().getTime()));

        return customerEntity;
    }
}
