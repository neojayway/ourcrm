package org.zhiqiang.lzw.mapping;

import java.util.List;
import java.util.Map;

import org.zhiqiang.lzw.entity.City;

/**
 * 城市Mapper接口
 * @author Administrator
 *
 */
public interface CityMapper {
	
	/**
	 * 获取记录数
	 * @return
	 */
	public int getCounts(Integer pid) throws Exception;
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public List<City> getByPage(Map<String,Object> map) throws Exception;
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<City> getAll() throws Exception;
	
	/**
	 * 根据省份ID查询对应城市列表
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public List<City> getCitysByPid(Integer pid) throws Exception;
	
	/**
	 * 根据主键ID进行删除
	 * @param id 主键
	 * @return 影响行数
	 */
    int deleteByPrimaryKey(Integer id) throws Exception;

    /**
     * 新增完整城市信息
     * @param record 要新增的城市实体对象
     * @return 影响行数
     */
    int insert(City record) throws Exception;

    /**
     * 新增城市信息(有值的列就插入，没值则为空)
     * @param record 要新增的城市实体对象
     * @return 影响行数
     */
    int insertSelective(City record) throws Exception;

    /**
     * 根据主键ID进行查询
     * @param id 主键ID
     * @return 查询出来的对象
     */
    City selectByPrimaryKey(Integer id) throws Exception;

    /**
     * 修改城市信息(有值的列就修改，没值则不修改)
     * @param record 要修改的城市对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(City record) throws Exception;

    /**
     * 修改城市信息(有值的列就修改，没值的列就为空)
     * @param record 要修改的城市对象
     * @return 影响行数
     */
    int updateByPrimaryKey(City record) throws Exception;
}