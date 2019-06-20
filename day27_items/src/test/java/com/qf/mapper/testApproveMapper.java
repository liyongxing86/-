package com.qf.mapper;

import com.qf.lyx.mapper.ApproveMapper;
import com.qf.lyx.mapper.UserMapper;
import com.qf.lyx.pojo.Approve;
import org.ietf.jgss.Oid;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2019/5/30 0030.
 */
public class testApproveMapper {
    @Test
    public void addApprove(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ApproveMapper approveMapper = ac.getBean(ApproveMapper.class);
        Approve approve=new Approve();
        approve.setAccount("郭琦");
        approve.setName("骚气");
        approve.setID_card("12345678");
        approve.setPhone_code("3214142141");
        approve.setID_photo("dsadsavdhvjh");
        approve.setEmail("asbhao@qq.com");
        approve.setRate("个人");
        approve.setAudit("待审核");
        approveMapper.addApprove(approve);
    }
    @Test
    public void findAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ApproveMapper approveMapper = ac.getBean(ApproveMapper.class);
        List<Approve> list = approveMapper.findAll();
        for (Approve approve:list){
            System.out.println(approve);
        }
    }
    @Test
    public void findApproveById(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ApproveMapper approveMapper = ac.getBean(ApproveMapper.class);
        Approve approve = approveMapper.findApproveById(1);
        System.out.println(approve);
    }
    @Test
    public void findAppByAccount(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ApproveMapper approveMapper = ac.getBean(ApproveMapper.class);
        Approve uu = approveMapper.findAppByAccount("uu");
        System.out.println(uu);
    }
}
