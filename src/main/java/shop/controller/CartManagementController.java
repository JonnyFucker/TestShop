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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

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
    public String purchase(HttpServletRequest httpServletRequest) throws IOException {

        OrderParameters orderParameters =
                OrderParameters.builder()
                        .address(httpServletRequest.getParameter("address"))
                        .city(httpServletRequest.getParameter("city"))
                        .email(httpServletRequest.getParameter("email"))
                        .firstName(httpServletRequest.getParameter("firstName"))
                        .lastName(httpServletRequest.getParameter("lastName"))
                        .postalCode(httpServletRequest.getParameter("postalCode"))
                        .phone(httpServletRequest.getParameter("phone"))
                        .shoppingCart(shoppingCart)
                        .build();

        int orderId = orderManager.placeOrder(orderParameters);
        Map<String, Object> orderMap = orderManager.getOrderDetails(orderId);
        // place order details in request scope
        httpServletRequest.setAttribute("customer", orderMap.get("customer"));
        httpServletRequest.setAttribute("products", orderMap.get("products"));
        httpServletRequest.setAttribute("orderRecord", orderMap.get("orderRecord"));
        httpServletRequest.setAttribute("orderedProducts", orderMap.get("orderedProducts"));

        httpServletRequest.getSession().invalidate();

        return "confirmation";
    }
}
