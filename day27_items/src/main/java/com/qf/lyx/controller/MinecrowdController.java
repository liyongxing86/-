package com.qf.lyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/5/31 0031.
 */
@Controller
@SessionAttributes("user")
public class MinecrowdController {
    /*处理跳转众筹页面的请求*/
    @RequestMapping(value = "/minecrowdfunding")
    public String minecrowd(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) {
        String audit = (String)request.getSession().getAttribute("audit");
        model.addAttribute("audit",audit);
        return "minecrowdfunding";
    }
    /*处理发起众筹的请求*/
    @RequestMapping(value = "/start")
    public String start() {
        return "start";
    }
    /*跳转填写项目信息的页面的请求*/
    @RequestMapping(value = "/start-step-1")
    public String startstep1() {
        return "start-step-1";
    }
    /*跳转设置回报页面的请求*/
    @RequestMapping(value = "/start-step-2")
    public String startstep2() {
        return "start-step-2";
    }
    /*处理跳转确认信息页面的请求*/
    @RequestMapping(value = "/start-step-3")
    public String startstep3() {
        return "start-step-3";
    }
    /*处理跳转确认信息页面的请求*/
    @RequestMapping(value = "/start-step-4")
    public String startstep4() {
        return "start-step-4";
    }
}
