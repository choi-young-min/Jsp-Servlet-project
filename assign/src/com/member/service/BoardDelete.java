package com.member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.db.BoardDAO;

public class BoardDelete implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ActionForward forward = null;
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println(bno);
		int kind = (int)session.getAttribute("kind");
		System.out.println(kind);
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.deleteBoard(bno);
		if(result == 1) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./BoardList.go?kind="+kind);
			out.println("<script>");
			out.println("alert('success')");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('fail')");
			out.println("</script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./BoardList.go?kind="+kind);
		}
		return forward;
	}
}
