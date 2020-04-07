package bean;

public class User {
private String id;
private String nickname;
private String password;
private String money;
public User() {
	
}
public User(String id, String nickname, String password, String money) {

	this.id = id;
	this.nickname = nickname;
	this.password = password;
	this.money = money;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMoney() {
	return money;
}
public void setMoney(String money) {
	this.money = money;
}


}
