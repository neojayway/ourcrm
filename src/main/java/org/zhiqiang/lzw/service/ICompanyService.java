package org.zhiqiang.lzw.service;

import java.util.List;
import java.util.Map;
import org.zhiqiang.lzw.entity.Company;
import org.zhiqiang.lzw.entity.custom.PageBean;

public interface ICompanyService {
	
    List<Company> selectByPage(PageBean pageBean);
    
    int selectTotalRecords();

	List<Company> getAllCompany() throws Exception;
	
	Map<String, Object> fuzzySearchCompany(String Data, PageBean pageBean) throws Exception;
	
	List<Company> getCompanyWhereTodayNeedTouch(String date) throws Exception;
	
	List<Company> getCompanyWhereForgetTouch(String date) throws Exception;
	
	Company getCompanyById(Integer id) throws Exception;
	
	int insertCompany(Company company) throws Exception;
	
	int deleteById(Integer id) throws Exception;
	
	int updateCompany(Company company) throws Exception;
	
}
