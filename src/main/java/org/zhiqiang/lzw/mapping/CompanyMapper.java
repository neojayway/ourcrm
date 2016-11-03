package org.zhiqiang.lzw.mapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.Company;

/**
 * 客户Mapper
 * @author Administrator
 *
 */
public interface CompanyMapper {
	
	int getCounts() throws Exception;
	
	List<Company> getAllCompany() throws Exception;
	
	List<Company> getCompanyByPage(Map map) throws Exception;
	
	List<Company> getCompanyWhereTodayNeedTouch(String date) throws Exception;
	
	List<Company> getCompanyWhereForgetTouch(String date) throws Exception;
	
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Company record) throws Exception;

    int insertSelective(Company record) throws Exception;

    Company selectByPrimaryKey(Integer id) throws Exception;

    int updateByPrimaryKeySelective(Company record) throws Exception;

    int updateByPrimaryKeyWithBLOBs(Company record) throws Exception;

    int updateByPrimaryKey(Company record) throws Exception;
    
    
    
    
}