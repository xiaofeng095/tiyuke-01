package web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

import db.Dao;
import domain.BaseBean;

/**
 * Servlet implementation class UploadImage
 */
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String encodedImageStr = request.getParameter("image");
		String fileName = request.getParameter("filename");//图片url
		String userid = request.getParameter("userid");
		String address = request.getParameter("address");
		String money = request.getParameter("money");
		String info = request.getParameter("info");
		
		try {
			   // Base64解码图片
			   byte[] imageByteArray = Base64.decodeBase64(encodedImageStr);
			 
			   //
			   FileOutputStream imageOutFile = new FileOutputStream("/Users/xuxiaofeng/apache-tomcat-7.0.93/images" + fileName+".jpg");
			   imageOutFile.write(imageByteArray);
			   imageOutFile.close();
			 
			   System.out.println("Image Successfully Stored");
			   
			   Dao dao = new Dao();
			   Gson gson = new Gson();
				BaseBean baseBean = new BaseBean();
			   int flag = dao.insertJY(fileName,userid,  address,money, fileName+".jpg", info);
			   if(flag>0) {
				   baseBean.setMsg("成功");	 
			   }else {
				   baseBean.setMsg("失败");
			   }
			   
			   String json = gson.toJson(baseBean);
				response.getWriter().write(json);
				
				
			  } catch (FileNotFoundException fnfe) {
			   System.out.println("Image Path not found" + fnfe);
			  } catch (IOException ioe) {
			   System.out.println("Exception while converting the Image " + ioe);
			  }
		
		
	}

}
