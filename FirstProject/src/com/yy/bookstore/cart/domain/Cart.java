package com.yy.bookstore.cart.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart{
    private Map<String,Cartltem> cartltemMap = new HashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "cartltemMap=" + cartltemMap +
                '}';
    }

    public Map<String, Cartltem> getCartltemMap() {
        return cartltemMap;
    }

    public void setCartltemMap(Map<String, Cartltem> cartltemMap) {
        this.cartltemMap = cartltemMap;
    }

    public Cart() {

    }

    public Cart(Map<String, Cartltem> cartltemMap) {

        this.cartltemMap = cartltemMap;
    }
}
