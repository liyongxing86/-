package com.qf.lyx.controller;

import com.qf.lyx.pojo.User;
import com.qf.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
@Controller
public class RegController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/reg")
    public String login(){
        System.out.println("后台跳转");
        return "reg";
    }
    @RequestMapping(value = "/regyz",method = RequestMethod.POST)
    public String zhuce(HttpServletRequest request, HttpServletResponse response, Model model) {
        String account = request.getParameter("account");
        String upw = request.getParameter("upw");
        String email = request.getParameter("email");
        String rank = request.getParameter("rank");
        String name=account;
        System.out.println(account + "---" + upw + "---" + email + "---" + rank);
        User user = new User(account,name,upw, email, rank);
        User userByName = userService.findUserByName(account);
        String yemian=null;
            if (userByName == null) {//说明数据库而里面没有这个信息,添加
                if (account!="" && upw!="" && email!="") {//并且输入的信息不能为空
                userService.addUser(user);
                model.addAttribute("user", userByName);
                yemian = "login";
                }else {
                    yemian="reg";
                }
            } else {//不能添加
                System.out.println("添加失败");
                yemian = "reg";
            }
        return yemian;
    }

}
