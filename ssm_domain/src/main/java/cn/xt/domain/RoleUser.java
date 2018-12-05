package cn.xt.domain;


public class RoleUser {
    private String roleId;

    private String userId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }


    @Override
    public String toString() {
        return "RoleUser{" +
                "roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}