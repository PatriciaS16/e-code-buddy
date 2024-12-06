package com.codeforall.online.ecodebuddy;

import com.codeforall.online.ecodebuddy.model.Code;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Code mockCode;

/*
        mockCode = Code.getInstance();
        mockCode.setName("Jeje");
        mockCode.setId(1);

        System.out.println("Name " + mockCode.getName() + " id " + mockCode.getId() + mockCode);

        System.out.println(mockCode.getBins());
        System.out.println(mockCode.getDialogs().size());

        ApplicationContext context = new AnnotationConfigApplicationContext("com.codeforall.online.ecodebuddy");
        Code contextCode = context.getBean("code",Code.class);
        System.out.println(contextCode.getName());

*/
    }
}