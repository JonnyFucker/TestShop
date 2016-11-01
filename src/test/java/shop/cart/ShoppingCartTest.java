package shop.cart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shop.entities.FilmEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Tomek on 2016-10-05.
 */
public class ShoppingCartTest {
    FilmEntity filmEntity;
    FilmEntity filmEntityClone;
    FilmEntity filmEntity2;
    @Before
    public void init(){
        filmEntity = new FilmEntity();
        filmEntity.setFilmId((short) 1);
        filmEntity.setDescription("description");
        filmEntity.setLastUpdate(new Timestamp(22));
        filmEntity.setLength((short) 3);
        filmEntity.setRentalDuration((byte) 5);
        filmEntity.setRentalRate(BigDecimal.ONE);
        filmEntity.setReplacementCost(BigDecimal.TEN);
        filmEntity.setTitle("newTitle");

        filmEntityClone = new FilmEntity();
        filmEntityClone.setFilmId((short) 1);
        filmEntityClone.setDescription("description");
        filmEntityClone.setLastUpdate(new Timestamp(22));
        filmEntityClone.setLength((short) 3);
        filmEntityClone.setRentalDuration((byte) 5);
        filmEntityClone.setRentalRate(BigDecimal.ONE);
        filmEntityClone.setReplacementCost(BigDecimal.TEN);
        filmEntityClone.setTitle("newTitle");

        //different id
        filmEntity2 = new FilmEntity();
        filmEntity2.setFilmId((short) 2);
        filmEntity2.setDescription("description");
        filmEntity2.setLastUpdate(new Timestamp(22));
        filmEntity2.setLength((short) 3);
        filmEntity2.setRentalDuration((byte) 5);
        filmEntity2.setRentalRate(BigDecimal.ONE);
        filmEntity2.setReplacementCost(BigDecimal.TEN);
        filmEntity2.setTitle("newTitle");

    }
    @Test
    public void shoppingCartItemEqualTest(){
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(filmEntity);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(filmEntityClone);
        shoppingCartItem2.incrementQuantity();

        Assert.assertTrue(shoppingCartItem1.equals(shoppingCartItem2));
    }
    @Test
    public void addThisSameItemsToCartTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(filmEntity);
        shoppingCart.addItem(filmEntityClone);
        Assert.assertEquals(1,shoppingCart.getShoppingCartItems().size());
        Assert.assertEquals(2,shoppingCart.getShoppingCartItems().get(0).getQuantity());
    }
    @Test
    public void addDifferentItemsToCartTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(filmEntity);
        shoppingCart.addItem(filmEntity2);
        Assert.assertEquals(2,shoppingCart.getShoppingCartItems().size());
        Assert.assertEquals(1,shoppingCart.getShoppingCartItems().get(0).getQuantity());
        Assert.assertEquals(1,shoppingCart.getShoppingCartItems().get(1).getQuantity());

    }
    @Test
    public void updateEndedRemove(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(filmEntity);
        shoppingCart.update(filmEntity,(short) 0);
        Assert.assertEquals(0,shoppingCart.getShoppingCartItems().size());
    }
    @Test
    public void updateQuantityToTwo(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(filmEntity);
        shoppingCart.update(filmEntity, (short) 2);
        ShoppingCartItem shoppingCartItem = shoppingCart.getShoppingCartItem(filmEntity);
        Assert.assertEquals(2,shoppingCartItem.getQuantity());

        Assert.assertEquals(2,shoppingCart.getNumberOfItems());
    }
    @Test
    public void subTotalPriceTwentyDollars(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(filmEntity);
        shoppingCart.update(filmEntity, (short) 2);
        Assert.assertEquals(20,shoppingCart.getSubTotal(),0.0001);
        Assert.assertNotEquals(10,shoppingCart.getSubTotal(),0.0001);
    }
    @Test
    public void totalPriceEqualsTwentyDollarsPlus5Dollars(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(filmEntity);
        shoppingCart.update(filmEntity, (short) 2);
        shoppingCart.setSurcharge(5);

        Assert.assertEquals(25,shoppingCart.getTotal(),0.0001);
        Assert.assertNotEquals(10,shoppingCart.getTotal(),0.0001);
    }
}
