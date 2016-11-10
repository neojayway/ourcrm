package org.zhiqiang.lzw.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String creator;

    private String createtime;

    private String updater;

    private String updatetime;

    private String name;

    private String cnname;

    private String password;

    private String address;

    private String telephone;

    private String email;

    private Date begindate;

    private Date enddate;

    private Integer groupid;

    private String accessfilelevel;

    private String status;

    private String commendman;

    private String movetelephone;

    private String nowaddress;

    private String nowtelephone;

    private String identitycode;

    private String insurancecode;

    private String instancylinkman;

    private String instancytelephone;

    private String sex;

    private Date birthday;

    private String personneltype;

    private String duty;

    private Date workdate;

    private String highschool;

    private String finishschool;

    private Date finishschooldate;

    private String consortname;

    private String youngonename;

    private String officetelephone;

    private String consorttelephone;

    private String consortcompany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname == null ? null : cnname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getAccessfilelevel() {
        return accessfilelevel;
    }

    public void setAccessfilelevel(String accessfilelevel) {
        this.accessfilelevel = accessfilelevel == null ? null : accessfilelevel.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCommendman() {
        return commendman;
    }

    public void setCommendman(String commendman) {
        this.commendman = commendman == null ? null : commendman.trim();
    }

    public String getMovetelephone() {
        return movetelephone;
    }

    public void setMovetelephone(String movetelephone) {
        this.movetelephone = movetelephone == null ? null : movetelephone.trim();
    }

    public String getNowaddress() {
        return nowaddress;
    }

    public void setNowaddress(String nowaddress) {
        this.nowaddress = nowaddress == null ? null : nowaddress.trim();
    }

    public String getNowtelephone() {
        return nowtelephone;
    }

    public void setNowtelephone(String nowtelephone) {
        this.nowtelephone = nowtelephone == null ? null : nowtelephone.trim();
    }

    public String getIdentitycode() {
        return identitycode;
    }

    public void setIdentitycode(String identitycode) {
        this.identitycode = identitycode == null ? null : identitycode.trim();
    }

    public String getInsurancecode() {
        return insurancecode;
    }

    public void setInsurancecode(String insurancecode) {
        this.insurancecode = insurancecode == null ? null : insurancecode.trim();
    }

    public String getInstancylinkman() {
        return instancylinkman;
    }

    public void setInstancylinkman(String instancylinkman) {
        this.instancylinkman = instancylinkman == null ? null : instancylinkman.trim();
    }

    public String getInstancytelephone() {
        return instancytelephone;
    }

    public void setInstancytelephone(String instancytelephone) {
        this.instancytelephone = instancytelephone == null ? null : instancytelephone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPersonneltype() {
        return personneltype;
    }

    public void setPersonneltype(String personneltype) {
        this.personneltype = personneltype == null ? null : personneltype.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public String getHighschool() {
        return highschool;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool == null ? null : highschool.trim();
    }

    public String getFinishschool() {
        return finishschool;
    }

    public void setFinishschool(String finishschool) {
        this.finishschool = finishschool == null ? null : finishschool.trim();
    }

    public Date getFinishschooldate() {
        return finishschooldate;
    }

    public void setFinishschooldate(Date finishschooldate) {
        this.finishschooldate = finishschooldate;
    }

    public String getConsortname() {
        return consortname;
    }

    public void setConsortname(String consortname) {
        this.consortname = consortname == null ? null : consortname.trim();
    }

    public String getYoungonename() {
        return youngonename;
    }

    public void setYoungonename(String youngonename) {
        this.youngonename = youngonename == null ? null : youngonename.trim();
    }

    public String getOfficetelephone() {
        return officetelephone;
    }

    public void setOfficetelephone(String officetelephone) {
        this.officetelephone = officetelephone == null ? null : officetelephone.trim();
    }

    public String getConsorttelephone() {
        return consorttelephone;
    }

    public void setConsorttelephone(String consorttelephone) {
        this.consorttelephone = consorttelephone == null ? null : consorttelephone.trim();
    }

    public String getConsortcompany() {
        return consortcompany;
    }

    public void setConsortcompany(String consortcompany) {
        this.consortcompany = consortcompany == null ? null : consortcompany.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", creator=" + creator + ", createtime="
				+ createtime + ", updater=" + updater + ", updatetime="
				+ updatetime + ", name=" + name + ", cnname=" + cnname
				+ ", password=" + password + ", address=" + address
				+ ", telephone=" + telephone + ", email=" + email
				+ ", begindate=" + begindate + ", enddate=" + enddate
				+ ", groupid=" + groupid + ", accessfilelevel="
				+ accessfilelevel + ", status=" + status + ", commendman="
				+ commendman + ", movetelephone=" + movetelephone
				+ ", nowaddress=" + nowaddress + ", nowtelephone="
				+ nowtelephone + ", identitycode=" + identitycode
				+ ", insurancecode=" + insurancecode + ", instancylinkman="
				+ instancylinkman + ", instancytelephone=" + instancytelephone
				+ ", sex=" + sex + ", birthday=" + birthday
				+ ", personneltype=" + personneltype + ", duty=" + duty
				+ ", workdate=" + workdate + ", highschool=" + highschool
				+ ", finishschool=" + finishschool + ", finishschooldate="
				+ finishschooldate + ", consortname=" + consortname
				+ ", youngonename=" + youngonename + ", officetelephone="
				+ officetelephone + ", consorttelephone=" + consorttelephone
				+ ", consortcompany=" + consortcompany + "]";
	}
    
    
}