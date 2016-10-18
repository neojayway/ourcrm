package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Province;
import org.zhiqiang.lzw.mapping.ProvinceMapper;
import org.zhiqiang.lzw.service.ProvinceService;

@Service("provinService")
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return provinceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Province record) {
		// TODO Auto-generated method stub
		return provinceMapper.insert(record);
	}

	@Override
	public int insertSelective(Province record) {
		// TODO Auto-generated method stub
		return provinceMapper.insertSelective(record);
	}

	@Override
	public Province selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return provinceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Province record) {
		// TODO Auto-generated method stub
		return provinceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Province record) {
		// TODO Auto-generated method stub
		return provinceMapper.updateByPrimaryKey(record);
	}
}
