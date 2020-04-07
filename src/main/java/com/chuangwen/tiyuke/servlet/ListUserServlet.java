package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goods;
import bean.User;
import db.Dao;

/**
 * Servlet implementation class ListUserServlet
 */
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Dao dao = new Dao();
		List<User> list = dao.allUsers();
		
		
		// 将查询出的所有商品放进request域中
					request.setAttribute("list", list);
					// 重定向到list.jsp页面
					request.getRequestDispatcher("/userlist.jsp").forward(
							request, response);
	}

}
