package cn.xt.service;

import cn.xt.dao.DeptMapper;
import cn.xt.domain.Dept;
import cn.xt.domain.DeptExample;
import cn.xt.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄德乐
 * @version 部门管理
 */
@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;



    public List<Dept> findPage() throws  Exception{

        return deptMapper.findPage();
    }


    public int getDeptCount() throws  Exception{

        return deptMapper.getDeptCount();
    }


    public Dept getDeptById(String deptId) throws  Exception{

        return deptMapper.getDeptById(deptId);
    }


    public List<Dept> getUpDept() throws  Exception{
        return deptMapper.getUpDept();
    }


    public int addDept(Dept dept) throws  Exception{
        return deptMapper.addDept(dept);
    }


    public int updateDept(Dept dept) throws  Exception{
        return deptMapper.updateDept(dept);
    }


    public int deleteDept(String deptId) throws  Exception{
        return deptMapper.deleteDept(deptId);
    }


    public int deleteDeptList(List<String> deptIds) throws  Exception{
        return deptMapper.deleteDeptList(deptIds);
    }



    public void updateUserDeptId(String deptId) throws Exception {
         deptMapper.updateUserDeptId(deptId);
    }

    public void updateUserDeptIdList(List<String> deptIds) throws  Exception{
        deptMapper.updateUserDeptIdList(deptIds);
    }

}
