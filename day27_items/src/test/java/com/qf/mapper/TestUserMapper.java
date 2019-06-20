package com.qf.mapper;

import com.qf.lyx.mapper.UserMapper;
import com.qf.lyx.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
public class TestUserMapper {
    @Test
    public void findAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = ac.getBean(UserMapper.class);
        List<User> all = userMapper.findAll();
        for (User user:all){
            System.out.println(user);
        }
    }
    @Test
    public void findUserByRank(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = ac.getBean(UserMapper.class);
        List<User> userByRank = userMapper.findUserByRank("会员");
        System.out.println(userByRank);
    }
    @Test
    public void addUser(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = ac.getBean(UserMapper.class);
        User user=new User("pp","pp123","709059748@qq.com","会员");
        userMapper.addUer(user);
        System.out.println("添加成功");
    }
    @Test
    public void findUserByName(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = ac.getBean(UserMapper.class);
        User pp = userMapper.findUserByName("pp");
        System.out.println(pp);
    }
    @Test
    public void findUserLike(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = ac.getBean(UserMapper.class);
        List<User> userLike = userMapper.findUserLike("p");
        System.out.println(userLike);
    }
    @Test
    public void findUserById(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = ac.getBean(UserMapper.class);
        User userById = userMapper.findUserById(19);
        System.out.println(userById);
    }

    @Test
    public void upUser(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = ac.getBean(UserMapper.class);
        User user=new User();
        user.setId(18);
        user.setName("kkkk");
        user.setAccount("kkkk");
        user.setPw("kkkk");
        user.setEmail("456789@qq,com");
        user.setRank("会员");
        userMapper.upUser(user);
    }

}
