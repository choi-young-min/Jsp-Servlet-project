package com.member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.db.ReplyDAO;
import com.assignment.db.ReplyDTO;

public class ReplyInsert implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String id = (String)session.getAttribute("id");
		String content = request.getParameter("reply-content");
		
		ReplyDTO dto = new ReplyDTO();
		dto.setBno(bno);
		dto.setContent(content);
		dto.setW_id(id);
		
		ReplyDAO dao = ReplyDAO.getInstance();
		int result = dao.replyInsert(dto);
		if(result == 1) {
			out.println("<script>");
			out.println("alert('댓글 성공')");
			out.println("</script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./get.go?bno="+bno);
		}else {
			out.println("<script>");
			out.println("alert('댓글 실패')");
			out.println("</script>");	
		}
		return forward;
	}
}
