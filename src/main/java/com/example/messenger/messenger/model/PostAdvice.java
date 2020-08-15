package com.example.messenger.messenger.model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // Компонент Обеспечивает сквозную функциональность
@Component
public class PostAdvice {

    @Pointcut("execution(public * com.example.messenger.messenger.controller.*.*(..))")// Срез обьедененных точек (все классы и все методы классов)
    public void callAtMyServicePublic() {}

//Before and After это advice(совет что делать приобнаружении Join points)
//    @Before("callAtMyServicePublic()") // Запускается перед выполнением метода
//    public void beforeAdvice(JoinPoint joinPoint) { // Join point место где будет выполнятся совет(advice)
//        System.out.println("Join point to before " + joinPoint.toString());
//    }
//
//
//    @After("callAtMyServicePublic()") // Запускается после выполнения метода
//    public void afterCallAt(JoinPoint joinPoint) {
//
//        System.out.println("Join point after " + joinPoint.toString());
//    }

    @Around("callAtMyServicePublic()")
    public void around(JoinPoint joinPoint) {
        System.out.println("Join point around " + joinPoint.toString());
    }

}
