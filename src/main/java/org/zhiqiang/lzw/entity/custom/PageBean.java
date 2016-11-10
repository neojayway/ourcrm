package org.zhiqiang.lzw.entity.custom;

/**
 * 分页bean
 * @author LZW
 *
 */
public class PageBean {
	
	private Integer currPage = 1; //默认为第一页
	private Integer pageSize = 5; //默认每页显示5条
	private Integer totalRecords;
	private Integer totalPages;
	private String url;
	
	
	/**
	 * 返回当前页的索引
	 * @return
	 */
	public Integer getPageIndex(){
		return (this.currPage-1)*this.pageSize;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}
	/**
	 * 设置总记录数的同时，计算出总页数的
	 * @param totalRecords
	 */
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
		Integer value = totalRecords/this.pageSize;
		setTotalPages(totalRecords%this.pageSize==0?value:value+1);
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize
				+ ", totalRecords=" + totalRecords + ", totalPages="
				+ totalPages + ", url=" + url + "]";
	}
	
	
	
	
	
}
