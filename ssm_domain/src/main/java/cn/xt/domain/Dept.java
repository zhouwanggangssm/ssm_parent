package cn.xt.domain;

import java.util.HashSet;
import java.util.Set;

public class Dept {
    private String deptId;//部门id
    private Set<User> users=new HashSet<User>(0);//一个部门对应多个用户

    private String deptName;//部门名称

    private Dept parentId;//上级部门id  自关联

    private Integer state;//状态

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Dept getParentId() {
        return parentId;
    }

    public void setParentId(Dept parentId) {
        this.parentId = parentId ;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}