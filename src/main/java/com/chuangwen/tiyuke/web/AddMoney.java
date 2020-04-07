package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.Dao;
import domain.BaseBean;

/**
 * Servlet implementation class AddMoney
 */
public class AddMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String sum = request.getParameter("sum");
		String id = request.getParameter("id");
		
		Dao dao  = new Dao();
		boolean flag = dao.addMoney(sum, id);
		
		Gson gson = new Gson();
		BaseBean baseBean = new BaseBean();
		if(flag) {
			baseBean.setMsg("成功");	
		}else {
			baseBean.setMsg("失败");
		}
		
		String json = gson.toJson(baseBean);
		response.getWriter().write(json);
	}

}
