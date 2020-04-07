package bean;

public class Order {
	private String gname;
	private String num;
	private String	price;
	private String address;
	private String goodsid;
	public Order() {
	}
	public Order(String gname, String num, String price, String address, String goodsid) {
		this.gname = gname;
		this.num = num;
		this.price = price;
		this.address = address;
		this.goodsid = goodsid;
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
	
	
}
