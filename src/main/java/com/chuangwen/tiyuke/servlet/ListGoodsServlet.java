package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goods;
import db.Dao;

/**
 * Servlet implementation class ListGoodsServlet
 */
public class ListGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = new Dao();
		List<Goods> list = dao.allGoods();
		
		
		// 将查询出的所有商品放进request域中
					request.setAttribute("list", list);
					// 重定向到list.jsp页面
					request.getRequestDispatcher("/list.jsp").forward(
							request, response);
	}

}
