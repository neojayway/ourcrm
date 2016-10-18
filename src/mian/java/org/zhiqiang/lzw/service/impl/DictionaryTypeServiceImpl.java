package org.zhiqiang.lzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.DictionaryType;
import org.zhiqiang.lzw.mapping.DictionaryTypeMapper;
import org.zhiqiang.lzw.service.DictionaryTypeService;

@Service("dictionaryTypeService")
public class DictionaryTypeServiceImpl implements DictionaryTypeService{

	@Autowired
	private DictionaryTypeMapper dictionaryTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dictionaryTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DictionaryType record) {
		// TODO Auto-generated method stub
		return dictionaryTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(DictionaryType record) {
		// TODO Auto-generated method stub
		return dictionaryTypeMapper.insertSelective(record);
	}

	@Override
	public DictionaryType selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dictionaryTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DictionaryType record) {
		// TODO Auto-generated method stub
		return dictionaryTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(DictionaryType record) {
		// TODO Auto-generated method stub
		return dictionaryTypeMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(DictionaryType record) {
		// TODO Auto-generated method stub
		return dictionaryTypeMapper.updateByPrimaryKey(record);
	}
}
