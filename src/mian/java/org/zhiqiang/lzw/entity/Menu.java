package org.zhiqiang.lzw.entity;

public class Menu {
    private Integer menuid;

    private Byte menulevel;

    private Byte parentlevel;

    private String menuname;

    private Integer sort;

    private String title;

    private String url;

    private String target;

    private String icon;

    private String remark;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Byte getMenulevel() {
        return menulevel;
    }

    public void setMenulevel(Byte menulevel) {
        this.menulevel = menulevel;
    }

    public Byte getParentlevel() {
        return parentlevel;
    }

    public void setParentlevel(Byte parentlevel) {
        this.parentlevel = parentlevel;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}