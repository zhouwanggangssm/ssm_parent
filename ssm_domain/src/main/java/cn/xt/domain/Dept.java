package cn.xt.domain;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable{
    private String id;
    private String deptName;//部门名称
    private Dept parent; //子部门 自关联
    private Integer state;//状态 1代表启用 0停用

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
