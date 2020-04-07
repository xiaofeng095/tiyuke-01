package bean;

public class UserChats {
	private String goodsid;
	private String info;
	private String idchat;
	public UserChats() {
		
	}
	public UserChats(String goodsid, String info, String idchat) {
	
		this.goodsid = goodsid;
		this.info = info;
		this.idchat = idchat;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getIdchat() {
		return idchat;
	}
	public void setIdchat(String idchat) {
		this.idchat = idchat;
	}

	
	
}
