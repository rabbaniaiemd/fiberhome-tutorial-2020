package com.fiberhome.assignment;

import com.fiberhome.beancdi.CartService;
import com.fiberhome.beancomponent.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Configuration
@ComponentScan(basePackages = "com.fiberhome")
public class SpringIocAopAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIocAopAssignmentApplication.class, args);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
		CartService cartService=context.getBean("cartService",CartService.class);
		cartService.addCart();
		AnnotationConfigApplicationContext anocontext =
				new AnnotationConfigApplicationContext();
		anocontext.scan("com.fiberhome.beancomponent");
		anocontext.refresh();
		CustomerService customer = anocontext.getBean(CustomerService.class);
		customer.getCustomer().addProduct();
		AnnotationConfigApplicationContext customerBuisnessService = new AnnotationConfigApplicationContext(CustomerBuisnessService.class);
		GeneralCustomer generalCustomer = customerBuisnessService.getBean(GeneralCustomer.class);
		generalCustomer.addProduct();
		PrimimunCustomer primimunCustomer = customerBuisnessService.getBean(PrimimunCustomer.class);
		primimunCustomer.addProduct();


	}

}
