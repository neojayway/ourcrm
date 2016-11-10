package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;
import org.zhiqiang.lzw.entity.Province;

/**
 * 省份Mapper类
 * @author Administrator
 *
 */
public interface ProvinceMapper {
	
    /**
     * 带条件分页查询
     * @param 
     * @return
     */
    List<Province> selectByPage(Map<String, Object> map);
	
	/**
	 * 获取所有记录数
	 * @return
	 * @throws Exception
	 */
	int getCounts() throws Exception;
	
	/**
	 * 获取所有记录
	 * @return
	 * @throws Exception
	 */
	List<Province> getAllProvinces() throws Exception;
	
	/**
	 * 根据主键ID进行删除
	 * @param id
	 * @return 影响行数
	 */
    int deleteByPrimaryKey(Integer id) throws Exception;
    
    /**
     * 根据省份名称查询
     * @param name
     * @return
     * @throws Exception
     */
    List<Province> selectProvinceByName(String name) throws Exception;

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Province record) throws Exception;

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(Province record) throws Exception;

    /**
     * 根据主键ID查询详情
     * @param id
     * @return
     */
    Province selectByPrimaryKey(Integer id) throws Exception;

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Province record) throws Exception;
    
    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Province record) throws Exception;
}
