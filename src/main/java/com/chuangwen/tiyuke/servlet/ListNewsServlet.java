package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.News;
import db.Dao;

/**
 * Servlet implementation class ListNewsServlet
 */
public class ListNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = new Dao();
		List<News> stu = dao.allNews("newsStu");
		request.setAttribute("stu", stu);
		List<News> pub = dao.allNews("newsPub");
		request.setAttribute("pub", pub);
		List<News> imp = dao.allNews("newsImp");
		request.setAttribute("imp", imp);
		
		// 重定向到newslist.jsp页面
		request.getRequestDispatcher("/newsList.jsp").forward(
				request, response);
	}

}
