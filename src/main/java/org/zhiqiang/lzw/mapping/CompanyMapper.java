package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;
import org.zhiqiang.lzw.entity.Company;

/**
 * 客户Mapper
 * @author Administrator
 *
 */
public interface CompanyMapper {
	
    /**
     * 带条件分页查询
     * @param 
     * @return
     */
    List<Company> selectByPage(Map<String, Object> map);
    
    /**
     * 查询总记录数
     * @param 
     * @return
     */
    int selectTotalRecords();

	
	List<Company> getAllCompany() throws Exception;
	
	List<Company> getCompanyWhereTodayNeedTouch(String date) throws Exception;
	
	List<Company> getCompanyWhereForgetTouch(String date) throws Exception;
	
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Company record) throws Exception;

    int insertSelective(Company record) throws Exception;

    Company selectByPrimaryKey(Integer id) throws Exception;
    
    int updateNextTouchTime(Map map) throws Exception;

    int updateByPrimaryKeySelective(Company record) throws Exception;

    int updateByPrimaryKeyWithBLOBs(Company record) throws Exception;

    int updateByPrimaryKey(Company record) throws Exception;
    
    
    
    
}