package org.zhiqiang.lzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.DictionaryType;
import org.zhiqiang.lzw.mapping.DictionaryTypeMapper;
import org.zhiqiang.lzw.service.IDictionaryTypeService;

/**
 * 数据字典业务实现类
 * @author Administrator
 *
 */
@Service("dictionaryTypeService")
public class DictionaryTypeServiceImpl implements IDictionaryTypeService{

	@Autowired
	@Qualifier("dictionaryTypeMapper")
	private DictionaryTypeMapper dictionaryTypeMapper;
	
	public void setDictionaryTypeMapper(
			DictionaryTypeMapper dictionaryTypeMapper) {
		this.dictionaryTypeMapper = dictionaryTypeMapper;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dictionaryTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DictionaryType record) {
		return dictionaryTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(DictionaryType record) {
		return dictionaryTypeMapper.insertSelective(record);
	}

	@Override
	public DictionaryType selectByPrimaryKey(Integer id) {
		return dictionaryTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DictionaryType> selectDictionaryTypesByCode(String code) {
		return dictionaryTypeMapper.selectDictionaryTypesByCode(code);
	}

	@Override
	public int updateByPrimaryKeySelective(DictionaryType record) {
		return dictionaryTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(DictionaryType record) {
		return dictionaryTypeMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(DictionaryType record) {
		return dictionaryTypeMapper.updateByPrimaryKey(record);
	}

}
