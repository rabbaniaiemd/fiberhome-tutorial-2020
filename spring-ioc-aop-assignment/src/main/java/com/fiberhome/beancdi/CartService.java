package com.fiberhome.beancdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CartService {

    private PaymentService paymentService;
    @Autowired
    @Lazy    /**  Remove lazy for generate circular Dependencies error  */

    public CartService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * for resolving for circular dependencies using setter injection
     * @param paymentService
     */
    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }





    public void addCart() {
        System.out.println("I m cart service");
    }
}
