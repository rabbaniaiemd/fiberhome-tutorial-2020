package com.fiberhome.beancdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    private CartService cartService;
    @Autowired
    public PaymentService(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * setCartService for resolving  circular
     * @param cartService
     */
   @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public void payment() {
        System.out.println("I m payment Service");
    }


}
