package org.zhiqiang.lzw.entity;

public class PopedomKey {
    private String popedommodule;

    private String popedomprivilege;

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