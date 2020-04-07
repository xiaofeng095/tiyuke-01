package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Dao;

/**
 * Servlet implementation class DelChats
 */
public class DelChats extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取需要删除的用户id
		String id = request.getParameter("idchat");
		Dao dao = new Dao();
		
		boolean flag = dao.DelChat(id);
		if(flag) {
			response.sendRedirect("listUser");
		}else {
			response.getWriter().write("删除失败");
		}
	}

}
