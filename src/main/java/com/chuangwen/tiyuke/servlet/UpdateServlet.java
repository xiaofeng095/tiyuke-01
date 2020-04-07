package servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import db.Dao;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//用来保存提交数据
		Map<String, String> map = new HashMap<String, String>();
		//存储图片访问地址
		 String url=null;
		//图片保存路径
		String path = "/Users/xuxiaofeng/apache-tomcat-7.0.93/images";
		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024);
		  ServletFileUpload upload = new ServletFileUpload(factory);
		// 中文处理
	        upload.setHeaderEncoding("UTF-8"); 

	        try {
	            // 解析请求的内容提取文件数据
	            @SuppressWarnings("unchecked")
	            List<FileItem> formItems = upload.parseRequest(request);
	            System.out.println("formitems:"+formItems);
	            if (formItems != null && formItems.size() > 0) {	
	                // 迭代表单数据
	                for (FileItem item : formItems) {
	                    // 处理不在表单中的字段
	                    if (!item.isFormField()) {
	                    	//上传图片文件名
	                        String fileName = new File(item.getName()).getName();
	                 
	                        
	                        //设置图片访问路径
	                        url = "http://localhost:8080/images/"+fileName;
	                        
	                        System.out.println("filename:"+fileName);
	                        String filePath = path + File.separator + fileName;
	                        System.out.println("filepath:"+filePath);
	                        File storeFile = new File(filePath);
	                        // 在控制台输出文件的上传路径
	                        System.out.println(filePath);
	                        // 保存文件到硬盘
	                        item.write(storeFile);
	                    
	                        request.setAttribute("message",
	                            "文件上传成功!");
	                    }else {
	                    	// 不是上传组件
	    					String fieldName = item.getFieldName(); // 获取组件名称
	    					String value = item.getString("utf-8"); // 解决乱码问题
	    					map.put(fieldName, value);
	    					
	                    }
	                }
	                
	                Dao dao = new Dao();
	         
	                int i  = dao.updateGoods(map.get("id"), url, map.get("name"), map.get("price"), map.get("num"), map.get("other"));
	                if(i>0) {
	                	System.out.println("添加成功");
	                	request.setAttribute("message", "添加成功");
	                	response.sendRedirect("listGoods");
	                }else {
	                	
	                	System.out.println("添加失败");
	                	request.setAttribute("message", "添加失败");
	                }
	                System.out.println("id:"+map.get("id"));
					System.out.println("name:"+map.get("name"));
					System.out.println("price:"+map.get("price"));
					System.out.println("num:"+map.get("num"));
					System.out.println("other:"+map.get("other"));
	                }else {
	                	response.getWriter().write("商品编号已存在！！！");
	                }
	                
	            
	        } catch (Exception ex) {
	            request.setAttribute("message",
	                    "错误信息: " + ex.getMessage());
	        }
	}

}
