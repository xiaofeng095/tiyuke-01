package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.Goods;
import bean.News;
import db.Dao;
import domain.BaseBean;
import domain.NewsBean;

/**
 * Servlet implementation class ResultGoods
 */
public class ResultGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String other = request.getParameter("other");
			Dao dao = new Dao();
			
			BaseBean baseBean = new BaseBean();
			List<Goods> list = new ArrayList<>();
			list = dao.resultGoods(other);
			if(list.size()>0){
				for(int i=0;i<list.size();i++) {
					Goods goods = new Goods();
					goods.setId(list.get(i).getId());
					goods.setName(list.get(i).getName());
					goods.setPrice(list.get(i).getPrice());
					goods.setNum(list.get(i).getNum());
					goods.setUrl(list.get(i).getUrl());
					baseBean.setData(goods);
				}
			}else {
				baseBean.setCode("-1");
			}
			Gson gson = new Gson();
			String json = gson.toJson(list);
			
			response.getWriter().write(json);
	}

}
