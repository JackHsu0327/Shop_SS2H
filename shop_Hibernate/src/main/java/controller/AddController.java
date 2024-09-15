package controller;

import com.opensymphony.xwork2.ActionSupport;

import model.Goods;
import service.impl.GoodsServiceImpl;

public class AddController extends ActionSupport {
	private String name;
	private String price;
	private String quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String execute() {
	    GoodsServiceImpl goodsService = new GoodsServiceImpl();
	    if (goodsService.isNameDuplicate(name)) {
	        addActionError("商品名稱已存在！");
	        return "addGoodsError";
	    } else {
	        try {
	            Integer priceInt = Integer.parseInt(price);
	            Integer quantityInt = Integer.parseInt(quantity);

	            Goods g = new Goods(null, name, priceInt, quantityInt);
	            goodsService.addGoods(g);
	            addActionMessage("商品新增成功！");
	            return "addGoodsSuccess";
	        } catch (NumberFormatException e) {
	            addActionError("價格或庫存數量輸入錯誤！");
	            return "addGoodsError";
	        }
	    }
	}
}
