package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Dao;

/**
 * Servlet implementation class AddNews
 */
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String dbname = request.getParameter("dbname");
		String title = request.getParameter("title");
		String auther = request.getParameter("auther");
		String date = request.getParameter("date");
		String info = request.getParameter("info");
		
		Dao dao = new Dao();
		boolean flag = dao.insertNews(title, auther, date, info, dbname);
		if(flag) {
			response.sendRedirect("listNews");
		}else {
			response.getWriter().write("添加失败！！！");
		}
	}

}
