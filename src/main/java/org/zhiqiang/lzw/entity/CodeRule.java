package org.zhiqiang.lzw.entity;

/**
 * 编码规则实体类
 * @author Administrator
 *
 */
public class CodeRule {
	
	//主键ID
    private Integer id;

    //模块名称
    private String module;

    //生成的编码的前缀
    private String areaprefix;

    //生成的编码的日期位
    private String areatime;

    //流水号
    private Integer glidebit;

    //提供预览的编码
    private String currentcode;

    //对应数据表名
    private String tabname;

    //是否有效
    private String available;

    //下一次产生的序号
    private String nextseq;

    //序号对应的日期
    private String curdate;

    public CodeRule() {
		super();
	}

	public CodeRule(Integer id, String module, String areaprefix,
			String areatime, Integer glidebit, String currentcode,
			String tabname, String available, String nextseq, String curdate) {
		super();
		this.id = id;
		this.module = module;
		this.areaprefix = areaprefix;
		this.areatime = areatime;
		this.glidebit = glidebit;
		this.currentcode = currentcode;
		this.tabname = tabname;
		this.available = available;
		this.nextseq = nextseq;
		this.curdate = curdate;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getAreaprefix() {
        return areaprefix;
    }

    public void setAreaprefix(String areaprefix) {
        this.areaprefix = areaprefix == null ? null : areaprefix.trim();
    }

    public String getAreatime() {
        return areatime;
    }

    public void setAreatime(String areatime) {
        this.areatime = areatime == null ? null : areatime.trim();
    }

    public Integer getGlidebit() {
        return glidebit;
    }

    public void setGlidebit(Integer glidebit) {
        this.glidebit = glidebit;
    }

    public String getCurrentcode() {
        return currentcode;
    }

    public void setCurrentcode(String currentcode) {
        this.currentcode = currentcode == null ? null : currentcode.trim();
    }

    public String getTabname() {
        return tabname;
    }

    public void setTabname(String tabname) {
        this.tabname = tabname == null ? null : tabname.trim();
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }

    public String getNextseq() {
        return nextseq;
    }

    public void setNextseq(String nextseq) {
        this.nextseq = nextseq == null ? null : nextseq.trim();
    }

    public String getCurdate() {
        return curdate;
    }

    public void setCurdate(String curdate) {
        this.curdate = curdate == null ? null : curdate.trim();
    }

	@Override
	public String toString() {
		return "CodeRule [id=" + id + ", module=" + module + ", areaprefix="
				+ areaprefix + ", areatime=" + areatime + ", glidebit="
				+ glidebit + ", currentcode=" + currentcode + ", tabname="
				+ tabname + ", available=" + available + ", nextseq=" + nextseq
				+ ", curdate=" + curdate + "]";
	}
    
    
}