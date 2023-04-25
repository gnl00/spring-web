package com.demo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {
    private static final Logger logger = Logger.getLogger(MVCMain.class);

    public static void main(String[] args) {
        logger.info("Hello world!");

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-beans.xml");
        Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);
    }
}