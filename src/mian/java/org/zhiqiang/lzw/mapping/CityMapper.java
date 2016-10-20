package org.zhiqiang.lzw.mapping;

import org.zhiqiang.lzw.entity.City;

/**
 * 城市Mapper接口
 * @author Administrator
 *
 */
public interface CityMapper {
	
	/**
	 * 根据主键ID进行删除
	 * @param id 主键
	 * @return 影响行数
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增完整城市信息
     * @param record 要新增的城市实体对象
     * @return 影响行数
     */
    int insert(City record);

    /**
     * 新增城市信息(有值的列就插入，没值则为空)
     * @param record 要新增的城市实体对象
     * @return 影响行数
     */
    int insertSelective(City record);

    /**
     * 根据主键ID进行查询
     * @param id 主键ID
     * @return 查询出来的对象
     */
    City selectByPrimaryKey(Integer id);

    /**
     * 修改城市信息(有值的列就修改，没值则不修改)
     * @param record 要修改的城市对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(City record);

    /**
     * 修改城市信息(有值的列就修改，没值的列就为空)
     * @param record 要修改的城市对象
     * @return 影响行数
     */
    int updateByPrimaryKey(City record);
}