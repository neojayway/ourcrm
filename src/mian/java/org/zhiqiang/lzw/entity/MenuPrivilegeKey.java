package org.zhiqiang.lzw.entity;

public class MenuPrivilegeKey {
    private String roleid;

    private String menumodule;

    private String menuprivilege;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getMenumodule() {
        return menumodule;
    }

    public void setMenumodule(String menumodule) {
        this.menumodule = menumodule == null ? null : menumodule.trim();
    }

    public String getMenuprivilege() {
        return menuprivilege;
    }

    public void setMenuprivilege(String menuprivilege) {
        this.menuprivilege = menuprivilege == null ? null : menuprivilege.trim();
    }
}