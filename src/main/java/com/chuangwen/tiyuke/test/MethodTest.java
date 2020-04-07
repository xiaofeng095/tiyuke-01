package test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.Chats;
import bean.Goods;
import bean.Jy;
import bean.News;
import bean.Order;
import bean.User;
import bean.UserChats;
import db.DBUtils;
import db.Dao;

public class MethodTest {
	Dao dao = new Dao();
	
	@Test
	public void connect() throws Exception {
		Connection s = DBUtils.getConn();
		System.out.println(s);
	}
	
	@Test
	public void login() {
		boolean flag = dao.login("10001", "123");
		System.out.println("登陆"+flag);
	}
	
	@Test
	public void insertImg() {
		int i = dao.insertImg("10003", "http://localhost:8080/images/IMG_1974.jpg", "猫绳","25", "10", "玩具");
		System.out.println("添加："+i);
	}
	
	@Test
	public void allgoods() {
		Dao dao = new Dao();
		List<Goods> list = dao.allGoods();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getName());
		}
	}
	
	@Test
	public void resultGoods() {
		Dao dao = new Dao();
		List<Goods> list = dao.resultGoods("宠物 ");
		for(int i=0;i<list.size();i++) {
		
			System.out.println(list.get(i).getUrl());
		}
	}
	@Test
	public void allUser() {
		Dao dao = new Dao();
		List<User> list = dao.allUsers();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getNickname());
		}
	}
	
	@Test
	public void adminreg() {
		Dao dao = new Dao();
		boolean flag = dao.adminReg("admin1", "123456");
		System.out.println("注册："+flag);
	}
	
	@Test
	public void insertNews() {
		Dao dao = new Dao();
		boolean flag = dao.insertNews("猫咪如何喂养", "官方", "4.24", "嗯疯狂的少女时代艰苦奋斗是咖啡开始懂得思考非法所得分", "newsStu");
		System.out.println("发布："+flag);
	}
	
	@Test
	public void selectNews() {
		Dao dao = new Dao();
		List<News> list = dao.allNews("newsPub");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getTitle());
		}
	}
	
	
	@Test
	public void addmoney() {
		Dao dao = new Dao();
		boolean flag = dao.addMoney("1000", "10001");
		System.out.println("充值："+flag);
	}
	
	@Test
	public void resultChats() {
		Dao dao = new Dao();
		List<Chats> list = dao.resultChat("10008");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getUserid()+":"+list.get(i).getInfo());
		}
	}
	@Test
	public void addOrder() {
		Dao dao = new Dao();
		boolean flag = dao.addOrder("狗狗大礼包", "1", "999", "东南大学成贤学院", "10008", "10001");

			System.out.println("订单添加:"+flag);
		
	}
	@Test
	public void resultOrder() {
		Dao dao = new Dao();
		List<Order> list = dao.resultOrder("10001");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getGname()+","+list.get(i).getNum()+","
					+list.get(i).getPrice()+","+list.get(i).getGoodsid()+","+list.get(i).getAddress());
		}
	}
	
	@Test
	public void addChat() {
		Dao dao = new Dao();
		boolean flag = dao.addChat("10008", "10001", "真心挺好的");
		System.out.println("添加"+flag);

	}
	@Test
	public void getJy() {
		Dao dao = new Dao();
		List<Jy> list = dao.resultJy("10002");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getAddress());
		}
		
	}
	@Test
	public void resultUserChats() {
		Dao dao = new Dao();
		List<UserChats> list = dao.resultUserChat("10001");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getGoodsid()+":"+list.get(i).getInfo());
		}
	}

	@Test
	public void delChat() {
		Dao dao = new Dao();
		boolean flag = dao.DelChat("12");
		System.out.println("删除"+flag);

	}
}
