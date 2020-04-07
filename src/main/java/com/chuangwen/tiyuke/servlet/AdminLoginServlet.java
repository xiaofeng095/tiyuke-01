package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.Dao;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Dao dao = new Dao();
		
		boolean flag = dao.adminLogin(username, password);
		if(flag) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("home.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
