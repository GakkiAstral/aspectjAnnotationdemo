package com.bjsxt.test;

import com.bjsxt.service.UsersService;
import com.bjsxt.service.impl.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService = (UsersService)applicationContext.getBean("usersService");
        usersService.addUsers("Oldlu");
    }
}
