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
 * Servlet implementation class AddOrder
 */
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		String price = request.getParameter("price");
		String address = request.getParameter("address");
		String goodsid = request.getParameter("goodsid");
		String userid = request.getParameter("userid");
		
		Dao dao  = new Dao();
		boolean flag = dao.addOrder(name, num, price, address, goodsid, userid);
		
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
