package com.qf.lyx.service;

import com.qf.lyx.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */

public interface UserService {
   /*查寻祝所有账户*/
    public List<User> findAll();
   /*根据身份查询账户*/
    public List<User> findUserByRank(String rank);
   /*添加账户*/
    public void addUser(User user);
   /*根据账户名查询用户*/
    public User findUserByName(String account);
    /*根据账户名模糊查询用户*/
    public List<User> findUserLike(String account);
    /*根据id查询用户*/
    public User findUserById(int id);
    /*根据id删除用户*/
    public void delUser(int id);
    /*修改用户信息*/
    public void upUser(User user);
}
