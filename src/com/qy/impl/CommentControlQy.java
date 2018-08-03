package com.qy.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Comments;
import com.qy.Qy;
import com.service.CommentsService;
import com.service.imp.CommentsServiceImp;

public class CommentControlQy implements Qy {
		@Override
		public void qyDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//跳转到commentcontrol页面
		PrintWriter out = response.getWriter();
		CommentsService commentsService = new CommentsServiceImp();
		//评论的添加删除
		String choice = request.getParameter("choice");
		if(choice != null) {
		if(choice.equals("commentAdd")) {
		Integer cnid = Integer.parseInt(request.getParameter("cnid"));
		Date cdate = new Date();
		String cip = request.getParameter("cip");
		String cauthor = request.getParameter("cauthor");
		String ccontent = request.getParameter("ccontent");
		//赋值
		Comments comment = new Comments();
		comment.setCnid(cnid);
		comment.setCdate(cdate);
		comment.setCip(cip);
		comment.setCauthor(cauthor);
		comment.setCcontent(ccontent);
		int result = commentsService.addComment(comment);
		if(result == 0) {
			out.println("<script type='text/javascript'>alert('提交评论失败');location.href='NewServlet?jsp=newsread&nid=" + cnid + "';</script>");
		} else {
			out.println("<script type='text/javascript'>alert('提交评论成功');location.href='NewServlet?jsp=newsread&nid=" + cnid + "';</script>");
		}
		}else if(choice.equals("commentDel")) {
		Integer cid = Integer.parseInt(request.getParameter("cid"));
		int cnid = commentsService.findByLine("cid", cid, 0).get(0).getCnid();
		int result = commentsService.delComment(cid);
		if(result == 0) {
			out.println("<script type='text/javascript'>alert('删除评论失败');location.href='NewServlet?jsp=newsread&nid=" + cnid + "';</script>");
		} else {
			out.println("<script type='text/javascript'>alert('删除评论成功');location.href='NewServlet?jsp=newsread&nid=" + cnid + "';</script>");
		}
		}}
	}
}
