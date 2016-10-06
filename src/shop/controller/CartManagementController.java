package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import shop.cart.ShoppingCart;
import shop.cart.ShoppingCartItem;
import shop.dao.FilmDAO;
import shop.entities.FilmEntity;

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

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToShoppingCart(@RequestParam("filmId") int filmId) {
        FilmEntity filmEntity = filmDAO.getFilmById(filmId);
        shoppingCart.addItem(filmEntity);

        return "index";
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
}
