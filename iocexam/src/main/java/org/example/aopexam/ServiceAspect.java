package org.example.aopexam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Before("execution(* org.example.aopexam.SimpleService.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("Before :::::::::: "+ joinPoint.getSignature().getName());
    }

    @After("execution(* org.example.aopexam.SimpleService.*(..))")
    public void after(){
        System.out.println("After :::::::::::::::::");
    }
}
