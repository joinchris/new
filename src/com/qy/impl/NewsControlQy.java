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
		//��ת��newscontrolҳ��
		NewsService newsService = new NewsServiceImp();
		PrintWriter out = response.getWriter();
		String choice = request.getParameter("choice");
		if(choice.equals("newModify")) {
			String fieldName = "";//�����յ�name
			News news = new News();
			Date date = new Date();
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);//�ж��Ƿ����ļ��ֶ�
			//�����ļ��ϴ��Ĵ洢·��
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			if(isMultipart) {
				//��������
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);//�����ܹ���ȡ���в����Ķ���
				try{
					List<FileItem> items = upload.parseRequest(request);//�������еı�
					Iterator<FileItem> iter = items.iterator();//����,����ÿһ�����յ��ļ�
					while(iter.hasNext()) {
						FileItem item = (FileItem)iter.next();
						if(item.isFormField()) {//�ж��Ƿ���ͨ��
							fieldName = item.getFieldName();//��ȡÿһ��name��ֵ,�洢name��Ӧ��ֵ
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
						}else {//������ļ�
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH);
							int day = now.get(Calendar.DAY_OF_YEAR);
							String number = "" + year + month + day;
							for(int i = 0; i < 5; i++) {
	  							int num = (int)(Math.random()*10);
	  							number = number + num;
	  						}
							//��ȡ��ʽ
							fieldName = item.getName();
							if(fieldName != null && !fieldName.equals("")) {
								String fileLast = fieldName.substring(fieldName.lastIndexOf("."));
								String fullFile = number + fileLast;
								//�����ļ�
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
				out.println("<script type='text/javascript'>alert('�޸�ʧ��');location.href='NewServlet?jsp=adminjsp';</script>");
	    	} else {
	    		out.println("<script type='text/javascript'>alert('�޸ĳɹ�');location.href='NewServlet?jsp=adminjsp';</script>");
	    	}
			}else if(choice.equals("newDel")) {
			Integer nid = Integer.parseInt(request.getParameter("nid"));
    		int result = newsService.delNew(nid);
			if(result == 0) {
				out.println("<script type='text/javascript'>alert('ɾ��ʧ��');location.href='NewServlet?jsp=adminjsp';</script>");
	    	} else {
	    		out.println("<script type='text/javascript'>alert('ɾ���ɹ�');location.href='NewServlet?jsp=adminjsp';</script>");
	    	}
		}else if(choice.equals("newAdd")) {
    		String fieldName = "";     //���ֶ�Ԫ�ص�name����ֵs
    		News news = new News();
    		Date date = new Date();
    		//�ж�������Ϣ�е������ǲ���multipart����
    		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    		//�ϴ��ļ��Ĵ洢·��
    		String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");   
    		if(isMultipart) {
    			FileItemFactory factory = new DiskFileItemFactory();
    			ServletFileUpload upload = new ServletFileUpload(factory);
    			try{
    				//����form���е������ļ�
    				List<FileItem> items = upload.parseRequest(request);
    				Iterator<FileItem> iter = items.iterator();
    				while(iter.hasNext()) {	//ѭ������ÿ���ļ�
    					FileItem item = (FileItem)iter.next();
    					if(item.isFormField()) {	//��ͨ���ֶ�
    							fieldName = item.getFieldName();	//���ֶε�name����ֵ
    							String fieldValue = item.getString("UTF-8");
    							//��ȡ��ǰʱ��
    							//�ڶ���������Ҫ��ӵĶ������������Ŷ���,����������ݴ��������ȥ
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
    						//�����������ռ������
    						Calendar now = Calendar.getInstance();
  							int year = now.get(Calendar.YEAR);
  							int month = now.get(Calendar.MONTH);
  							int day = now.get(Calendar.DAY_OF_MONTH);
  							String number = "" + year + month + day;
  							for(int i = 0; i < 5; i++) {
  							int num = (int)(Math.random()*10);
  							number = number + num;
  							}
    						//�ļ����ֶ�
  							fieldName = item.getName();
    						if(fieldName != null && !fieldName.equals("")) {
    						//�����֡���ȡ���һ��.�ĺ��漸λ��ȷ����ʽ
    						String fileLast = fieldName.substring(fieldName.lastIndexOf("."));
    						String fullFile = number + fileLast;//���ļ���
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
    		//��������ʵ����Ӳ��ж��Ƿ���ӳɹ�
	    	int result = newsService.addnew(news);
			if(result == 0) {
				out.println("<script type='text/javascript'>alert('���ʧ��');location.href='NewServlet?jsp=adminjsp';</script>");
	    	} else {
	    		out.println("<script type='text/javascript'>alert('��ӳɹ�');location.href='NewServlet?jsp=adminjsp';</script>");
	    	}
		}
	}
}
