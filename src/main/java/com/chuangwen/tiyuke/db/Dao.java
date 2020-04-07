package db;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Chats;
import bean.Goods;
import bean.Jy;
import bean.JyOrder;
import bean.News;
import bean.Order;
import bean.OrderList;
import bean.User;
import bean.UserChats;

public class Dao {
	public static String username;
	public static String money;
	/**
	 * 根据用户输入的ID 与 密码 实现登陆
	 * @param id 用户ID
	 * @param pwd 用户密码
	 * @return true登陆成功 false登陆失败
	 */
	public boolean login(String id,String pwd) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "select * from user where id = ? and password = ?";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				ps.setString(2, pwd);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					username = rs.getString("nickname");
					money = rs.getString("money");
					return true;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
	public String register(String nickname,String pwd) {
		try(Connection conn = DBUtils.getConn()){
			String sql1 = "select * from user where nickname= ? ";
			String sql2 = "insert into user values(null,?,?)";
			String sql3 = "select id from user where nickname= ? ";
			try(PreparedStatement ps1 = conn.prepareStatement(sql1)){
				ps1.setString(1, nickname);
				ResultSet rs1 = ps1.executeQuery();
				boolean i = rs1.next();
				System.out.println("3."+i);
				if(i) {
					return "0:false";//0.注册失败 ： false
				}else {
					try(PreparedStatement ps2 = conn.prepareStatement(sql2)){
						ps2.setString(1, nickname);
						ps2.setString(2, pwd);
						int flag = ps2.executeUpdate();
						System.out.println("1."+flag);
						if(flag>0) {
							//注册成功
							System.out.println("2."+flag);
							try(PreparedStatement ps3 = conn.prepareStatement(sql3)){
								ps3.setString(1, nickname);
								ResultSet rs2 = ps3.executeQuery();
								rs2 = ps3.executeQuery();
								while(rs2.next()) {
									
									return "1:"+rs2.getString("id");//1.成功:id
								}
								
							}
						}else {
							//注册失败
							System.out.println(flag);
							return "0:false";//0.注册失败 ： false
						}
					}
					
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "0:false";//0.注册失败 ： false
	}
	public boolean existSelect(String nickname) {
		try(Connection conn = DBUtils.getConn()){
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	//添加商品前判断
	public boolean testInser(String id) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "select * from goods where id = ? ";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {//商品编号已存在
					return false;
				}else {//商品编号不存在
					return true;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	//添加商品
	public int insertImg(String id,String url,String name,String price,String num,String other) {
		int written = 0;
		try(Connection conn = DBUtils.getConn()){
			String sql = "insert into goods values(?,?,?,?,?,?)";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				ps.setString(2, url);
				ps.setString(3, name);
				ps.setString(4, price);
				ps.setString(5,num);
				ps.setString(6, other);
				
				written = ps.executeUpdate();
				return written;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return written;
	}
	
	//查询所有商品信息
	public List<Goods> allGoods(){
		String sql = "select * from goods";
		
		try (Connection conn = DBUtils.getConn()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
				List<Goods> list = new ArrayList<Goods>();
				while(rs.next()) {
					Goods goods = new Goods();
					goods.setId(rs.getString("id"));
					goods.setUrl(rs.getString("url"));
					goods.setName(rs.getString("name"));
					goods.setPrice(rs.getString("price"));
					goods.setNum(rs.getString("num"));
					goods.setOther(rs.getString("other"));
					list.add(goods);
				}
				return list;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	//删除商品
	public boolean delgoods(String id) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "delete from goods where id=?";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				int i=ps.executeUpdate();
				if(i>0) {
					return true;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	//修改商品信息
	public int updateGoods(String id,String url,String name,String price,String num,String other) {
		int written = 0;
		try(Connection conn = DBUtils.getConn()){
			String sql = "update goods set url=?,name=?,price=?,num=?,other=? where id=? ";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				
				ps.setString(1, url);
				ps.setString(2, name);
				ps.setString(3, price);
				ps.setString(4,num);
				ps.setString(5, other);
				ps.setString(6, id);
				written = ps.executeUpdate();
				return written;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return written;
	}
	
	//用户列表
	public List<User> allUsers(){
		try(Connection conn = DBUtils.getConn()){
			String sql = "select * from user";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
				List<User> list  = new ArrayList<User>();
				while(rs.next()) {
					User user = new User();
					user.setId(rs.getString("id"));
					user.setNickname(rs.getString("nickname"));
					user.setPassword(rs.getString("password"));
					user.setMoney(rs.getString("money"));
					list.add(user);
				}
				return list;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	
	//删除用户
	public boolean delUser(String id) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "delete from user where id=?";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				int i=ps.executeUpdate();
				if(i>0) {
					return true;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	//管理员登陆
	public boolean adminLogin(String username,String password) {
		
		try(Connection conn = DBUtils.getConn()){
			String sql = "select * from admin where username = ? and password = ?";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, username);
				ps.setString(2, password);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
			
					return true;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	//管理员注册
	public boolean adminReg(String username,String password) {
		try(Connection conn = DBUtils.getConn()){
			String sql1 = "select * from admin where username= ?";
			String sql2 = "insert into admin values(?,?)";
				
						try(PreparedStatement ps2 = conn.prepareStatement(sql2)){
							ps2.setString(1, username);
							ps2.setString(2, password);
							int a = ps2.executeUpdate();
							if(a>0) {
								return true;//注册成功
							}
						}
				
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
	//发布新闻
	public boolean insertNews(String title,String auther,String date,String info,String dbname) {
		if("newsPub".equals(dbname)) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "insert into newsPub values(null,?,?,?,?);";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				//ps.setString(1, dbname);
				ps.setString(1, title);
				ps.setString(2, auther);
				ps.setString(3, date);
				ps.setString(4, info);
				int flag = ps.executeUpdate();
				if(flag>0) {
					return true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}else if("newsStu".equals(dbname)) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "insert into newsStu values(null,?,?,?,?);";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				//ps.setString(1, dbname);
				ps.setString(1, title);
				ps.setString(2, auther);
				ps.setString(3, date);
				ps.setString(4, info);
				int flag = ps.executeUpdate();
				if(flag>0) {
					return true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	} else if("newsImp".equals(dbname)) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "insert into newsImp values(null,?,?,?,?);";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				//ps.setString(1, dbname);
				ps.setString(1, title);
				ps.setString(2, auther);
				ps.setString(3, date);
				ps.setString(4, info);
				int flag = ps.executeUpdate();
				if(flag>0) {
					return true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		return false;
	}
	
	//查询所有新闻信息
	public List<News> allNews(String dbName){
		if("newsStu".equals(dbName)) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "select * from newsStu";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
				List<News> list = new ArrayList<News>();
				while(rs.next()) {
					News news = new News();
					news.setId(rs.getInt("id"));
					news.setTitle(rs.getString("title"));
					news.setAuther(rs.getString("auther"));
					news.setDate(rs.getString("date"));
					news.setInfo(rs.getString("info"));
					list.add(news);
				}
				return list;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		}else if("newsImp".equals(dbName)) {
			try(Connection conn = DBUtils.getConn()){
				String sql = "select * from newsImp";
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ResultSet rs = ps.executeQuery();
					List<News> list = new ArrayList<News>();
					while(rs.next()) {
						News news = new News();
						news.setId(rs.getInt("id"));
						news.setTitle(rs.getString("title"));
						news.setAuther(rs.getString("auther"));
						news.setDate(rs.getString("date"));
						news.setInfo(rs.getString("info"));
						list.add(news);
					}
					return list;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			}else if("newsPub".equals(dbName)) {
				try(Connection conn = DBUtils.getConn()){
					String sql = "select * from newsPub";
					try(PreparedStatement ps = conn.prepareStatement(sql)){
						ResultSet rs = ps.executeQuery();
						List<News> list = new ArrayList<News>();
						while(rs.next()) {
							News news = new News();
							news.setId(rs.getInt("id"));
							news.setTitle(rs.getString("title"));
							news.setAuther(rs.getString("auther"));
							news.setDate(rs.getString("date"));
							news.setInfo(rs.getString("info"));
							list.add(news);
						}
						return list;
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				}
		return null;
	}
	
	public boolean delNews(String dbname,String id) {
		if("newsPub".equals(dbname)) {
		try(Connection conn = DBUtils.getConn()){
			String sql = "delete from newsPub where id = ?";
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, id);
				int flag = ps.executeUpdate();
				if(flag>0) {
					return true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		} else if("newsImp".equals(dbname)) {
			try(Connection conn = DBUtils.getConn()){
				String sql = "delete from newsImp where id = ?";
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, id);
					int flag = ps.executeUpdate();
					if(flag>0) {
						return true;
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			}else if("newsStu".equals(dbname)) {
				try(Connection conn = DBUtils.getConn()){
					String sql = "delete from newsStu where id = ?";
					try(PreparedStatement ps = conn.prepareStatement(sql)){
						ps.setString(1, id);
						int flag = ps.executeUpdate();
						if(flag>0) {
							return true;
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				}
		
		return false;
	}
	//查询所有商品信息
	public List<Goods> resultGoods(String other){
		String sql = "select * from goods where other=? ";
		
		try (Connection conn = DBUtils.getConn()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, other);
				ResultSet rs = ps.executeQuery();
				List<Goods> list = new ArrayList<Goods>();
				while(rs.next()) {
					Goods goods = new Goods();
					goods.setId(rs.getString("id"));
					goods.setUrl(rs.getString("url").split("/images/")[1]);
					goods.setName(rs.getString("name"));
					goods.setPrice(rs.getString("price"));
					goods.setNum(rs.getString("num"));
					list.add(goods);
				}
				return list;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	//账户余额充值
		public boolean addMoney(String sum,String id){
			String sql = "update user set money=? where id = ?";
			
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, sum);
					ps.setString(2, id);
					int i = ps.executeUpdate();
					if(i>0) {
						return true;
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return false;
			
		}
		
		//查看商品评价
		public List<Chats> resultChat(String goodsid){
			String sql = "select * from chat where goodsid=? ";
			
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, goodsid);
					ResultSet rs = ps.executeQuery();
					List<Chats> list = new ArrayList<Chats>();
					while(rs.next()) {
						Chats chats = new Chats();
						chats.setUserid(rs.getString("userid"));
						chats.setInfo(rs.getString("info"));
						list.add(chats);
					}
					return list;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;		
		}
		//查看用户商品评价
		public List<UserChats> resultUserChat(String userid){
			String sql = "select * from chat where userid=? ";
			
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, userid);
					ResultSet rs = ps.executeQuery();
					List<UserChats> list = new ArrayList<UserChats>();
					while(rs.next()) {
						UserChats chats = new UserChats();
						chats.setGoodsid(rs.getString("goodsid"));
						chats.setInfo(rs.getString("info"));
						chats.setIdchat(rs.getString("idchat"));
						list.add(chats);
					}
					return list;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;		
		}
		//删除用户商品评价
		public boolean DelChat(String idchat){
			String sql = "delete  from chat where idchat=? ";
			
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setInt(1, Integer.parseInt(idchat));
				int flag = ps.executeUpdate();
				if(flag>0) {
					return true;
				}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return false;		
		}
		//添加订单
		public boolean addOrder(String name,String num,String price,String address,String goodsid,String userid){
			String sql = "insert into gorder values(null,?,?,?,?,?,?);";	
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, name);
					ps.setString(2, num);
					ps.setString(3, price);
					ps.setString(4, address);
					ps.setString(5, goodsid);
					ps.setString(6, userid);			
					int flag = ps.executeUpdate();
					if(flag>0) {
						return true;
					}		
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;		
		}
		
		//查看用户订单
		public List<Order> resultOrder(String userid){
			String sql = "select * from gorder where userid=? ";
			
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, userid);
					ResultSet rs = ps.executeQuery();
					List<Order> list = new ArrayList<Order>();
					while(rs.next()) {
						Order order = new Order();
						order.setGname(rs.getString("name"));
						order.setNum(rs.getString("num"));
						order.setPrice(rs.getString("price"));
						order.setGoodsid(rs.getString("goodsis"));
						order.setAddress(rs.getString("address"));
						list.add(order);
					}
					return list;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;		
		}
		//查看订单
		public List<OrderList> resultOrderList(){
			String sql = "select * from gorder ";
			
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					
					ResultSet rs = ps.executeQuery();
					List<OrderList> list = new ArrayList<OrderList>();
					while(rs.next()) {
						OrderList order = new OrderList();
						order.setGname(rs.getString("name"));
						order.setNum(rs.getString("num"));
						order.setPrice(rs.getString("price"));
						order.setGoodsid(rs.getString("goodsis"));
						order.setAddress(rs.getString("address"));
						order.setUserid(rs.getString("userid"));
						list.add(order);
					}
					return list;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;		
		}
		
		//添加用户评论
		public boolean addChat(String goodsid,String userid,String info){
			String sql = "insert into chat values(null,?,?,?);";	
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, goodsid);
					ps.setString(2, userid);
					ps.setString(3, info);		
					int flag = ps.executeUpdate();
					if(flag>0) {
						return true;
					}		
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;		
		}
		
		//添加接受寄养信息
		public int insertJY(String filename,String userid,String address,String money,String url,String info) {
			int written = 0;
			try(Connection conn = DBUtils.getConn()){
				String sql = "insert into jy values(?,?,?,?,?,?)";
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, filename);
					ps.setString(2, userid);
					ps.setString(3, address);
					ps.setString(4, money);
					ps.setString(5,url);
					ps.setString(6, info);
					
					written = ps.executeUpdate();
					return written;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return written;
		}
		
		//查询用户寄养订单
		public List<Jy> resultJy(String userid){
			String sql = "select * from jy where userid=? ";
			
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, userid);
					ResultSet rs = ps.executeQuery();
					List<Jy> list = new ArrayList<Jy>();
					while(rs.next()) {
						Jy jy = new Jy();
						jy.setId(rs.getString("id"));
						jy.setUserid(rs.getString("userid"));
						jy.setAddress(rs.getString("address"));
						jy.setMoney(rs.getString("money"));
						jy.setUrl(rs.getString("url"));
						jy.setInfo(rs.getString("info"));

						list.add(jy);
					}
					return list;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
			
		}
		
		//查询用户寄养订单
		public List<JyOrder> resultJyorder(String userid){
			String sql = "select * from jyorder where getid=? ";		
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setString(1, userid);
					ResultSet rs = ps.executeQuery();
					List<JyOrder> list = new ArrayList<JyOrder>();
					while(rs.next()) {
						JyOrder jy = new JyOrder();
						jy.setId(rs.getString("id"));
						jy.setUserid(rs.getString("userid"));
						jy.setAddress(rs.getString("address"));
						jy.setMoney(rs.getString("money"));
						jy.setUrl(rs.getString("url"));
						jy.setInfo(rs.getString("info"));

						list.add(jy);
					}
					return list;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
			
		}
		
		//查询寄养订单
		public List<JyOrder> resultJyorder(){
			String sql = "select * from jyorder ";		
			try (Connection conn = DBUtils.getConn()){
				try(PreparedStatement ps = conn.prepareStatement(sql)){
					ResultSet rs = ps.executeQuery();
					List<JyOrder> list = new ArrayList<JyOrder>();
					while(rs.next()) {
						JyOrder jy = new JyOrder();
						jy.setId(rs.getString("id"));
						jy.setUserid(rs.getString("userid"));
						jy.setAddress(rs.getString("address"));
						jy.setMoney(rs.getString("money"));
						jy.setUrl(rs.getString("url"));
						jy.setInfo(rs.getString("info"));
						jy.setGetid(rs.getString("getid"));

						list.add(jy);
					}
					return list;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
			
		}
}
