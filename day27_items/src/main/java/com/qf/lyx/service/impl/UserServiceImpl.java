package com.qf.lyx.service.impl;

import com.qf.lyx.mapper.UserMapper;
import com.qf.lyx.pojo.User;
import com.qf.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @Override
    public List<User> findUserByRank(String rank) {
        List<User> userByRank = userMapper.findUserByRank(rank);
        return userByRank;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUer(user);
    }

    @Override
    public User findUserByName(String account) {
        User userByName = userMapper.findUserByName(account);
        return userByName;
    }

    @Override
    public List<User> findUserLike(String account) {
        List<User> userLike = userMapper.findUserLike(account);
        return userLike;
    }

    @Override
    public User findUserById(int id) {
        User userById = userMapper.findUserById(id);
        return userById;
    }

    @Override
    public void delUser(int id) {
        userMapper.delUser(id);
    }

    @Override
    public void upUser(User user) {
        userMapper.upUser(user);
    }


}
