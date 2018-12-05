package cn.xt.service;

import cn.xt.dao.UserMapper;
import cn.xt.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;


    public List<User> findUserPage(int currentPageNo, int pageSize) throws Exception {
        return userMapper.findUserPage(currentPageNo,pageSize);
    }


    public int getUserCount() throws Exception {
        return userMapper.getUserCount();
    }


    public User getUserById(String userId) throws Exception {
        return userMapper.getUserById(userId);
    }


    public List<User> getUpUserUI() throws Exception {
        return userMapper.getUpUserUI();
    }


    public List<UserInfo> getUpmanager() throws Exception {
        return userMapper.getUpmanager();
    }


    public int addUser(User user) throws Exception {
        return userMapper.addUser(user);
    }


    public int addUserInfo( UserInfo userInfo) throws Exception {
        return userMapper.addUserInfo(userInfo);
    }



    public int updateUser(User user) throws Exception {
        return userMapper.updateUser(user);
    }


    public int deleteUser(String userId) throws Exception {
        return userMapper.deleteUser(userId);
    }


    public int deleteUserList(List<String> userIds) throws Exception {
        return userMapper.deleteUserList(userIds);
    }


    public void deleteUserInfoById(String userId) throws Exception {
         userMapper.deleteUserInfoById(userId);
    }


    public void deleteUserInfoList(List<String> userIds) throws Exception {
         userMapper.deleteUserInfoList(userIds);
    }


    public void deleteUserRoleById(String userId) throws Exception {
         userMapper.deleteUserRoleById(userId);
    }


    public void deleteUserRoleByIdList(List<String> userIds) throws Exception {
         userMapper.deleteUserRoleByIdList(userIds);
    }

    public UserInfo findByIdUserInfo(String userId) throws Exception{
        return userMapper.findByIdUserInfo(userId);
    }

    public int addRoleUser(RoleUser roleUser) throws Exception{
        if(roleUser.getRoleId().indexOf(",")>0){
            List<String> list = Arrays.asList(roleUser.getRoleId().split(","));
            return userMapper.addRoleUser(list,roleUser.getUserId());
        }else{
            return userMapper.addRoleUser(Arrays.asList(roleUser.getRoleId()),roleUser.getUserId());
        }
    }

    public User Userlogin(String username,String password) throws Exception{
        return userMapper.Userlogin(username,password);
    }

    public List<User> UserExist(String username) throws Exception{
        return userMapper.UserExist(username);
    }



    public List<Role> findUserRoleusername(String username) throws  Exception{
        return userMapper.findUserRoleusername(username);
    }



    public List<Module> findRoleModulerolename(String rolename) throws Exception{
        return userMapper.findRoleModulerolename(rolename);
    }
}

