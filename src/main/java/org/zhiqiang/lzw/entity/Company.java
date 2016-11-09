package org.zhiqiang.lzw.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 客户实体类
 * @author Administrator
 *
 */
public class Company {
	
	//客户编号
    private Integer id;

    //客户编码
    private String code;

    //客户名称
    private String name;

    //客户名称拼音
    private String pycode;

    //客户等级
    private String grade;

    //区域名称
    private String regionname;

    //客户的来源
    private String source;

    //客户所属行业
    private String trade;

    //客户公司规模
    private String scale;

    //所在省份
    private String province;

    //所在城市
    private String city;

    //邮编
    private String postcode;

    //详细地址
    private String address;

    //邮箱
    private String email;

    //网站
    private String web;

    //电话
    private String tel1;

    //传真
    private String fax;

    //手机
    private String mobile;

    //第二电话
    private String tel2;

    //下次的联系时间
    private Date nexttouchdate;

    //客户性质
    private String quality;

    //经营范围
    private String dealin;

    //企业性质
    private String kind;

    //法人代表
    private String artificialperson;

    //注册资金
    private String registemoney;

    //开户银行
    private String bank;

    //银行账号
    private String account;

    //公司税号
    private String taxcode;

    //创建人
    private String creater;

    //创建时间
    private String createtime;

    //修改人
    private String updater;

    //修改时间
    private String updatetime;

    //所属人编号
    private Integer owneruser;

    //所属人名称
    private String dispenseperson;

    //分配日期
    private String dispensedate;

    //是否共享
    private String shareflag;

    //共享ID
    private String shareids;

    //备注
    private String remark;

    public Company() {
		super();
	}

	public Company(Integer id, String code, String name, String pycode,
			String grade, String regionname, String source, String trade,
			String scale, String province, String city, String postcode,
			String address, String email, String web, String tel1, String fax,
			String mobile, String tel2, Date nexttouchdate, String quality,
			String dealin, String kind, String artificialperson,
			String registemoney, String bank, String account, String taxcode,
			String creater, String createtime, String updater,
			String updatetime, Integer owneruser, String dispenseperson,
			String dispensedate, String shareflag, String shareids,
			String remark) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.pycode = pycode;
		this.grade = grade;
		this.regionname = regionname;
		this.source = source;
		this.trade = trade;
		this.scale = scale;
		this.province = province;
		this.city = city;
		this.postcode = postcode;
		this.address = address;
		this.email = email;
		this.web = web;
		this.tel1 = tel1;
		this.fax = fax;
		this.mobile = mobile;
		this.tel2 = tel2;
		this.nexttouchdate = nexttouchdate;
		this.quality = quality;
		this.dealin = dealin;
		this.kind = kind;
		this.artificialperson = artificialperson;
		this.registemoney = registemoney;
		this.bank = bank;
		this.account = account;
		this.taxcode = taxcode;
		this.creater = creater;
		this.createtime = createtime;
		this.updater = updater;
		this.updatetime = updatetime;
		this.owneruser = owneruser;
		this.dispenseperson = dispenseperson;
		this.dispensedate = dispensedate;
		this.shareflag = shareflag;
		this.shareids = shareids;
		this.remark = remark;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPycode() {
        return pycode;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode == null ? null : pycode.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade == null ? null : trade.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1 == null ? null : tel1.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2 == null ? null : tel2.trim();
    }

    //配置日期的传递方式。
    @DateTimeFormat(pattern="yyyy-MM-dd")  
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
    public Date getNexttouchdate() {
        return nexttouchdate;
    }

    public void setNexttouchdate(Date nexttouchdate) {
        this.nexttouchdate = nexttouchdate;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public String getDealin() {
        return dealin;
    }

    public void setDealin(String dealin) {
        this.dealin = dealin == null ? null : dealin.trim();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public String getArtificialperson() {
        return artificialperson;
    }

    public void setArtificialperson(String artificialperson) {
        this.artificialperson = artificialperson == null ? null : artificialperson.trim();
    }

    public String getRegistemoney() {
        return registemoney;
    }

    public void setRegistemoney(String registemoney) {
        this.registemoney = registemoney == null ? null : registemoney.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode == null ? null : taxcode.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
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

    public Integer getOwneruser() {
        return owneruser;
    }

    public void setOwneruser(Integer owneruser) {
        this.owneruser = owneruser;
    }

    public String getDispenseperson() {
        return dispenseperson;
    }

    public void setDispenseperson(String dispenseperson) {
        this.dispenseperson = dispenseperson == null ? null : dispenseperson.trim();
    }

    public String getDispensedate() {
        return dispensedate;
    }

    public void setDispensedate(String dispensedate) {
        this.dispensedate = dispensedate == null ? null : dispensedate.trim();
    }

    public String getShareflag() {
        return shareflag;
    }

    public void setShareflag(String shareflag) {
        this.shareflag = shareflag == null ? null : shareflag.trim();
    }

    public String getShareids() {
        return shareids;
    }

    public void setShareids(String shareids) {
        this.shareids = shareids == null ? null : shareids.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Company [id=" + id + ", code=" + code + ", name=" + name
				+ ", pycode=" + pycode + ", grade=" + grade + ", regionname="
				+ regionname + ", source=" + source + ", trade=" + trade
				+ ", scale=" + scale + ", province=" + province + ", city="
				+ city + ", postcode=" + postcode + ", address=" + address
				+ ", email=" + email + ", web=" + web + ", tel1=" + tel1
				+ ", fax=" + fax + ", mobile=" + mobile + ", tel2=" + tel2
				+ ", nexttouchdate=" + nexttouchdate + ", quality=" + quality
				+ ", dealin=" + dealin + ", kind=" + kind
				+ ", artificialperson=" + artificialperson + ", registemoney="
				+ registemoney + ", bank=" + bank + ", account=" + account
				+ ", taxcode=" + taxcode + ", creater=" + creater
				+ ", createtime=" + createtime + ", updater=" + updater
				+ ", updatetime=" + updatetime + ", owneruser=" + owneruser
				+ ", dispenseperson=" + dispenseperson + ", dispensedate="
				+ dispensedate + ", shareflag=" + shareflag + ", shareids="
				+ shareids + ", remark=" + remark + "]";
	}
    
    
}