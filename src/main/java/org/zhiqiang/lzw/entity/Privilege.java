package org.zhiqiang.lzw.entity;

public class Privilege {
    private Integer privilegeid;

    private String privilegename;

    private String privilegeurl;

    private Long privilegecode;

    private Integer privilegepos;

    private Boolean privalegecomm;

    private String menuid;

    public Integer getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(Integer privilegeid) {
        this.privilegeid = privilegeid;
    }

    public String getPrivilegename() {
        return privilegename;
    }

    public void setPrivilegename(String privilegename) {
        this.privilegename = privilegename == null ? null : privilegename.trim();
    }

    public String getPrivilegeurl() {
        return privilegeurl;
    }

    public void setPrivilegeurl(String privilegeurl) {
        this.privilegeurl = privilegeurl == null ? null : privilegeurl.trim();
    }

    public Long getPrivilegecode() {
        return privilegecode;
    }

    public void setPrivilegecode(Long privilegecode) {
        this.privilegecode = privilegecode;
    }

    public Integer getPrivilegepos() {
        return privilegepos;
    }

    public void setPrivilegepos(Integer privilegepos) {
        this.privilegepos = privilegepos;
    }

    public Boolean getPrivalegecomm() {
        return privalegecomm;
    }

    public void setPrivalegecomm(Boolean privalegecomm) {
        this.privalegecomm = privalegecomm;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

	@Override
	public String toString() {
		return "Privilege [privilegeid=" + privilegeid + ", privilegename="
				+ privilegename + ", privilegeurl=" + privilegeurl
				+ ", privilegecode=" + privilegecode + ", privilegepos="
				+ privilegepos + ", privalegecomm=" + privalegecomm
				+ ", menuid=" + menuid + "]";
	}
    
    
}