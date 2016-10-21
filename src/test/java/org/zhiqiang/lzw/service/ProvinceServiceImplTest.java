package org.zhiqiang.lzw.service;

import static org.junit.Assert.fail;

import java.util.List;

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
		IProvinceService provinceService = 
				(IProvinceService)context.getBean("provinceService");
		List<Province> list = provinceService.getAllProvince();
		for (Province province : list) {
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
