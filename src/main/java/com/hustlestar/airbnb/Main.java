package com.hustlestar.airbnb;

import com.hustlestar.airbnb.dao.UserDAO;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yauheni_Malashchytsk on 4/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userOracle");
        System.out.println(userDAO.hashCode());
    }
}
