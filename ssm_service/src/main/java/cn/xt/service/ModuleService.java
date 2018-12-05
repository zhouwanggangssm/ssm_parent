package cn.xt.service;

import cn.xt.dao.ModuleMapper;
import cn.xt.domain.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    @Autowired
    private ModuleMapper moduleMapper;

    /***
     * 查询rolemodule表
     * @return
     * @throws Exception
     */
    public List<Module> findModule() throws Exception{
        return moduleMapper.findModule();
    }


    /***
     * 查询module表的记录数
     * @return
     * @throws Exception
     */
    public int CountModule() throws Exception{
        return moduleMapper.CountModule();
    }


    /***
     * 按id查询模板
     * @param moduleId
     * @return
     * @throws Exception
     */
    public Module findModuleById(String moduleId) throws  Exception{
        return moduleMapper.findModuleById(moduleId);
    }



    /***
     * 添加模板
     * @param module
     * @return
     * @throws Exception
     */
    public int addModule(Module module) throws Exception{
        if(module.getParentName().equals("部门管理")||module.getParentName().equals("用户管理")||
           module.getParentName().equals("角色管理")||module.getParentName().equals("模块管理"))
        {
            module.setParentId("2");
        }
        return moduleMapper.addModule(module);
    }




    /***
     * 修改模板
     * @param module
     * @return
     * @throws Exception
     */
    public int updateModule(Module module) throws Exception{
        return moduleMapper.updateModule(module);
    }



    /***
     * 删除单个模板   主键表
     * @param moduleId
     * @return
     * @throws Exception
     */
    public int deleteModule(String moduleId) throws Exception{
        return moduleMapper.deleteModule(moduleId);
    }



    /***
     * 删除多个模板  主键表
     * @param moduleIds
     * @return
     * @throws Exception
     */
    public int deleteModuleList(List<String> moduleIds) throws Exception{
        return moduleMapper.deleteModuleList(moduleIds);
    }

    /***
     * 删除单个rolemodule的关联信息
     * @param moduleId
     * @throws Exception
     */
    public void deleteRoleModuleId(String moduleId) throws Exception{
        moduleMapper.deleteRoleModuleId(moduleId);
    }


    /***
     * 删除多个rolemodule的关联信息
     * @param moduleIds
     * @throws Exception
     */
    public void deleteRoleModuleList(List<String> moduleIds) throws Exception{
        moduleMapper.deleteRoleModuleList(moduleIds);
    }
}
