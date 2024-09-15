package controller;

import com.opensymphony.xwork2.ActionSupport;

import model.Goods;
import service.impl.GoodsServiceImpl;

public class UpdateController extends ActionSupport {
    private String id;
    private String name;
    private String price;
    private String quantity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
        
        try {
        	 Integer idInt = Integer.parseInt(id);
             Integer priceInt = Integer.parseInt(price);
             Integer quantityInt = Integer.parseInt(quantity);
             
             goodsService.update(idInt, priceInt, quantityInt);
             boolean updateSuccess = goodsService.updateSuccess(idInt, priceInt, quantityInt);
            if (updateSuccess) {
            	addActionMessage("商品更新成功！");
                return "updateGoodsSuccess";
            }  else {
                addActionError("商品更新失败！");
                return "updateGoodsError";
            }
        } catch (NumberFormatException e) {
            addActionError("商品 ID 格式錯誤！");
            return "updateGoodsError";    
        }
	}   
}