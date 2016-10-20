package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.Province;

/**
 * 省份Mapper类
 * @author Administrator
 *
 */
public interface ProvinceMapper {
	
	/**
	 * 根据主键ID进行删除
	 * @param id
	 * @return 影响行数
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Province record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}