package com.qf.lyx.mapper;

import com.qf.lyx.pojo.Approve;

import java.util.List;

/**
 * Created by Administrator on 2019/5/30 0030.
 */
public interface ApproveMapper {
    /*添加*/
    public void addApprove(Approve approve);
    /*查询所有审核的数据*/
    public List<Approve> findAll();
    /*根据id查询数据*/
    public Approve findApproveById(int id);
    /*根据id修改认证状态*/
    public boolean upApproveById(Approve approve);
    /*根据用户账号查询用户认证状态,或是否存在*/
    public Approve findAppByAccount(String account);
    /*根据id删除用户的认证信息*/
    public boolean deleteApprove(int id);
}
