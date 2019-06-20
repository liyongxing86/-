package com.qf.lyx.controller;

import com.qf.lyx.pojo.Approve;
import com.qf.lyx.pojo.User;
import com.qf.lyx.service.ApproveService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2019/5/29 0029.
 */
@Controller
@SessionAttributes("user")
public class AatumController {
    @Autowired
    ApproveService approveService;
    @RequestMapping(value = "/apply")
    public String renzheng(){
        return "apply";
    }
    /*定义成员变量--用户认证选择的认证类型*/
    String autype;
    @RequestMapping(value = "/apply-1",method = RequestMethod.POST)
    public String apply1(HttpServletRequest request, HttpServletResponse response, Model model){
        String name = request.getParameter("name");
        String id_card = request.getParameter("ID_card");
        String phone_code = request.getParameter("phone_code");
        model.addAttribute("name",name);
        model.addAttribute("phone_code",phone_code);
        model.addAttribute("id_card",id_card);
        System.out.println(name);
        System.out.println(id_card);
        System.out.println(phone_code);

        return "apply-1";
    }
    @RequestMapping(value = "/apply-2",method = RequestMethod.POST)
    public String apply2(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response,Model model){
        String name = request.getParameter("name");
        String phone_code = request.getParameter("phone_code");
        String id_card = request.getParameter("id_card");
        System.out.println(name+"------"+phone_code+"----"+id_card);
        String path = request.getSession().getServletContext().getRealPath("upload");
        String filename = file.getOriginalFilename();
        String location=path+"/"+filename;
        System.out.println(location);
        model.addAttribute("name",name);
        model.addAttribute("id_card",id_card);
        model.addAttribute("phone_code",phone_code);
        model.addAttribute("location",filename);
        File f = new File(location);
        try {

            f.createNewFile();
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "apply-2";
    }
    @RequestMapping(value = "/apply-3",method = RequestMethod.POST)
    public String apply3(HttpServletRequest request,HttpServletResponse response,Model model){
        String name = request.getParameter("name");
        String phone_code = request.getParameter("phone_code");
        String id_card = request.getParameter("id_card");
        String email = request.getParameter("email");
        String location = request.getParameter("location");

        model.addAttribute("name",name);
        model.addAttribute("phone_code",phone_code);
        model.addAttribute("id_card",id_card);
        model.addAttribute("email",email);
        model.addAttribute("location",location);

        return "apply-3";
    }
    @RequestMapping(value = "/tjxx",method = RequestMethod.POST)
    public String tjxx(HttpServletRequest request,HttpServletResponse response,Model model){
        /*获取用户认证提交的信息*/
        String name = request.getParameter("name");
        String phone_code = request.getParameter("phone_code");
        String ID_card = request.getParameter("id_card");
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String ID_photo=location;

        String rate = null;
        if (autype.equals("sy")){
             rate="商业公司";
        }
        if (autype.equals("gt")){
             rate="个体工商户";
        }
        if (autype.equals("gr")){
             rate="个人经营";
        }
        if (autype.equals("zf")){
             rate="政府及非营利组织";
        }
        System.out.println(rate+"认证类型");
        System.out.println(name+"=="+phone_code+"=="+ID_card+"=="+email+"=="+location);
        /*获取用户输入验证码*/
        String emailyzm = request.getParameter("emailyzm");
        System.out.println(emailyzm);
        /*获取服务器存入session中的验证码*/
        String sessionKey = (String) request.getSession().getAttribute("SessionKey.SYS_YX");
        //获取用户的账号名称
        User user = (User) request.getSession().getAttribute("user");
        String account = user.getAccount();
        System.out.println(account+"用户账号");
        /*定义审核状态*/
        String audit="审核中";
        Approve approve=new Approve(account,name,ID_card,phone_code,ID_photo,email,rate,audit);
        System.out.println("对象"+approve);
        System.out.println(sessionKey);
        String audit1=null;
        if (emailyzm.equals(sessionKey)){
            approveService.addApprove(approve);
            Approve approve1 = approveService.findAppByAccount(account);
            audit1=approve1.getAudit();
        }

        model.addAttribute("audit",audit1);
        return "member";
    }

    @RequestMapping(value = "zhlx")
    @ResponseBody
    public String leixing(@RequestParam("action") String leixing, HttpServletRequest request, HttpSession session, Model model){
        System.out.println(leixing);
        autype=leixing;
        System.out.println(autype);
        return "success";
    }
    @RequestMapping(value = "sendyzm",method = RequestMethod.POST)
    @ResponseBody
    public String yxyz(HttpServletRequest request,@RequestParam(defaultValue ="a" ) String exam){
        String regEx1 ="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p=Pattern.compile(regEx1);
        Matcher m=p.matcher(exam);
        if (m.matches()){
            try {
                HtmlEmail htmlEmail=new HtmlEmail();
                htmlEmail.setHostName("smtp.163.com");
                htmlEmail.setCharset("utf-8");
                htmlEmail.addTo(exam);
                htmlEmail.setFrom("18209262612@163.com","众筹系统");
                htmlEmail.setAuthentication("18209262612@163.com","yzm123456");
                htmlEmail.setSubject("实名认证验证码");
                int a= (int) ((Math.random()*9+1)*100000);
                String aa=String.valueOf(a);
                HttpSession session=request.getSession();
                session.setAttribute("SessionKey.SYS_YX",aa);
                htmlEmail.setMsg("尊贵的会员：您的验证码为"+"<h3>"+aa+"</h3>");
                htmlEmail.send();
            }catch (Exception e){
                e.printStackTrace();

            }
         return "success";

        }else {
        return "false";
        }
    }
    /*跳转认证审核页面*/
    @RequestMapping(value = "/auth_cert")
    public String auth_cert(Model model){
        List<Approve> approves = approveService.findAll();
        model.addAttribute("approves",approves);
        return "auth_cert";
    }
    /*根据id获取认证的详情*/
    @RequestMapping(value = "/upapprove{id}")
    public String upapprove(@PathVariable("id") int id,Model model){
        System.out.println(id);
        Approve approve = approveService.findApproveById(id);
        model.addAttribute("approve",approve);
        return "upapprove";
    }
    /*修改认证的审核状态*/
    @RequestMapping(value = "/upappresult",method = RequestMethod.POST)
    public String upappresult(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Approve approve = approveService.findApproveById(id);
        approve.setAudit("已认证");
        /*根据id修改审核状态*/
        boolean b = approveService.upApproveById(approve);
        if (b){
            return "auth_cert";
        }
        return "upapprove";
    }
    /*处理删除用户提交的认证信息*/
    @RequestMapping(value = "deleteapp",method = RequestMethod.POST)
    @ResponseBody
    public String deleteUser(@RequestParam("action") int id,Model model){
        System.out.println("------"+id);
        boolean b = approveService.deleteApprove(id);
        if (b){
            return "success";
        }else {
            return "false";
        }

    }
}
