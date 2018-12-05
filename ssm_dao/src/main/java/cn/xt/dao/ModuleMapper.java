package cn.xt.dao;

import cn.xt.domain.Module;
import cn.xt.domain.ModuleExample;
import java.util.List;

import cn.xt.domain.Role;
import org.apache.ibatis.annotations.Param;

public interface ModuleMapper {
    /***
     * 查询所有模板
     * @return
     * @throws Exception
     */
    List<Module> findModule() throws Exception;


    /***
     * 查询module表的记录数
     * @return
     * @throws Exception
     */
    int CountModule() throws Exception;


    /***
     * 按id查询模板
     * @param moduleId
     * @return
     * @throws Exception
     */
    Module findModuleById(@Param("moduleId") String moduleId) throws  Exception;



    /***
     * 添加模板
     * @param module
     * @return
     * @throws Exception
     */
    int addModule(Module module) throws Exception;




    /***
     * 修改模板
     * @param module
     * @return
     * @throws Exception
     */
    int updateModule(Module module) throws Exception;



    /***
     * 删除单个模板   主键表
     * @param moduleId
     * @return
     * @throws Exception
     */
    int deleteModule(@Param("moduleId") String moduleId) throws Exception;



    /***
     * 删除多个模板  主键表
     * @param moduleIds
     * @return
     * @throws Exception
     */
    int deleteModuleList(@Param("moduleIds") List<String> moduleIds) throws Exception;

    /***
     * 删除单个rolemodule的关联信息
     * @param moduleId
     * @throws Exception
     */
    void deleteRoleModuleId(@Param("moduleId") String moduleId) throws Exception;


    /***
     * 删除多个rolemodule的关联信息
     * @param moduleIds
     * @throws Exception
     */
    void deleteRoleModuleList(@Param("moduleIds") List<String> moduleIds) throws Exception;




    long countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(String moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(String moduleId);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}