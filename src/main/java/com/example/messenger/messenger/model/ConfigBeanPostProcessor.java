package com.example.messenger.messenger.model;

import com.example.messenger.messenger.Lissener.MyLissener;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeanPostProcessor {

    @Bean
    public BeanPost printBean() {
        return new BeanPost();
    }

    @Bean
    public MyLissener myLissener() {
        return new MyLissener();
    }


}
