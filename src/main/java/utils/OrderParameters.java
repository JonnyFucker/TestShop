package utils;

import lombok.Builder;
import lombok.Data;
import shop.cart.ShoppingCart;

/**
 * Created by Tomek on 31.10.16.
 */
@Builder
@Data
public class OrderParameters {
    private String firstName;
    private String lastName ;
    private String email ;
    private String phone ;
    private String city ;
    private String postalCode;
    private String address ;
    private ShoppingCart shoppingCart;
}
