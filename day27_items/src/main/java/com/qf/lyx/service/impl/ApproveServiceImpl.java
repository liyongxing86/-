package com.qf.lyx.service.impl;

import com.qf.lyx.mapper.ApproveMapper;
import com.qf.lyx.pojo.Approve;
import com.qf.lyx.service.ApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/30 0030.
 */
@Service
public class ApproveServiceImpl implements ApproveService{
    @Autowired
    ApproveMapper approveMapper;
    @Override
    public void addApprove(Approve approve) {
        approveMapper.addApprove(approve);
    }

    @Override
    public List<Approve> findAll() {
        List<Approve> all = approveMapper.findAll();
        return all;
    }

    @Override
    public Approve findApproveById(int id) {
        Approve approve = approveMapper.findApproveById(id);
        return approve;
    }

    @Override
    public boolean upApproveById(Approve approve) {
        boolean b = approveMapper.upApproveById(approve);
        return b;
    }

    @Override
    public Approve findAppByAccount(String account) {
        Approve approve = approveMapper.findAppByAccount(account);
        return approve;
    }

    @Override
    public boolean deleteApprove(int id) {
        boolean b = approveMapper.deleteApprove(id);
        return b;
    }
}
