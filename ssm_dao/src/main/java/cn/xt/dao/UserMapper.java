package cn.xt.dao;

import cn.xt.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/***
 * 用户管理
 */
public interface UserMapper {
    /***
     * 查询所有用户信息
     * @param currentPageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<User> findUserPage(@Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize) throws Exception;



    /***
     * 查询用户表总记录数
     * @return
     * @throws Exception
     */
    int getUserCount() throws Exception;



    /***
     * 查看单个用户信息
     * @param userId
     * @return
     * @throws Exception
     */
    User getUserById(@Param("userId") String userId) throws Exception;



    /***
     * 准备添加页面的角色信息
     * @return
     * @throws Exception
     */
    List<User> getUpUserUI() throws Exception;

    /***
     * 准备添加页面的直属领导
     * @return
     * @throws Exception
     */
    List<UserInfo> getUpmanager() throws Exception;

    /***
     * 添加用户
     * @param user
     * @return
     * @throws Exception
     */
    int addUser(User user) throws Exception;


    /***
     * 添加用户扩展表
     * @param userInfo
     * @return
     * @throws Exception
     */
    int addUserInfo(UserInfo userInfo) throws Exception;


    /***
     * 修改用户
     * @param user
     * @return
     * @throws Exception
     */
    int updateUser(User user) throws Exception;



    /***
     * 删除单个用户   主键表
     * @param userId
     * @return
     * @throws Exception
     */
    int deleteUser(@Param("userId") String userId) throws Exception;



    /***
     * 删除多个用户  主键表
     * @param userIds
     * @return
     * @throws Exception
     */
    int deleteUserList(@Param("userIds") List<String> userIds) throws Exception;


    /***
     * 删除单个用户扩展表关系信息   外键表
     * @param userId
     * @return
     * @throws Exception
     */
    void deleteUserInfoById(@Param("userId") String userId) throws Exception;

    /***
     * 删除多个用户扩展表关系信息   外键表
     * @param userIds
     * @return
     * @throws Exception
     *
     */
    void deleteUserInfoList(@Param("userIds") List<String> userIds) throws  Exception;

    /***
     * 删除单个用户对应的角色   外键表
     * @param userId
     * @return
     */
    void deleteUserRoleById(@Param("userId") String userId) throws Exception;

    /***
     * 删除单个用户对应的角色    外键表
     * @param userIds
     * @return
     */
    void deleteUserRoleByIdList(@Param("userIds") List<String> userIds) throws Exception;

    /***
     * 查询角色表的关联角色
     * @param userId
     * @return
     */
     Role findByIdRole(@Param("userId") String userId) throws Exception;

    /***
     * 查询用户扩展表的关联信息
     * @param userId
     * @return
     */
    UserInfo findByIdUserInfo(@Param("userId") String userId) throws Exception;

    /***
     * 给用户添加角色
     * @param roleIds
     * @param userId
     * @return
     * @throws Exception
     */
    int addRoleUser(@Param("roleIds") List<String> roleIds,@Param("userId") String userId) throws Exception;


    /***
     * 登录
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    User Userlogin(@Param("username") String username,@Param("password") String password) throws Exception;

    /***
     * 查询用户是否存在
     * @param username
     * @return
     * @throws Exception
     */
    List<User> UserExist(@Param("username") String username) throws Exception;


    /***
     * 查询用户拥有的角色
     * @param username
     * @return
     * @throws Exception
     */
    List<Role> findUserRoleusername(@Param("username") String username) throws  Exception;


    /***
     * 查询角色拥有的模块
     * @param rolename
     * @return
     * @throws Exception
     */
    List<Module> findRoleModulerolename(@Param("rolename") String rolename) throws Exception;




    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}