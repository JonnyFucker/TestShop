package utils;

import shop.cart.ShoppingCart;

/**
 * Created by neptis on 13.10.16.
 */
public class OrderParameters {
   private String firstName;
   private String lastName ;
   private String email ;
   private String phone ;
   private String city ;
   private String postalCode;
   private String address ;
   private ShoppingCart shoppingCart;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }


    public static final class OrderParametersBuilder {
        private String firstName;
        private String lastName ;
        private String email ;
        private String phone ;
        private String city ;
        private String postalCode;
        private String address ;
        private ShoppingCart shoppingCart;

        public OrderParametersBuilder() {
        }

        public OrderParametersBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public OrderParametersBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public OrderParametersBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public OrderParametersBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public OrderParametersBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public OrderParametersBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public OrderParametersBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public OrderParametersBuilder withShoppingCart(ShoppingCart shoppingCart) {
            this.shoppingCart = shoppingCart;
            return this;
        }

        public OrderParameters build() {
            OrderParameters orderParameters = new OrderParameters();
            orderParameters.email = this.email;
            orderParameters.shoppingCart = this.shoppingCart;
            orderParameters.firstName = this.firstName;
            orderParameters.lastName = this.lastName;
            orderParameters.phone = this.phone;
            orderParameters.city = this.city;
            orderParameters.address = this.address;
            orderParameters.postalCode = this.postalCode;
            return orderParameters;
        }
    }
}
