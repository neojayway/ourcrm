package org.zhiqiang.lzw.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Company;
import org.zhiqiang.lzw.mapping.CompanyMapper;
import org.zhiqiang.lzw.service.ICompanyService;

/**
 * 客户业务实现类
 * @author Administrator
 *
 */
@Service("companyService")
public class CompanyServiceImpl implements ICompanyService{

	@Autowired
	@Qualifier("companyMapper")
	private CompanyMapper companyMapper;
	
	public void setCompanyMapper(CompanyMapper companyMapper) {
		this.companyMapper = companyMapper;
	}
	
	/**
	 * 获取到所有数据条数
	 */
	@Override
	public int getCounts() throws Exception {
		return companyMapper.getCounts();
	}

	/**
	 * 获取到所有数据
	 */
	@Override
	public List<Company> getAllCompany()  throws Exception{
		return companyMapper.getAllCompany();
	}

	/**
	 * 分页显示数据
	 */
	@Override
	public List<Company> getCompanyByPage(Map map)  throws Exception{
		return companyMapper.getCompanyByPage(map);
	}

	/**
	 * 根据ID获取数据
	 */
	@Override
	public Company getCompanyById(Integer id)  throws Exception{
		return companyMapper.selectByPrimaryKey(id);
	}

	/**
	 * 保存客户
	 */
	@Override
	public int insertCompany(Company company)  throws Exception{
		return companyMapper.insertSelective(company);
	}

	/**
	 * 删除客户
	 */
	@Override
	public int deleteById(Integer id)  throws Exception{
		return companyMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改客户
	 */
	@Override
	public int updateCompany(Company company)  throws Exception{
		return companyMapper.updateByPrimaryKeySelective(company);
	}

}
