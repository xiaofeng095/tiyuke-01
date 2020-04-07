package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Dao;

/**
 * Servlet implementation class DelNews
 */
public class DelNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String dbname = request.getParameter("dbname");
		
		Dao dao = new Dao();
		boolean flag = dao.delNews(dbname, id);
		if(flag) {
			response.sendRedirect("listNews");
		}else {
			response.getWriter().write("删除失败！！！");
		}
	}

}
