package cn.xt.dao;

import cn.xt.domain.Dept;

import java.util.List;

public interface DeptMapper {
    public List<Dept> findPage();
}
