package com.fiberhome.beancomponent;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("primiumCustomer")
public class PrimimunCustomer implements Customer {
    int shippingCost =0;
    @Override
    public void addProduct() {
        System.out.println("Primimium customer shipping cost will be"+shippingCost);
    }

}
