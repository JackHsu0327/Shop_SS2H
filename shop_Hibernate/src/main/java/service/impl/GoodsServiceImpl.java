package service.impl;

import java.util.List;

import dao.impl.GoodsDaoImpl;
import model.Goods;
import service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	
	private GoodsDaoImpl msi = new GoodsDaoImpl();
	

	@Override
	public void addGoods(Goods g) {
		msi.add(g);				
	}
	
	public boolean isNameDuplicate(String name) {
		 List<Goods> goodsList = msi.selectName(name);
		 return !goodsList.isEmpty();
	}

	@Override
	public List<Goods> selectAll() {
				
		return msi.selectAll();
	}

	@Override
	public List<Goods> selectBy(int id) {
		
		return msi.selectBy(id);
	}

	@Override
	public List<Goods> selectName(String name) {
		
		return msi.selectName(name);
	}

	@Override
	public List<Goods> selectPrice(int minPrice, int maxPrice) {
		
		return msi.selectPrice(minPrice, maxPrice);
	}

	@Override
	public void update(int id, int price, int quantity) {
		List<Goods> goodsList = msi.selectBy(id);
		 Goods[] g = goodsList.toArray(new Goods[1]);
		 if (goodsList.isEmpty()) {
		        System.out.println("商品ID不存在！");
		     return;
		 }    
		 g[0].setPrice(price);
		 g[0].setQuantity(quantity);
		 
		 msi.update(g[0]);		
	}
	
	public boolean updateSuccess(int id, int price, int quantity) {
	    List<Goods> goodsList = msi.selectBy(id);
	    if (goodsList.isEmpty()) {
	    	return false;
	    }	else {
	        return true;
	    }
	}    

	@Override
	public void delete(int id) {
		msi.delete(id);		
	}
	
	public boolean isIdDuplicate(int id) {
		 List<Goods> goodsList = msi.selectBy(id);
		 return !goodsList.isEmpty();
	}

	@Override
	public List<Goods> selectNamePrice_1(String name, int minPrice, int maxPrice) {
		
		return msi.selectNamePrice_1(name, minPrice, maxPrice);
	}

	@Override
	public List<Goods> selectNamePrice_2(String name, int minPrice) {
		
		return msi.selectNamePrice_2(name, minPrice);
	}

	@Override
	public List<Goods> selectNamePrice_3(String name, int maxPrice) {

		return msi.selectNamePrice_3(name, maxPrice);
	}

	@Override
	public List<Goods> selectByPrice_1(int minPrice) {
		
		return msi.selectByPrice_1(minPrice);
	}

	@Override
	public List<Goods> selectByPrice_2(int maxPrice) {
		
		return msi.selectByPrice_2(maxPrice);
	}

}
