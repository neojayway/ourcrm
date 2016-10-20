package org.zhiqiang.lzw.entity;

/**
 * 城市实体类
 * @author Administrator
 *
 */
public class City {
	
    private Integer id;//主键ID

    private String name;//城市名

    private String pycode;//城市拼音码

    private Integer pid;//对应省份ID

    private String postcode;//城市邮编

    private String areacode;//城市区号

    //构造方法(无参)
    public City() {
		super();
	}

	public City(Integer id, String name, String pycode, Integer pid,
			String postcode, String areacode) {
		super();
		this.id = id;
		this.name = name;
		this.pycode = pycode;
		this.pid = pid;
		this.postcode = postcode;
		this.areacode = areacode;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }
}