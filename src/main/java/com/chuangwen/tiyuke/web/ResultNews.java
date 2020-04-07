package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.News;
import db.Dao;
import domain.BaseBean;
import domain.NewsBean;

/**
 * Servlet implementation class ResultNews
 */
public class ResultNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String dbname = request.getParameter("dbname");
		Dao dao = new Dao();
		
		BaseBean baseBean = new BaseBean();
		List<News> list = new ArrayList<>();
		list = dao.allNews(dbname);
		if(list.size()>0){
			for(int i=0;i<list.size();i++) {
				NewsBean newsbean = new NewsBean();
				newsbean.setTitle(list.get(i).getTitle());
				newsbean.setAuther(list.get(i).getAuther());
				newsbean.setDate(list.get(i).getDate());
				newsbean.setInfo(list.get(i).getInfo());
				baseBean.setData(newsbean);
			}
		}else {
			baseBean.setCode("-1");
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		response.getWriter().write(json);
		
	}

}
