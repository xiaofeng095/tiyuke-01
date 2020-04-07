package bean;

public class Chats {
	private String userid;
	private String info;
	public Chats() {
		super();
	}
	public Chats(String userid, String info) {
		super();
		this.userid = userid;
		this.info = info;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
