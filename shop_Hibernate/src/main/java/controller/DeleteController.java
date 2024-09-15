package controller;

import com.opensymphony.xwork2.ActionSupport;

import model.Goods;
import service.impl.GoodsServiceImpl;

public class DeleteController extends ActionSupport{
	
	 private String id;
	 
	 public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }
	 
	@Override
	public String execute() {
		GoodsServiceImpl goodsService = new GoodsServiceImpl();
        try {
            Integer idInt = Integer.parseInt(id);            
            boolean isDeleted = goodsService.isIdDuplicate(idInt);
            if (isDeleted) {
            	goodsService.delete(idInt);
                addActionMessage("商品刪除成功！");
                return "deleteGoodsSuccess";
            } else {
                addActionError("找不到該商品！");
                return "deleteGoodsError";
            }
        } catch (NumberFormatException e) {
            addActionError("商品 ID 格式錯誤！");
            return "deleteGoodsError";
        }
    }
                
}
