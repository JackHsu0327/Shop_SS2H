package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.impl.GoodsServiceImpl;



public class BeanTest {
	
	@Test
	public void BeanT() {
		ApplicationContext a1 = new ClassPathXmlApplicationContext("Shop.xml");
		GoodsServiceImpl msi = a1.getBean("msi" , GoodsServiceImpl.class);
		
		System.out.println(msi);
	}
}
