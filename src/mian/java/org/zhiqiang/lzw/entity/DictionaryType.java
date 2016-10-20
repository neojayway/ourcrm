package org.zhiqiang.lzw.entity;

/**
 * 字典类型的实体类
 * @author Administrator
 *
 */
public class DictionaryType {
	
	//主键ID
    private Integer id;

    //用来排序的序号
    private Integer sort;

    //用来区分各个类型的标识
    private String code;

    //字典类型的细节值
    private String value;

    //是否有效
    private String sysflag;

    //备注
    private String remark;
    
    public DictionaryType() {
		super();
	}

	public DictionaryType(Integer id, Integer sort, String code, String value,
			String sysflag, String remark) {
		super();
		this.id = id;
		this.sort = sort;
		this.code = code;
		this.value = value;
		this.sysflag = sysflag;
		this.remark = remark;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getSysflag() {
        return sysflag;
    }

    public void setSysflag(String sysflag) {
        this.sysflag = sysflag == null ? null : sysflag.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}