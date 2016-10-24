package org.zhiqiang.lzw.entity;

/**
 * 日志实体
 * @author LZW
 *
 */
public class Log {
    private Integer id;				//编号

    private String username;		//登录用户的名称

    private String cnname;			//登录用户的中文名称

    private String actiontype;		//操作类型

    private String actiondate;		//操作的日期

    private String actioncontent;	//操作的内容（json格式的字符串）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname == null ? null : cnname.trim();
    }

    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype == null ? null : actiontype.trim();
    }

    public String getActiondate() {
        return actiondate;
    }

    public void setActiondate(String actiondate) {
        this.actiondate = actiondate == null ? null : actiondate.trim();
    }

    public String getActioncontent() {
        return actioncontent;
    }

    public void setActioncontent(String actioncontent) {
        this.actioncontent = actioncontent == null ? null : actioncontent.trim();
    }
}