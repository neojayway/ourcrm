package org.zhiqiang.lzw.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zhiqiang.lzw.entity.Company;
import org.zhiqiang.lzw.entity.custom.PageBean;
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
	 * 分页获取数据
	 */
	public List<Company> selectByPage(PageBean pageBean){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageBean", pageBean);
		return companyMapper.selectByPage(map);
	}
    
	/**
	 * 获取总记录数
	 */
    public int selectTotalRecords(){
    	return companyMapper.selectTotalRecords();
    }
	
	/**
	 * 获取到所有数据
	 */
	@Override
	public List<Company> getAllCompany()  throws Exception{
		return companyMapper.getAllCompany();
	}
	
	/**
	 * 模糊查询
	 */
	@Override
	public Map<String, Object> fuzzySearchCompany(String data, PageBean pageBean)
		throws Exception {
		if(pageBean == null){
			pageBean = new PageBean();
		}
		// 获取到所有数据保存到list集合
		List<Company> list = companyMapper.getAllCompany();
		// 创建TreeMap对象
		Map<String, Company> map = new TreeMap<String, Company>();
		// 循环遍历list集合
		for (int i = 0; i < list.size(); i++) {
			// 创建StringBuilder对象，开始拼接资料
			StringBuilder str = new StringBuilder();
			str.append(list.get(i).getId());
			str.append(list.get(i).getCode());
			str.append(list.get(i).getName());
			str.append(list.get(i).getPycode());
			str.append(list.get(i).getGrade());
			str.append(list.get(i).getRegionname());
			str.append(list.get(i).getSource());
			str.append(list.get(i).getTrade());
			str.append(list.get(i).getScale());
			str.append(list.get(i).getProvince());
			str.append(list.get(i).getCity());
			str.append(list.get(i).getPostcode());
			str.append(list.get(i).getAddress());
			str.append(list.get(i).getEmail());
			str.append(list.get(i).getWeb());
			str.append(list.get(i).getTel1());
			str.append(list.get(i).getFax());
			str.append(list.get(i).getMobile());
			str.append(list.get(i).getTel2());
			str.append(list.get(i).getNexttouchdate());
			str.append(list.get(i).getQuality());
			str.append(list.get(i).getDealin());
			str.append(list.get(i).getKind());
			str.append(list.get(i).getArtificialperson());
			str.append(list.get(i).getRegistemoney());
			str.append(list.get(i).getBank());
			str.append(list.get(i).getAccount());
			str.append(list.get(i).getTaxcode());
			str.append(list.get(i).getCreater());
			str.append(list.get(i).getCreatetime());
			str.append(list.get(i).getUpdater());
			str.append(list.get(i).getUpdatetime());
			str.append(list.get(i).getOwneruser());
			str.append(list.get(i).getDispenseperson());
			str.append(list.get(i).getDispensedate());
			str.append(list.get(i).getRemark());
			// 将拼接好的字符串和对应对象放入map集合中
			map.put(str.toString(), list.get(i));
		}

		// 准备一个TreeSet，用来存放挑选好的对象，以及对对象进行排序
		TreeSet<Company> treeSet = new TreeSet<Company>(
			new Comparator<Company>(){
			// 排序方法
			@Override
			public int compare(Company c1, Company c2) {
				return c2.getId().compareTo(c1.getId());
			}
		});

		// 判断传入的参数是否为空
		if(data!=null){
			if (data.equals("-1")) {
				// 如果为空就查所有
				data = "";
			}
		}
		if(data==null){
			data = "";
		}

		// 循环遍历map集合中所有的key
		for (String key : map.keySet()) {
			// 定义一个正则表达式 接收来自页面的参数
			String regEx = data;
			// 创建Pattern对象
			Pattern pattern = Pattern.compile(regEx);
			// 创建Matcher对象
			Matcher matcher = pattern.matcher(key);
			// 重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。
			boolean b = matcher.find();
			// 判断匹配结果
			if (b){
				// 根据key，获取到对应的value值，即对象
				Company company = map.get(key);
				// 把对象放入TreeSet中
				treeSet.add(company);
			}
		}

		pageBean.setTotalRecords(treeSet.size());

		List<Company> list2 = new ArrayList<Company>();
		Iterator<Company> iterator = treeSet.iterator();
		
		if (treeSet.size() > 0) {
			int index1 = 0;
			int index2 = 0;
			boolean flag = false;
			while(iterator.hasNext()){
				 Company company = iterator.next();
				if(pageBean.getPageIndex()==index1){
					flag = true;
				}
				if(flag){
					list2.add(company);
					index2++;
					if(index2==pageBean.getPageSize()){
						break;
					}
				}
				index1++;
			}
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("list2", list2);
			dataMap.put("pageBean", pageBean);
			return dataMap;
		}else return null;
	}

	/**
	 * 查询 今天需要联系的客户  
	 */
	@Override
	public List<Company> getCompanyWhereTodayNeedTouch(String date)
		throws Exception {
		return companyMapper.getCompanyWhereTodayNeedTouch(date);
	}
	
	/**
	 * 查询 已过期未联系的客户
	 */
	@Override
	public List<Company> getCompanyWhereForgetTouch(String date) 
		throws Exception {
		return companyMapper.getCompanyWhereForgetTouch(date);
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

	/**
	 * 修改下次联系时间
	 */
	@Override
	public int updateNextTouchTime(Integer id, Date nexttouchdate)
		throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("nexttouchdate", nexttouchdate);
		return companyMapper.updateNextTouchTime(map);
	}
}
