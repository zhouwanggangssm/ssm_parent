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
 * 部门管理业务层
 */
@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;


    /***
     * 查询所有部门信息
     * @param
     * @param
     * @return
     * @throws Exception
     */
    public List<Dept> findPage() throws  Exception{

        return deptMapper.findPage();
    }

    /***
     * 查询部门表总记录数
     * @return
     * @throws Exception
     */
    public int getDeptCount() throws  Exception{

        return deptMapper.getDeptCount();
    }


    /***
     * 查看单个部门信息
     * @param deptId
     * @return
     * @throws Exception
     */
    public Dept getDeptById(String deptId) throws  Exception{

        return deptMapper.getDeptById(deptId);
    }

    /***
     * 准备添加页面的上级部门
     * @return
     * @throws Exception
     */
    public List<Dept> getUpDept() throws  Exception{
        return deptMapper.getUpDept();
    }

    /***
     * 添加部门
     * @param dept
     * @return
     * @throws Exception
     */
    public int addDept(Dept dept) throws  Exception{
        return deptMapper.addDept(dept);
    }

    /***
     * 修改部门
     * @param dept
     * @return
     * @throws Exception
     */
    public int updateDept(Dept dept) throws  Exception{
        return deptMapper.updateDept(dept);
    }

    /***
     * 删除单个部门
     * @param deptId
     * @return
     * @throws Exception
     */
    public int deleteDept(String deptId) throws  Exception{
        return deptMapper.deleteDept(deptId);
    }

    /***
     * 删除多个部门
     * @param deptIds
     * @return
     * @throws Exception
     */
    public int deleteDeptList(List<String> deptIds) throws  Exception{
        return deptMapper.deleteDeptList(deptIds);
    }


    /***
     * 修改单个用户表的部门id为null
     * @param deptId
     * @return
     * @throws Exception
     */
    public void updateUserDeptId(String deptId) throws Exception {
         deptMapper.updateUserDeptId(deptId);
    }

    /***
     * 修改多个用户表的部门id为null
     * @param deptIds
     * @return
     * @throws Exception
     */
    public void updateUserDeptIdList(List<String> deptIds) throws  Exception{
        deptMapper.updateUserDeptIdList(deptIds);
    }

}
