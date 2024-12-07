package com.codeforall.online.ecodebuddy;

import com.codeforall.online.ecodebuddy.model.Code;
import com.codeforall.online.ecodebuddy.model.item.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");




        ApplicationContext context = new AnnotationConfigApplicationContext("com.codeforall.online.ecodebuddy");
        Item contextCode = context.getBean("item", Item.class);
        System.out.println(contextCode.getName());


    }
}