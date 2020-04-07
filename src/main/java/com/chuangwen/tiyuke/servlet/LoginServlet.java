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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		BaseBean data = new BaseBean();
		UserBean userBean = new UserBean();
		Dao dao = new Dao();
		if(dao.login(id, pwd)) {
			data.setCode("0");
			userBean.setId(id);
			userBean.setUsername(Dao.username);
			userBean.setMoney(Dao.money);
			data.setData(userBean);
			
			data.setMsg("登陆成功");
		}else {
			data.setCode("-1");
			data.setData(id);
			data.setMsg("登陆失败");
		}
		Gson gson = new Gson();
		String json = gson.toJson(data);
		
		try {
			response.getWriter().write(json);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
