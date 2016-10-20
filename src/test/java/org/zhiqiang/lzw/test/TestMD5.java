package org.zhiqiang.lzw.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.zhiqiang.lzw.util.MD5keyBean;

public class TestMD5 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		MD5keyBean md5 = new MD5keyBean();
		String str = md5.getkeyBeanofStr("123");
		System.out.println(str);
	}

}
