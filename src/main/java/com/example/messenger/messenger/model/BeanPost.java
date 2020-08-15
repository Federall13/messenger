package com.example.messenger.messenger.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       // System.out.println("postProcessBeforeInitialization" + beanName);
        Class<?> classs = bean.getClass();
        if(classs == Post.class) {
            System.out.println();
            System.out.println("-++++++++->  " + bean.getClass() + " <-++++++++-");
        }
        //System.out.println("---------->  " + bean.getClass() + " <-----------");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessAfterInitialization" + beanName);
        return bean;
    }
}
