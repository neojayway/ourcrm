package org.zhiqiang.lzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.mapping.PrivilegeMapper;
import org.zhiqiang.lzw.service.IPrivilegeService;

/**
 * 权限业务实现
 * @author LZW
 *
 */
@Service("privilegeService")
public class PrivilegeServiceImpl implements IPrivilegeService{
	
	//注入mapper
	@Autowired
	@Qualifier("privilegeMapper")
	private PrivilegeMapper privilegeMapper;

	@Override
	public List<Privilege> selectAll() {
		return privilegeMapper.selectAll();
	}
	
	public void setPrivilegeMapper(PrivilegeMapper privilegeMapper) {
		this.privilegeMapper = privilegeMapper;
	}




	
	
	
	
}
