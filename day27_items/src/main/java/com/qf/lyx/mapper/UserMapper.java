package com.qf.lyx.mapper;

import com.qf.lyx.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
public interface UserMapper {
    /*查询所有用户*/
    public List<User> findAll();
    /*根据rank查询用户*/
    public List<User> findUserByRank(String rank);
    /*添加用户*/
    public void addUer(User user);
    /*根据账号查询用户*/
    public User findUserByName(String account);
    /*根据用户账号模糊查询用户*/
    public List<User> findUserLike(String account);
    /*根据id查询用户*/
    public User findUserById(int id);
    /*根据id删除用户*/
    public void delUser(int id);
    /*修改用户信息*/
    public void upUser(User user);
}
