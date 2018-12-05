package cn.xt.service;

import cn.xt.dao.RoleUserMapper;
import cn.xt.domain.RoleUser;
import cn.xt.domain.RoleUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleuserService {
    @Autowired
    private RoleUserMapper roleUserMapper;



}
