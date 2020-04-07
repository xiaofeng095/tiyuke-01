package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.Order;
import db.Dao;
import domain.BaseBean;

/**
 * Servlet implementation class OrderList
 */
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		Dao dao = new Dao();
		List<Order> list = new ArrayList<>();
		//list = dao.resultOrderList();
		

		// 将查询出的所有商品放进request域中
					request.setAttribute("list", list);
					// 重定向到list.jsp页面
					request.getRequestDispatcher("/orderlist.jsp").forward(
							request, response);
	
		
	}

}
