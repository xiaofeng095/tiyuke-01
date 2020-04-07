package bean;

public class Goods {
	private String id;
	private String url;
	private String name;
	private String price;
	private String num;
	private String other;
	public Goods() {
		
	}
	public Goods(String id, String url, String name, String price, String num, String other) {
		
		this.id = id;
		this.url = url;
		this.name = name;
		this.price = price;
		this.num = num;
		this.other = other;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	
}
