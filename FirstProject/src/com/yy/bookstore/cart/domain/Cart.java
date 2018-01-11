package com.yy.bookstore.cart.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart{
    private Map<String,CartItem> cartItemMap = new HashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "cartItemMap=" + cartItemMap +
                '}';
    }

    public Map<String, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<String, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Cart() {

    }

    public Cart(Map<String, CartItem> cartItemMap) {

        this.cartItemMap = cartItemMap;
    }

    public void clear(){
        this.cartItemMap.clear();
    }
    public void delete(String bid){
        this.cartItemMap.remove(bid);
    }

}
