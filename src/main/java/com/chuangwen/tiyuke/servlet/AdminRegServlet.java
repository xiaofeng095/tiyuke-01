package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.Dao;

/**
 * Servlet implementation class AdminRegServlet
 */
public class AdminRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		 if(!password1.equals(password2)) {
			response.getWriter().write("两次密码不一致");
			response.sendRedirect("reg.jsp");
			return;
		}
		
		Dao dao = new Dao();
		
		boolean flag = dao.adminReg(username, password1);
		if(flag) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("home.jsp");
		}else {
			response.getWriter().write("注册失败！！！");
		}
	}

}
