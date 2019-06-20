package com.qf.lyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
@Controller
@SessionAttributes("user")
public class AccttypeController {
    @RequestMapping(value = "/accttype")
    public String renzheng(){
        System.out.println("后台跳转");
        return "accttype";
    }

}
