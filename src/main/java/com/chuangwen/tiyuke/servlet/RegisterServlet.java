package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.Dao;
import domain.BaseBean;
import domain.UserBean;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		Dao dao = new Dao();
		String flag = dao.register(nickname, pwd);
		
		String suc = flag.split(":")[0];
		String id = flag.split(":")[1];
		
		BaseBean data = new BaseBean();
		data.setCode(suc);
		data.setData(id);
		data.setMsg("注册");
		Gson gson = new Gson();
		String json = gson.toJson(data);
		
		response.getWriter().write(json);
	}

}
