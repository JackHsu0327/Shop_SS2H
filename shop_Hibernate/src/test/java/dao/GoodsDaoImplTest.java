package dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.impl.GoodsDaoImpl;
import model.Goods;

public class GoodsDaoImplTest {
	
	private static GoodsDaoImpl mdi = new GoodsDaoImpl();
	
			//@Test
			public void addTest() {
				mdi.add(new Goods(null, "ABC", 180, 10));
				System.out.println("success");
			}
			
			//@Test
			public void selectAllTest(){
				System.out.println(mdi.selectAll());
			}
			
			//@Test
			public void selectByTest(){
				List<Goods> l=mdi.selectBy(2);
				Goods m=l.get(0);
				System.out.println(l);
			}
			
			//@Test
			public void selectNameTest(){
				List<Goods> l=mdi.selectName("ca");
				Goods m=l.get(0);
				System.out.println(l);
			}
			
			//@Test
			public void selectPriceTest(){
				List<Goods> l=mdi.selectPrice(100, 150);
				Goods m=l.get(0);
				System.out.println(l);
			}
			
			//@Test
			public void updateTest(){
				List<Goods> l=mdi.selectBy(12);
				Goods[] g=l.toArray(new Goods[1]);
				
				//g[0].setName("Flat White");
				g[0].setPrice(190);
				g[0].setQuantity(10);
				
				mdi.update(g[0]);
				System.out.println("success");
			}
			
			@Test
			public void deleteTest() {
				mdi.delete(12);
				System.out.println("success");
			}
	}