package org.zhiqiang.lzw.service;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Company;

public interface ICompanyService {

	int getCounts() throws Exception;
	
	List<Company> getAllCompany() throws Exception;
	
	List<Company> getCompanyByPage(Map map) throws Exception;
	
	Company getCompanyById(Integer id) throws Exception;
	
	int insertCompany(Company company) throws Exception;
	
	int deleteById(Integer id) throws Exception;
	
	int updateCompany(Company company) throws Exception;
	
}
