package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.Chats;
import bean.Goods;
import db.Dao;
import domain.BaseBean;

/**
 * Servlet implementation class ResultChats
 */
public class ResultChats extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String goodsid = request.getParameter("goodsid");
		Dao dao = new Dao();
		
		BaseBean baseBean = new BaseBean();
		List<Chats> list = new ArrayList<>();
		list = dao.resultChat(goodsid);
		if(list.size()>0){
			for(int i=0;i<list.size();i++) {
				Chats chats = new Chats();
				chats.setUserid(list.get(i).getUserid());
				chats.setInfo(list.get(i).getInfo());
				baseBean.setData(chats);
			}
		}else {
			baseBean.setCode("-1");
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		response.getWriter().write(json);
	}

}
