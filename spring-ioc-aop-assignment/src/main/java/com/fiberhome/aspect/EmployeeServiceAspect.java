package com.fiberhome.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(value = "execution(* com.fiberhome.service.EmployeeService.*(..)) and args(name,empId)")
    public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("Before method:" + joinPoint.getSignature());

        System.out.println("Creating Employee with name - " + name + " and id - " + empId);
    }

    @After(value = "execution(* com.fiberhome.service.EmployeeService.*(..)) and args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method:" + joinPoint.getSignature());

        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }
   @Around(value = "execution(* com.fiberhome.service.EmployeeService.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
	   System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
	   try {
		   Object result =joinPoint.proceed();
		   System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": After Method Execution");
		   return result;
	   } finally {
	   }
    }
}
