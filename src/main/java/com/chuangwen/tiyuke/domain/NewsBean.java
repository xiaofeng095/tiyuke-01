package domain;

public class NewsBean {
	private String title;
	private String auther;
	private String date;
	private String info;
	
	
	public NewsBean() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public NewsBean(String title, String auther, String date, String info) {
	
		this.title = title;
		this.auther = auther;
		this.date = date;
		this.info = info;
	}
	
	
	
}
