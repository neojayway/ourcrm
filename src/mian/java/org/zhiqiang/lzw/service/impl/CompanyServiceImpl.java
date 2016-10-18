package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Company;
import org.zhiqiang.lzw.mapping.CompanyMapper;
import org.zhiqiang.lzw.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyMapper companyMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return companyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Company record) {
		// TODO Auto-generated method stub
		return companyMapper.insert(record);
	}

	@Override
	public int insertSelective(Company record) {
		// TODO Auto-generated method stub
		return companyMapper.insertSelective(record);
	}

	@Override
	public Company selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return companyMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Company record) {
		// TODO Auto-generated method stub
		return companyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Company record) {
		// TODO Auto-generated method stub
		return companyMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Company record) {
		// TODO Auto-generated method stub
		return companyMapper.updateByPrimaryKey(record);
	}
}