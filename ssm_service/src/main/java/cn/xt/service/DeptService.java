package cn.xt.service;

import cn.xt.dao.DeptMapper;
import cn.xt.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;

    public List<Dept> findDeptByPage(){
        List<Dept> page = deptMapper.findPage();
        for (Dept dept : page){
            System.out.println(dept.getDeptName()+"========================");
        }
        return page;
    }
}
