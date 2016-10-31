package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.City;
import org.zhiqiang.lzw.mapping.CityMapper;
import org.zhiqiang.lzw.service.ICityService;

/**
 * 城市业务实现类
 * @author Administrator
 *
 */
@Service("cityService")
public class CityServiceImpl implements ICityService{

	@Autowired
	@Qualifier("cityMapper")
	private CityMapper cityMapper;
	
	public void setCityMapper(CityMapper cityMapper) throws Exception{
		this.cityMapper = cityMapper;
	}
	
	/**
	 * 获取所有记录数
	 * @return
	 */
	@Override
	public int getConuts()  throws Exception{
		return cityMapper.getCounts();
	}
	
	/**
	 * 获取所有城市记录
	 * @return
	 */
	@Override
	public List<City> getAllCity()  throws Exception{
		return cityMapper.getAll();
	}

	/**
	 * 分页获取城市记录
	 * @param map
	 * @return
	 */
	@Override
	public List<City> getCityByPage(int PageSize, int offset)  throws Exception{
		Map map = new HashMap();
		map.put("pageSize", PageSize);
		map.put("offset", offset);
		return cityMapper.getByPage(map);
	}

	/**
	 * 根据ID获取详情
	 * @param id
	 * @return
	 */
	@Override
	public City getCityById(Integer id)  throws Exception{
		return cityMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据省份查询对应城市
	 */
	public List<City> getCitysByPid(Integer pid) throws Exception{
		return cityMapper.getCitysByPid(pid);
	}
	
	/**
	 * 新增城市
	 * @param city
	 * @return
	 */
	@Override
	public int insertCity(City city)  throws Exception{
		return cityMapper.insertSelective(city);
	}

	/**
	 * 删除单个城市
	 * @param id
	 * @return
	 */
	@Override
	public int deleteOneById(Integer id)  throws Exception{
		return cityMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改城市信息
	 * @param city
	 * @return
	 */
	@Override
	public int updateCity(City city)  throws Exception{
		return cityMapper.updateByPrimaryKeySelective(city);
	}
}
