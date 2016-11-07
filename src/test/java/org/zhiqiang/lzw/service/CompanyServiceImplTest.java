package org.zhiqiang.lzw.service;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
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
import org.zhiqiang.lzw.entity.Company;

public class CompanyServiceImplTest {

	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		//context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
	}

	@After
	public void tearDown() throws Exception {
		//context = null;
	}

	@Test
	public void testGetCounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllCompany() throws Exception{
		//获取业务层对象
		ICompanyService companyService = 
				(ICompanyService)context.getBean("companyService");
		//获取到所有数据保存到list集合
		List<Company> list = companyService.getAllCompany();
		//创建TreeMap对象
		Map<String,Company> map = new TreeMap<String,Company>();
		//循环遍历list集合
		for (int i = 0; i < list.size(); i++) {
			//创建StringBuilder对象，开始拼接资料
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
			//将拼接好的字符串和对应对象放入map集合中
			map.put(str.toString(), list.get(i));
		}
		
		//准备一个TreeSet，用来存放挑选好的对象，以及对对象进行排序
		TreeSet<Company> treeSet = new TreeSet<Company>(new Comparator<Company>() {
			//排序方法
			@Override
			public int compare(Company c1, Company c2) {
				return c1.getId().compareTo(c2.getId());
			}
		});
		
		//循环遍历map集合中所有的key
		for (String key : map.keySet()) {
			//定义一个正则表达式
			String regEx= "";
			//创建Pattern对象
			Pattern pattern = Pattern.compile(regEx);
			//创建Matcher对象
			Matcher matcher = pattern.matcher(key);
			//重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。
			boolean b = matcher.find();
			//判断匹配结果
			if(b){
				//根据key，获取到对应的value值，即对象
				Company company = map.get(key);
				//把对象放入TreeSet中
				treeSet.add(company);
			}
		}
		
		//循环打印treeSet中对象的值
		for (Company company : treeSet) {
			System.out.println(company);
		}
		
	}

	@Test
	public void testGetCompanyWhereTodayNeedTouch() throws Exception{
		//ICompanyService companyService = 
		//		(ICompanyService)context.getBean("companyService");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		
		String str = simple.format(new Date());
		
		
		System.out.println(str);
		//companyService.getCompanyWhereTodayNeedTouch(date);
	}
	
	@Test
	public void testGetCompanyByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCompanyById() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertCompany() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCompany() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddBefore(){
		ICompanyService companyService = 
			(ICompanyService)context.getBean("companyService");
		
	}
}
