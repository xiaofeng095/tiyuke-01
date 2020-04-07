package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Dao;

/**
 * Servlet implementation class DelGoods
 */
public class DelGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取需要删除的商品id
		String id = request.getParameter("id");
		Dao dao = new Dao();
		
		boolean flag = dao.delgoods(id);
		if(flag) {
			response.sendRedirect("listGoods");
		}else {
			response.getWriter().write("删除失败");
		}
		
	}

}
