package org.zhiqiang.lzw.entity;

/**
 * 省份实体类
 * @author Administrator
 *
 */
public class Province {
	
	//主键ID
    private Integer id;

    //省份名称
    private String name;

    //省份拼音码
    private String pycode;

    public Province() {
		super();
	}

	public Province(Integer id, String name, String pycode) {
		super();
		this.id = id;
		this.name = name;
		this.pycode = pycode;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + ", pycode=" + pycode
				+ "]";
	}
    
}