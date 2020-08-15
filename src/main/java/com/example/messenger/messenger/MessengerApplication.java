package com.example.messenger.messenger;

import com.example.messenger.messenger.quaters.Quater;
import com.example.messenger.messenger.quaters.TerminatorQuater;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MessengerApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(MessengerApplication.class, args);
//
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
////        while (true ) {
////            Thread.sleep(100);
//           context.getBean(Quater.class).sayQuate();
////        }

    }
}
