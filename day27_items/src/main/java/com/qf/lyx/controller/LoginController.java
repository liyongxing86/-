package com.qf.lyx.controller;

import com.qf.lyx.pojo.Approve;
import com.qf.lyx.pojo.User;
import com.qf.lyx.service.ApproveService;
import com.qf.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
@Controller
@SessionAttributes("user")

public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApproveService approveService;
    @RequestMapping(value = "/login")
    public String login(){
        System.out.println("后台跳转");
        return "login";
    }
    /*处理登陆的请求*/
    @RequestMapping(value = "/loginyz",method = RequestMethod.POST)
    public String yanzheng(HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model){
        String account=request.getParameter("account");
        String upw =request.getParameter("upw");
        String rank=request.getParameter("rank");
        /*根据用户账号查询用户信息*/
        User userByName = userService.findUserByName(account);
        String name = userByName.getName();
        System.out.println(name+"-----"+upw+"______"+rank+"----"+account);
        List<User> userByRank = userService.findUserByRank(rank);
        /*将用户信息存入会话之中*/
        model.addAttribute("user",userByName);
        /*根据用户账号查询用户认证状态*/
        Approve approve = approveService.findAppByAccount(account);
        String audit=null;
        if (approve!=null){
             audit = approve.getAudit();
        }
        if (audit!=null){
            model.addAttribute("audit",audit);
        }
        session=request.getSession();
        session.setAttribute("audit",audit);
        String yemian="login";
        for (User user:userByRank){
            if (user.getAccount().equals(account) && user.getPw().equals(upw) && user.getRank().equals("管理")){
                yemian="main";
                System.out.println("后台页面");
            }else if (user.getAccount().equals(account) && user.getPw().equals(upw) && user.getRank().equals("会员")){
                 yemian="member";
                System.out.println("前台页面");
            }
        }
        System.out.println(yemian);
        return yemian;
    }
    @RequestMapping(value = "/member")
    public String vip(){
        return "member";
    }
}
