package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.cart.ShoppingCart;
import shop.cart.ShoppingCartItem;
import shop.dao.CustomerDao;
import shop.dao.FilmDAO;
import shop.entities.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by neptis on 06.10.16.
 */
@org.springframework.web.bind.annotation.RestController
@Scope("request")
public class CartManagementController {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private FilmDAO filmDAO;

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public void addToShoppingCart(@RequestParam("filmId") int filmId) {
        FilmEntity filmEntity = filmDAO.getFilmById(filmId);
        shoppingCart.addItem(filmEntity);
    }

    @RequestMapping(value = "/updateQuantityInCart", method = RequestMethod.POST)
    public ShoppingCartItem updateQuantityInShoppingCart(@RequestParam("filmId") int filmId, @RequestParam("quantity") short quantity) {
        FilmEntity filmEntity = filmDAO.getFilmById(filmId);
        shoppingCart.update(filmEntity, quantity);
        return shoppingCart.getShoppingCartItem(filmEntity);
    }

    @RequestMapping(value = "/shoppingCart")
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @RequestMapping(value = "/removeItem", method = RequestMethod.POST)
    public void removeItemFromCart(@RequestParam("filmId") int filmId) {
        FilmEntity filmEntity = filmDAO.getFilmById(filmId);
        shoppingCart.remove(filmEntity);
    }

    @RequestMapping(value = "/clearCart")
    public void clearCart() {
        shoppingCart.clear();
    }

    @RequestMapping(value = "/purchase")
    public ModelAndView purchase(HttpServletRequest httpServletRequest) {
        //TODO should do something better than ModelAndView
        ModelAndView modelAndView = new ModelAndView("confirmation");

        String firstName = httpServletRequest.getParameter("firstName");
        String lastName = httpServletRequest.getParameter("lastName");
        String email = httpServletRequest.getParameter("email");
        String phone = httpServletRequest.getParameter("phone");
        String city = httpServletRequest.getParameter("city");
        String postalCode = httpServletRequest.getParameter("postalCode");
        String address = httpServletRequest.getParameter("address");

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(city);
        System.out.println(postalCode);
        System.out.println(address);
        System.out.println("shopping cart items : " + shoppingCart.getNumberOfItems());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setEmail(email);
        customerEntity.setFirstName(firstName);
        customerEntity.setActive((byte) 1);
        customerEntity.setLastName(lastName);
        customerEntity.setLastUpdate(new Timestamp(new Date().getTime()));
        customerEntity.setStoreId(1);
        customerEntity.setAddressId(1);

        CustomerOrderEntity customerOrderEntity;
        //customerDao.saveCustomer(customerEntity);
        return modelAndView;
    }
}
