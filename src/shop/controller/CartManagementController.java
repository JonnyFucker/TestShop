package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.cart.ShoppingCart;
import shop.cart.ShoppingCartItem;
import shop.dao.CustomerDao;
import shop.dao.FilmDAO;
import shop.dao.OrderManager;
import shop.entities.*;
import utils.OrderParameters;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by neptis on 06.10.16.
 */
@Controller
@Scope("request")
public class CartManagementController {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private FilmDAO filmDAO;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrderManager orderManager;

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    @ResponseBody
    public void addToShoppingCart(@RequestParam("filmId") int filmId) {
        FilmEntity filmEntity = filmDAO.getFilmById(filmId);
        shoppingCart.addItem(filmEntity);
    }

    @RequestMapping(value = "/updateQuantityInCart", method = RequestMethod.POST)
    @ResponseBody
    public ShoppingCartItem updateQuantityInShoppingCart(@RequestParam("filmId") int filmId, @RequestParam("quantity") short quantity) {
        FilmEntity filmEntity = filmDAO.getFilmById(filmId);
        shoppingCart.update(filmEntity, quantity);
        return shoppingCart.getShoppingCartItem(filmEntity);
    }

    @RequestMapping(value = "/shoppingCart", produces = "application/json")
    @ResponseBody
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @RequestMapping(value = "/removeItem", method = RequestMethod.POST)
    @ResponseBody
    public void removeItemFromCart(@RequestParam("filmId") int filmId) {
        FilmEntity filmEntity = filmDAO.getFilmById(filmId);
        shoppingCart.remove(filmEntity);
    }

    @RequestMapping(value = "/clearCart")
    @ResponseBody
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

        OrderParameters orderParameters =
                new OrderParameters.OrderParametersBuilder()
                        .withAddress(address)
                        .withCity(city)
                        .withEmail(email)
                        .withFirstName(firstName)
                        .withLastName(lastName)
                        .withPostalCode(postalCode)
                        .withPhone(phone)
                        .withShoppingCart(shoppingCart)
                        .build();



        orderManager.placeOrder(orderParameters);


        return modelAndView;
    }
}
