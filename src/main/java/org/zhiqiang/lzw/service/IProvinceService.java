package org.zhiqiang.lzw.service;

import java.util.List;

import org.zhiqiang.lzw.entity.Province;

/**
 *省份业务接口类
 * @author Administrator
 *
 */
public interface IProvinceService {
	
	/**
	 * 获取所有记录数
	 * @return
	 * @throws Exception
	 */
	int getCounts() throws Exception;
	
	/**
	 * 获取所有省份记录
	 * @return
	 * @throws Exception
	 */
	List<Province> getAllProvince() throws Exception;
	
	/**
	 * 分页显示省份记录
	 * @return
	 * @throws Exception
	 */
	List<Province> getProvinceByPage(int PageSize, int offset) throws Exception;
	
	/**
	 * 根据ID获取详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Province getProvinceById(Integer id) throws Exception;
	
	/**
	 * 新增省份
	 * @param province
	 * @return
	 * @throws Exception
	 */
	int insertProvince(Province province) throws Exception;
	
	/**
	 * 删除省份
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteProvince(Integer id) throws Exception;
	
	/**
	 * 修改省份
	 * @param province
	 * @return
	 * @throws Exception
	 */
	int updateProvince(Province province) throws Exception;

}
