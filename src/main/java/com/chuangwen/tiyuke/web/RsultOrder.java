package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.Goods;
import bean.Order;
import db.Dao;
import domain.BaseBean;

/**
 * Servlet implementation class RsultOrder
 */
public class RsultOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userid  = request.getParameter("userid");
		Dao dao = new Dao();
		BaseBean baseBean = new BaseBean();
		List<Order> list = new ArrayList<>();
		list = dao.resultOrder(userid);
		if(list.size()>0){
			for(int i=0;i<list.size();i++) {
				Order order = new Order();
				order.setGname(list.get(i).getGname());
				order.setNum(list.get(i).getNum());
				order.setPrice(list.get(i).getPrice());
				order.setAddress(list.get(i).getAddress());
				order.setGoodsid(list.get(i).getGoodsid());
				baseBean.setData(order);
			}
		}else {
			baseBean.setCode("-1");
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		response.getWriter().write(json);
		
		
	}

}
