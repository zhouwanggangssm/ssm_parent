package cn.xt.service;

import cn.xt.dao.RoleModuleMapper;
import cn.xt.domain.RoleModule;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleModuleService {
     @Autowired
     private RoleModuleMapper roleModuleMapper;


    /****
     * 查询角色所拥有的模块
     * @param roleId
     * @return
     * @throws Exception
     */
    public List<RoleModule> findRoleModuleroleId(String roleId) throws Exception{
        return roleModuleMapper.findRoleModuleroleId(roleId);
    }
}
