package org.zhiqiang.lzw.service;

import static org.junit.Assert.fail;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhiqiang.lzw.entity.Province;

public class ProvinceServiceImplTest {
	
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
	}

	@After
	public void tearDown() throws Exception {
		context = null;
	}

	@Test
	public void testGetCounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllProvince() throws Exception {
		//获取业务层对象
		IProvinceService provinceService = 
				(IProvinceService)context.getBean("provinceService");
		//获取所有记录
		List<Province> list = provinceService.getAllProvince();
		//准备一个TreeMap集合
		Map<String,Province> map = new TreeMap<String,Province>();
		//循环遍历所有记录
		for (int i = 0; i < list.size(); i++) {
			//准备一个字符串，对集合中的对象进行处理，每一条记录拼接成一个字符串
			StringBuilder str = new StringBuilder();
			str.append(list.get(i).getId());
			str.append(list.get(i).getName());
			str.append(list.get(i).getPycode());
			//将拼接好的字符串和对应的对象，放入Map集合中
			map.put(str.toString(), list.get(i));
		}
		
		//准备一个TreeSet，用来装挑选出来的对象，并按照id的顺序从小到大排序
		TreeSet<Province> treeSet = new TreeSet<Province>(new Comparator<Province>() {
			@Override
			public int compare(Province p1, Province p2) {
				//以对象的ID排序
				return p1.getId().compareTo(p2.getId());
			}
		});
		
		//循环遍历所有的map里的key
		for (String key : map.keySet()) {
			//定义一个正则表达式
			String regEx= "1";
			//创建Pattern对象
			Pattern pattern = Pattern.compile(regEx);
			//创建Matcher对象
			Matcher matcher = pattern.matcher(key);
			//重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。
			boolean b = matcher.find();
			//判断匹配结果
			if(b){
				//根据map的key获取到map的value，即Province对象
				Province province = map.get(key);
				//把Province对象放到treeSet集合中
				treeSet.add(province);
			}
		}
		
		//循环打印保存在的TreeSet对象中的Province对象
		for (Province province : treeSet) {
			System.out.println(province);
		}
	}

	@Test
	public void testGetProvinceByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProvinceById() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertProvince() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProvince() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProvince() {
		fail("Not yet implemented");
	}

}
