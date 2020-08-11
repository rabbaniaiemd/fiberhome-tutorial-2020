package com.fiberhome.beancomponent;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("GeneralCustomer")
public class GeneralCustomer implements Customer {
    int shippingCost = 200;
    @Override
    public void addProduct() {
      System.out.println("General customer shipping cost will be"+shippingCost);
    }
}
