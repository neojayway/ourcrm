package org.zhiqiang.lzw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Province;
import org.zhiqiang.lzw.mapping.ProvinceMapper;
import org.zhiqiang.lzw.service.IProvinceService;

/**
 * 省份业务实现类
 * @author Administrator
 *
 */
@Service("provinceService")
public class ProvinceServiceImpl implements IProvinceService{

	@Autowired
	@Qualifier("provinceMapper")
	private ProvinceMapper provinceMapper;
	
	public void setProvinceMapper(ProvinceMapper provinceMapper) {
		this.provinceMapper = provinceMapper;
	}
	
	@Override
	public int getCounts() throws Exception {
		return provinceMapper.getCounts();
	}

	@Override
	public List<Province> getAllProvince() throws Exception {
		return provinceMapper.getAllProvinces();
	}

	@Override
	public List<Province> getProvinceByPage(int PageSize, int offset)
			throws Exception {
		Map map = new HashMap();
		map.put("PageSize", PageSize);
		map.put("offset", offset);
		return provinceMapper.getProvinceByPage(map);
	}

	@Override
	public Province getProvinceById(Integer id) throws Exception {
		return provinceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertProvince(Province province) throws Exception {
		return provinceMapper.insertSelective(province);
	}

	@Override
	public int deleteProvince(Integer id) throws Exception {
		return provinceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateProvince(Province province) throws Exception {
		return provinceMapper.updateByPrimaryKeySelective(province);
	}

}
