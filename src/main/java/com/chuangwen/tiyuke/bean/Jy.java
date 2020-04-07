package bean;

public class Jy {
private String id;
private String userid;
private String address;
private String money;
private String url;
private String info;
public Jy() {

}
public Jy(String id, String userid, String address, String money, String url, String info) {

	this.id = id;
	this.userid = userid;
	this.address = address;
	this.money = money;
	this.url = url;
	this.info = info;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getMoney() {
	return money;
}
public void setMoney(String money) {
	this.money = money;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}



}
