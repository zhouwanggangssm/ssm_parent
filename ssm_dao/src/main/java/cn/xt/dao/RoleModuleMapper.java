package cn.xt.dao;

import cn.xt.domain.RoleModule;
import cn.xt.domain.RoleModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleModuleMapper {

    /****
     * 查询角色所拥有的模块
     * @param roleId
     * @return
     * @throws Exception
     */
    List<RoleModule> findRoleModuleroleId(@Param("roleId") String roleId) throws Exception;



    long countByExample(RoleModuleExample example);

    int deleteByExample(RoleModuleExample example);

    int insert(RoleModule record);

    int insertSelective(RoleModule record);

    List<RoleModule> selectByExample(RoleModuleExample example);

    int updateByExampleSelective(@Param("record") RoleModule record, @Param("example") RoleModuleExample example);

    int updateByExample(@Param("record") RoleModule record, @Param("example") RoleModuleExample example);
}