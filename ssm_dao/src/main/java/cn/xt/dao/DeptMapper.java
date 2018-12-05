package cn.xt.dao;

import cn.xt.domain.Dept;
import cn.xt.domain.DeptExample;
import cn.xt.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * 部门管理
 */
public interface DeptMapper {

    /***
     * 查询所有部门信息
     * @param
     * @param
     * @return
     * @throws Exception
     */
    List<Dept> findPage() throws  Exception;



    /***
     * 查询部门表总记录数
     * @return
     * @throws Exception
     */
    int getDeptCount() throws Exception;



    /***
     * 查看单个部门信息
     * @param deptId
     * @return
     * @throws Exception
     */
    Dept getDeptById(@Param("deptId") String deptId) throws Exception;



    /***
     * 准备添加页面的上级部门
     * @return
     * @throws Exception
     */
    List<Dept> getUpDept() throws Exception;



    /***
     * 添加部门
     * @param dept
     * @return
     * @throws Exception
     */
    int addDept(Dept dept) throws Exception;



    /***
     * 修改部门
     * @param dept
     * @return
     * @throws Exception
     */
    int updateDept(Dept dept) throws Exception;



    /***
     * 删除单个部门
     * @param deptId
     * @return
     * @throws Exception
     */
    int deleteDept(@Param("deptId") String deptId) throws Exception;



    /***
     * 删除多个部门
     * @param deptIds
     * @return
     * @throws Exception
     */
    int deleteDeptList(@Param("deptIds") List<String> deptIds) throws Exception;



    /***
     * 修改单个用户表的部门id为null
     * @param deptId
     * @return
     * @throws Exception
     */
    void updateUserDeptId(@Param("deptId") String deptId) throws  Exception;

    /***
     * 修改多个用户表的部门id为null
     * @param deptIds
     * @return
     * @throws Exception
     */
    void updateUserDeptIdList(@Param("deptIds") List<String> deptIds) throws  Exception;


//    //查询表的记录数  按条件查询表的记录数
//    int countByExample(DeptExample example);
//    //按条件删除
//    int deleteByExample(DeptExample example);
//    //按主键删除
//    int deleteByPrimaryKey(String deptId);
//    //保存
//    int insert(Dept record);
//
//    int insertSelective(Dept record);
//    //按条件查询
//    List<Dept> selectByExample(DeptExample example);
//    //按主键查询
//    Dept selectByPrimaryKey(String deptId);
//
//    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);
//    //按条件更新     xxxExample:封装查询条件的
//    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);
//
//    int updateByPrimaryKeySelective(Dept record);
//    //按主键更新
//    int updateByPrimaryKey(Dept record);
}
