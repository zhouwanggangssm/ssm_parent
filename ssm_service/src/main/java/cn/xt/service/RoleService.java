package cn.xt.service;

import cn.xt.dao.RoleMapper;
import cn.xt.domain.Module;
import cn.xt.domain.Role;
import cn.xt.domain.RoleModule;
import cn.xt.domain.RoleUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class RoleService{
    @Autowired
    private RoleMapper roleMapper;

    /***
     * 查询所有角色信息
     * @return
     * @throws Exception
     */
    public List<Role> findRoleList() throws Exception {
        return roleMapper.findRoleList();
    }
    /***
     * 查询角色分页
     * @return
     * @throws Exception
     */
    public List<Role> findRolePage() throws Exception{
        return roleMapper.findRolePage();
    }

    /***
     * 查询角色表的记录数
     * @return
     * @throws Exception
     */
    public int RoleCount() throws Exception{
        return roleMapper.RoleCount();
    }


    /***
     * 按id查询角色
     * @param roelId
     * @return
     * @throws Exception
     */
    public Role findRoleById(String roelId)  throws Exception{
        return roleMapper.findRoleById(roelId);
    }



    /***
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    public int addRole(Role role) throws Exception{
        return roleMapper.addRole(role);
    }




    /***
     * 修改角色
     * @param role
     * @return
     * @throws Exception
     */
    public int updateRole(Role role) throws Exception{
        return roleMapper.updateRole(role);
    }



    /***
     * 删除单个角色   主键表
     * @param roleId
     * @return
     * @throws Exception
     */
    public int deleteRole(String roleId) throws Exception{
        return roleMapper.deleteRole(roleId);
    }



    /***
     * 删除多个角色  主键表
     * @param roleIds
     * @return
     * @throws Exception
     */
    public int deleteRoleList(List<String> roleIds) throws Exception{
        return roleMapper.deleteRoleList(roleIds);
    }




    /***
     * 清空roleuser表下的相关roleId
     * @param roleId
     * @return
     * @throws Exception
     */
    public void deleteRoleUserroleId(String roleId) throws Exception{
         roleMapper.deleteRoleUserroleId(roleId);
    }


    /***
     * 清空rolemodule表下的相关roleId
     * @param roleId
     * @return
     * @throws Exception
     */
    public void deleteRoleModuleroleId(String roleId) throws Exception{
        roleMapper.deleteRoleModuleroleId(roleId);
    }


    /***
     * 批量清空roleuser表下的相关roleId
     * @param roleIds
     * @return
     * @throws Exception
     */
    public void deleteRoleUserroleIdList(List<String> roleIds) throws Exception{
        roleMapper.deleteRoleUserroleIdList(roleIds);
    }


    /***
     * 批量清空rolemodule表下的相关roleId
     * @param roleIds
     * @return
     * @throws Exception
     */
    public void deleteRoleModuleroleIdList(List<String> roleIds) throws Exception{
        roleMapper.deleteRoleModuleroleIdList(roleIds);
    }


    /***
     * 给角色添加权限模板
     * @param roleModule
     * @return
     * @throws Exception
     */
    public int addRoleModule(RoleModule roleModule) throws Exception{
        if(roleModule.getModuleId().indexOf(",")>0){
            List<String> list= Arrays.asList(roleModule.getModuleId().split(","));
            return roleMapper.addRoleModule(list,roleModule.getRoleId());
        }else {
            return roleMapper.addRoleModule(Arrays.asList(roleModule.getModuleId()),roleModule.getRoleId());
        }
    }

}


