package com.fiberhome.beancomponent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CustomerBuisnessService {
    @Bean
    @Primary
    public PrimimunCustomer getPrimiumCustomer() {
        return new PrimimunCustomer();
    }
    @Bean
    public GeneralCustomer getGeneralCustomer() {
        return new GeneralCustomer();
    }
}
