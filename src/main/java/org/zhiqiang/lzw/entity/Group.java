package org.zhiqiang.lzw.entity;

public class Group {
    private Integer groupid;

    private String groupname;

    private String remark;

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Group [groupid=" + groupid + ", groupname=" + groupname
				+ ", remark=" + remark + "]";
	}
    
}