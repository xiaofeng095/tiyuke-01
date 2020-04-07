package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Dao;

/**
 * Servlet implementation class DelUser
 */
public class DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取需要删除的用户id
		String id = request.getParameter("id");
		Dao dao = new Dao();
		
		boolean flag = dao.delUser(id);
		if(flag) {
			response.sendRedirect("listUser");
		}else {
			response.getWriter().write("删除失败");
		}
	}

}
