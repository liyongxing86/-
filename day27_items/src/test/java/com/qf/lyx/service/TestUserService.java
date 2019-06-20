package com.qf.lyx.service;

import com.qf.lyx.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
public class TestUserService {
    @Test
    public void findAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
        UserService userService = ac.getBean(UserService.class);
        List<User> all = userService.findAll();
        for (User user:all){
            System.out.println(user);
        }
    }
    @Test
    public void findUserByRank(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
        UserService userService = ac.getBean(UserService.class);
        List<User> userByRank = userService.findUserByRank("会员");
        System.out.println(userByRank);
    }
    @Test
    public void addUser(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
        UserService userService = ac.getBean(UserService.class);
        User user=new User("pp","pp123","709059748@qq.com","会员");
        userService.addUser(user);
        System.out.println("添加成功");
    }
}
