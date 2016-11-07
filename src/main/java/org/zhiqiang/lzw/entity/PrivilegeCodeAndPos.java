package org.zhiqiang.lzw.entity;

/**
 * 保存当前最大的权限位以及最大权限位对应的最大的权限码
 * @author LZW
 *
 */
public class PrivilegeCodeAndPos {
	private Integer pos;
	private Long code;
	public Integer getPos() {
		return pos;
	}
	public void setPos(Integer pos) {
		this.pos = pos;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	
}
