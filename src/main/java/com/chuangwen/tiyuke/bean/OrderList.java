package bean;

public class OrderList {
	private String gname;
	private String num;
	private String	price;
	private String address;
	private String goodsid;
	private String userid;
	public OrderList() {
		
	}
	public OrderList(String gname, String num, String price, String address, String goodsid, String userid) {
	
		this.gname = gname;
		this.num = num;
		this.price = price;
		this.address = address;
		this.goodsid = goodsid;
		this.userid = userid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
