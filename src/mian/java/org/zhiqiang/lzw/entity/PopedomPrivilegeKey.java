package org.zhiqiang.lzw.entity;

public class PopedomPrivilegeKey {
    private String roleid;

    private String popedommodule;

    private String popedomprivilege;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getPopedommodule() {
        return popedommodule;
    }

    public void setPopedommodule(String popedommodule) {
        this.popedommodule = popedommodule == null ? null : popedommodule.trim();
    }

    public String getPopedomprivilege() {
        return popedomprivilege;
    }

    public void setPopedomprivilege(String popedomprivilege) {
        this.popedomprivilege = popedomprivilege == null ? null : popedomprivilege.trim();
    }
}