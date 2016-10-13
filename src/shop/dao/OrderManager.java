package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.cart.ShoppingCart;
import shop.entities.AddressEntity;
import shop.entities.CityEntity;
import shop.entities.CustomerEntity;
import utils.OrderParameters;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Tomek on 2016-10-12.
 */
@Repository
public class OrderManager {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private FilmDAO filmDAO;

    public int placeOrder(OrderParameters orderParameters){

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
        cityEntity.setCity(orderParameters.getCity());
        addressEntity.setCityByCityId(cityEntity);

        customerEntity.setAddressEntity(addressEntity);

        customerEntity.setActive(1);
        customerEntity.setStoreId((short) 1);
        customerEntity.setCreateDate(new java.sql.Date(new Date().getTime()));
        customerDao.saveCustomer(customerEntity);
        return 1;
    }
}
