package com.qy.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.entity.News;
import com.qy.Qy;
import com.service.NewsService;
import com.service.imp.NewsServiceImp;

public class NewsControlQy implements Qy{
	@Override
	public void qyDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//跳转到newscontrol页面
		NewsService newsService = new NewsServiceImp();
		PrintWriter out = response.getWriter();
		String choice = request.getParameter("choice");
		if(choice.equals("newModify")) {
			String fieldName = "";//表单接收的name
			News news = new News();
			Date date = new Date();
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);//判断是否含有文件字段
			//创建文件上传的存储路径
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			if(isMultipart) {
				//创建工厂
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);//创建能够获取所有参数的对象
				try{
					List<FileItem> items = upload.parseRequest(request);//集合所有的表单
					Iterator<FileItem> iter = items.iterator();//迭代,处理每一个接收的文件
					while(iter.hasNext()) {
						FileItem item = (FileItem)iter.next();
						if(item.isFormField()) {//判断是否普通表单
							fieldName = item.getFieldName();//获取每一个name的值,存储name对应的值
							String fieldValue = item.getString("UTF-8");
							news.setNmodifyDate(date);
							if(fieldName.equals("nid")) {
								Integer nid = Integer.parseInt(fieldValue);
								news = newsService.findByLine("nid", nid, 1).get(0);
								news.setNid(Integer.parseInt(fieldValue));
							}else if(fieldName.equals("ntid")) {
								news.setNtid(Integer.parseInt(fieldValue));
							}else if(fieldName.equals("ntitle")) {
								news.setNtitle(fieldValue);
							}else if(fieldName.equals("nauthor")) {
								news.setNauthor(fieldValue);
							}else if(fieldName.equals("nsummary")) {
								news.setNsummary(fieldValue);
							}else if(fieldName.equals("ncontent")) {
								news.setNcontent(fieldValue);
							}
						}else {//如果是文件
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH);
							int day = now.get(Calendar.DAY_OF_YEAR);
							String number = "" + year + month + day;
							for(int i = 0; i < 5; i++) {
	  							int num = (int)(Math.random()*10);
	  							number = number + num;
	  						}
							//截取格式
							fieldName = item.getName();
							if(fieldName != null && !fieldName.equals("")) {
								String fileLast = fieldName.substring(fieldName.lastIndexOf("."));
								String fullFile = number + fileLast;
								//保存文件
								File saveFile = new File(uploadFilePath, fullFile);
								item.write(saveFile);
								news.setNpicPath(fullFile);
							}
						}
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			int result = newsService.updateNew(news);
	    	if(result == 0) {
				out.println("<script type='text/javascript'>alert('修改失败');location.href='NewServlet?jsp=adminjsp';</script>");
	    	} else {
	    		out.println("<script type='text/javascript'>alert('修改成功');location.href='NewServlet?jsp=adminjsp';</script>");
	    	}
			}else if(choice.equals("newDel")) {
			Integer nid = Integer.parseInt(request.getParameter("nid"));
    		int result = newsService.delNew(nid);
			if(result == 0) {
				out.println("<script type='text/javascript'>alert('删除失败');location.href='NewServlet?jsp=adminjsp';</script>");
	    	} else {
	    		out.println("<script type='text/javascript'>alert('删除成功');location.href='NewServlet?jsp=adminjsp';</script>");
	    	}
		}else if(choice.equals("newAdd")) {
    		String fieldName = "";     //表单字段元素的name属性值s
    		News news = new News();
    		Date date = new Date();
    		//判断请求信息中的内容是不是multipart类型
    		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    		//上传文件的存储路径
    		String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");   
    		if(isMultipart) {
    			FileItemFactory factory = new DiskFileItemFactory();
    			ServletFileUpload upload = new ServletFileUpload(factory);
    			try{
    				//解析form表单中的所有文件
    				List<FileItem> items = upload.parseRequest(request);
    				Iterator<FileItem> iter = items.iterator();
    				while(iter.hasNext()) {	//循环处理每个文件
    					FileItem item = (FileItem)iter.next();
    					if(item.isFormField()) {	//普通表单字段
    							fieldName = item.getFieldName();	//表单字段的name属性值
    							String fieldValue = item.getString("UTF-8");
    							//获取当前时间
    							//第二步：创建要添加的对象，这里是新闻对象,并且添加内容大对象里面去
    							news.setNcreateDate(date);
    							news.setNmodifyDate(date);
    							if(fieldName.equals("ntid")) {
    								news.setNtid(Integer.parseInt(fieldValue));
    							}else if(fieldName.equals("ntitle")) {
    								news.setNtitle(fieldValue);
    							}else if(fieldName.equals("nauthor")) {
    								news.setNauthor(fieldValue);
    							}else if(fieldName.equals("nsummary")) {
    								news.setNsummary(fieldValue);
    							}else if(fieldName.equals("ncontent")) {
    								news.setNcontent(fieldValue);
    							}
    					}else {
    						//命名：年月日加随机数
    						Calendar now = Calendar.getInstance();
  							int year = now.get(Calendar.YEAR);
  							int month = now.get(Calendar.MONTH);
  							int day = now.get(Calendar.DAY_OF_MONTH);
  							String number = "" + year + month + day;
  							for(int i = 0; i < 5; i++) {
  							int num = (int)(Math.random()*10);
  							number = number + num;
  							}
    						//文件表单字段
  							fieldName = item.getName();
    						if(fieldName != null && !fieldName.equals("")) {
    						//新名字。截取最后一个.的后面几位。确保格式
    						String fileLast = fieldName.substring(fieldName.lastIndexOf("."));
    						String fullFile = number + fileLast;//新文件名
    						File saveFile = new File(uploadFilePath,fullFile);
    						item.write(saveFile);
    						news.setNpicPath(fullFile);
    						}
    					}
    				}
    			}catch(Exception e) {
    				e.printStackTrace();
    			}
    		}
    		//第三步：实现添加并判断是否添加成功
	    	int result = newsService.addnew(news);
			if(result == 0) {
				out.println("<script type='text/javascript'>alert('添加失败');location.href='NewServlet?jsp=adminjsp';</script>");
	    	} else {
	    		out.println("<script type='text/javascript'>alert('添加成功');location.href='NewServlet?jsp=adminjsp';</script>");
	    	}
		}
	}
}
