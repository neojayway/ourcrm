package org.zhiqiang.lzw.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
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
import org.zhiqiang.lzw.entity.Province;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.mapping.ProvinceMapper;
import org.zhiqiang.lzw.service.IProvinceService;

/**
 * 省份业务实现类
 * @author Administrator
 *
 */
@Service("provinceService")
public class ProvinceServiceImpl implements IProvinceService{

	@Autowired
	@Qualifier("provinceMapper")
	private ProvinceMapper provinceMapper;
	
	public void setProvinceMapper(ProvinceMapper provinceMapper) {
		this.provinceMapper = provinceMapper;
	}
	
	@Override
	public int getCounts() throws Exception {
		return provinceMapper.getCounts();
	}

	@Override
	public List<Province> getAllProvince() throws Exception {
		return provinceMapper.getAllProvinces();
	}

	@Override
	public Province getProvinceById(Integer id) throws Exception {
		return provinceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertProvince(Province province) throws Exception {
		return provinceMapper.insertSelective(province);
	}

	@Override
	public int deleteProvince(Integer id) throws Exception {
		return provinceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateProvince(Province province) throws Exception {
		return provinceMapper.updateByPrimaryKeySelective(province);
	}

	@Override
	public List<Province> selectByPage(PageBean pageBean) 
		throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageBean", pageBean);
		return provinceMapper.selectByPage(map);
	}

	@Override
	public Map<String, Object> fuzzySearchCompany(String data, PageBean pageBean)
			throws Exception {
		if(pageBean == null){
			pageBean = new PageBean();
		}
		List<Province> list = provinceMapper.getAllProvinces();
		Map<String, Province> map = new TreeMap<String, Province>();
		for (int i = 0; i < list.size(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(list.get(i).getId());
			sb.append(list.get(i).getName());
			sb.append(list.get(i).getPycode());
			map.put(sb.toString(), list.get(i));
		}
		TreeSet<Province> treeSet = new TreeSet<Province>(
			new Comparator<Province>() {
			// 排序方法
			@Override
			public int compare(Province p1, Province p2) {
				return p2.getId().compareTo(p1.getId());
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
			if (b) {
				// 根据key，获取到对应的value值，即对象
				Province province = map.get(key);
				// 把对象放入TreeSet中
				treeSet.add(province);
			}
		}
		
		pageBean.setTotalRecords(treeSet.size());
		
		List<Province> provinceList = new ArrayList<Province>();
		Iterator<Province> iterator = treeSet.iterator();
		if (treeSet.size() > 0) {
			int index1 = 0;
			int index2 = 0;
			boolean flag = false;
			while(iterator.hasNext()){
				Province province = iterator.next();
				if(pageBean.getPageIndex()==index1){
					flag = true;
				}
				if(flag){
					provinceList.add(province);
					index2++;
					if(index2==pageBean.getPageSize()){
						break;
					}
				}
				index1++;
			}
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("provinceList", provinceList);
			dataMap.put("pageBean", pageBean);
			return dataMap;
		}else return null;
	}
}
