package com.qf.lyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2019/5/31 0031.
 */
@Controller
@SessionAttributes("user")
public class CrowdController {
    /*处理提交的项目信息及发起人信息*/
    /*@RequestMapping(value = "dealFormData")
    public String startstep2(@RequestBody Score[] scores){
        System.out.println(scores);
       *//* String inlineRadioOptions = request.getParameter("inlineRadioOptions");
        System.out.println("分类信息:"+inlineRadioOptions);
        String fenlei = request.getParameter("fenlei");
        System.out.println("标签:"+fenlei);
        String projectname = request.getParameter("projectname");
        System.out.println("项目名称:"+projectname);
        String brief = request.getParameter("brief");
        System.out.println("一句话简介:"+brief);
        String amount = request.getParameter("amount");
        System.out.println("筹资金额:"+amount);
        String fdays = request.getParameter("fdays");
        System.out.println("筹资天数:"+fdays);
        System.out.println("图片---------图片");
        System.out.println("发起人信息======");
        String selfinfo = request.getParameter("selfinfo");
        System.out.println("自我介绍:"+selfinfo);
        String minuteinfo = request.getParameter("minuteinfo");
        System.out.println("详细自我介绍:"+minuteinfo);
        String contactNumber = request.getParameter("contactNumber");
        System.out.println("联系电话:"+contactNumber);
        String serviceTel = request.getParameter("serviceTel");
        System.out.println("客服电话:"+serviceTel);*//*

        return "start-step-2";
    }*/
    @RequestMapping(value = "crowdProjectInfo",method = RequestMethod.POST)
    @ResponseBody
    public String startstep2(@RequestParam("form1") String form1, @RequestParam("form2") String form2) {

        System.out.println(form1);

        System.out.println(form2);

        return "success";
    }
}
