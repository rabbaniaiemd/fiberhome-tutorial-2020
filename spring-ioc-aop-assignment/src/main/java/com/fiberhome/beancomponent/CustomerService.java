package com.fiberhome.beancomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerService  {
    @Autowired
    @Qualifier("primiumCustomer")
    private Customer customer;
    public Customer getCustomer() {
        return customer;
    }


}
