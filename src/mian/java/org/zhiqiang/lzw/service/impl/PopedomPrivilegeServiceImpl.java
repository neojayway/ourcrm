package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.PopedomPrivilegeKey;
import org.zhiqiang.lzw.mapping.PopedomPrivilegeMapper;
import org.zhiqiang.lzw.service.PopedomPrivilegeService;

@Service("popedomPrivilegeService")
public class PopedomPrivilegeServiceImpl implements PopedomPrivilegeService{

	@Autowired
	private PopedomPrivilegeMapper popedomPrivilegeMapper;
	
	public void setPopedomPrivilegeMapper(
			PopedomPrivilegeMapper popedomPrivilegeMapper) {
		this.popedomPrivilegeMapper = popedomPrivilegeMapper;
	}
	
	@Override
	public int deleteByPrimaryKey(PopedomPrivilegeKey key) {
		// TODO Auto-generated method stub
		return popedomPrivilegeMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(PopedomPrivilegeKey record) {
		// TODO Auto-generated method stub
		return popedomPrivilegeMapper.insert(record);
	}

	@Override
	public int insertSelective(PopedomPrivilegeKey record) {
		// TODO Auto-generated method stub
		return popedomPrivilegeMapper.insertSelective(record);
	}
}
