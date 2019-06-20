package com.qf.lyx.controller;

import com.qf.lyx.pojo.User;
import com.qf.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/5/27 0027.
 */
@Controller
@SessionAttributes("user")

public class UserCntroller {
    @Autowired
    private UserService userService;
    /*处理查询的请求*/
    @RequestMapping(value = "/user")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "user";
    }
    /*处理根据id查询信息的请求*/
    @RequestMapping(value = "/edit{id}")
    public String upUser(@PathVariable("id") int id, Model model, HttpSession session,HttpServletRequest request,HttpServletResponse response){
        User user = userService.findUserById(id);
        HttpSession session1 = request.getSession();
        session.setAttribute("id",id);
        model.addAttribute("id",id);
        model.addAttribute("user",user);
        return "edit";
    }
    /*处理删除的请求*/
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public String deleteUser(@RequestParam("action") int id,Model model){
        System.out.println("------"+id);
        userService.delUser(id);
        return "success";
    }
    /*处理修改的请求*/
    @RequestMapping(value = "/upUser",method = RequestMethod.POST)
    public String upUser(HttpServletRequest request,HttpServletResponse response){
        String account=request.getParameter("account");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        int id = (Integer) request.getSession().getAttribute("id");
        System.out.println(account+"----");
        System.out.println(name);
        System.out.println(email);
        System.out.println(id);
        User userById = userService.findUserById(id);
        String pw = userById.getPw();
        System.out.println(pw);
        String rank = userById.getRank();
        System.out.println(rank+"----");
        User user=new User(id,account,name,pw,email,rank);
        userService.upUser(user);
        return "user";
    }
	// 我爱小伟   ╰(￣ω￣ｏ)  小伟 我爱你     爱你一万年
    /*处理添加的请求*/
    @RequestMapping(value = "/add")
    public String add(){
        return "add";
    }
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String adduser(HttpServletRequest request,HttpServletResponse response){
        String name=request.getParameter("name");
        String account=request.getParameter("account");
        String email=request.getParameter("email");
        String upw="000000";
        String rank="会员";
        System.out.println(name+"--33--"+account+"-33--"+email+"--33-"+upw);
        User user=new User(account,name,upw,email,rank);
        //根据账号查询用户是否存在
        User userByName = userService.findUserByName(account);
        if (userByName==null){//不存在，可以添加
            userService.addUser(user);
            return "user";
        }
        return "add";
    }
    /*模糊查询*/
    @RequestMapping(value = "/likeuser",method = RequestMethod.POST)
    public String likeuser(HttpServletRequest request,HttpServletResponse response,Model model){
        String account=request.getParameter("account");
        List<User> userLike = userService.findUserLike(account);
        model.addAttribute("users",userLike);
        return "user";

    }
}
