package org.zhiqiang.lzw.service;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhiqiang.lzw.entity.City;

public class CityServiceImplTest {

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
	public void testSetCityMapper() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		CityService cityService = (CityService)
				context.getBean("cityService");
		int deleteByPrimaryKey = cityService.deleteByPrimaryKey(2470);
		System.out.println(deleteByPrimaryKey);
	}

	@Test
	public void testInsert() {
		City record = new City();
		record.setName("台北");
		record.setPycode("tb");
		record.setPid(23);
		record.setPostcode("272300");
		record.setAreacode("0537");
		CityService cityService = (CityService)
				context.getBean("cityService");
		int insert = cityService.insert(record);
		System.out.println(insert);
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
