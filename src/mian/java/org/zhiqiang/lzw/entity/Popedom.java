package org.zhiqiang.lzw.entity;

public class Popedom extends PopedomKey {
    private Integer sort;

    private String title;

    private String popedomname;

    private String remark;

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

    public String getPopedomname() {
        return popedomname;
    }

    public void setPopedomname(String popedomname) {
        this.popedomname = popedomname == null ? null : popedomname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}