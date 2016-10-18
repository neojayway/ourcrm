package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Popedom;
import org.zhiqiang.lzw.entity.PopedomKey;
import org.zhiqiang.lzw.mapping.PopedomMapper;
import org.zhiqiang.lzw.service.PopedomService;

@Service("popedomService")
public class PopedomServiceImpl implements PopedomService{

	@Autowired
	private PopedomMapper popedomMapper;
	
	@Override
	public int deleteByPrimaryKey(PopedomKey key) {
		// TODO Auto-generated method stub
		return popedomMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Popedom record) {
		// TODO Auto-generated method stub
		return popedomMapper.insert(record);
	}

	@Override
	public int insertSelective(Popedom record) {
		// TODO Auto-generated method stub
		return popedomMapper.insertSelective(record);
	}

	@Override
	public Popedom selectByPrimaryKey(PopedomKey key) {
		// TODO Auto-generated method stub
		return popedomMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(Popedom record) {
		// TODO Auto-generated method stub
		return popedomMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Popedom record) {
		// TODO Auto-generated method stub
		return popedomMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Popedom record) {
		// TODO Auto-generated method stub
		return popedomMapper.updateByPrimaryKey(record);
	}

}
