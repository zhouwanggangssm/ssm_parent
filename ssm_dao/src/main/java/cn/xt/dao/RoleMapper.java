package cn.xt.dao;

import cn.xt.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/***
 * 角色管理
 */
public interface RoleMapper {
    /***
     * 查询所有角色信息
     * @return
     * @throws Exception
     */
    List<Role> findRoleList() throws Exception;

    /***
     * 查询角色分页
     * @return
     * @throws Exception
     */
    List<Role> findRolePage() throws Exception;

    /***
     * 查询角色表的记录数
     * @return
     * @throws Exception
     */
    int RoleCount() throws Exception;

    /***
     * 按id查询角色
     * @param roelId
     * @return
     * @throws Exception
     */
    Role findRoleById(@Param("roleId") String roelId) throws  Exception;



    /***
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    int addRole(Role role) throws Exception;




    /***
     * 修改角色
     * @param role
     * @return
     * @throws Exception
     */
    int updateRole(Role role) throws Exception;



    /***
     * 删除单个角色   主键表
     * @param roleId
     * @return
     * @throws Exception
     */
    int deleteRole(@Param("roleId") String roleId) throws Exception;



    /***
     * 删除多个角色  主键表
     * @param roleIds
     * @return
     * @throws Exception
     */
    int deleteRoleList(@Param("roleIds") List<String> roleIds) throws Exception;


    /***
     * 添加用户的角色
     * @param roleUser
     * @return
     * @throws Exception
     */
    int addRoleUser(RoleUser roleUser) throws Exception;

    /***
     * 清空roleuser表下的相关roleId
     * @param roleId
     * @return
     * @throws Exception
     */
    void deleteRoleUserroleId(@Param("roleId") String roleId) throws Exception;

    /***
     * 清空rolemodule表下的相关roleId
     * @param roleId
     * @return
     * @throws Exception
     */
    void deleteRoleModuleroleId(@Param("roleId") String roleId) throws Exception;


    /***
     * 批量清空roleuser表下的相关roleId
     * @param roleIds
     * @return
     * @throws Exception
     */
    void deleteRoleUserroleIdList(@Param("roleIds") List<String> roleIds) throws Exception;


    /***
     * 批量清空rolemodule表下的相关roleId
     * @param roleIds
     * @return
     * @throws Exception
     */
    void deleteRoleModuleroleIdList(@Param("roleIds") List<String> roleIds) throws Exception;


    /***
     * 给角色添加权限模板
     * @param moduleIds
     * @param roleId
     * @return
     * @throws Exception
     */
    int addRoleModule(@Param("moduleIds") List<String> moduleIds,@Param("roleId") String roleId) throws Exception;






    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}