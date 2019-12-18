package com.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.db.MemberDAO;
import com.assignment.db.MemberDTO;

public class LoginMember implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "./login_fail.jsp";
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("loginid");
		String pwd = request.getParameter("loginpwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.memberLogin(id);
		session.setAttribute("id", id);
		session.setAttribute("dto", dto);
		
		request.setAttribute("dto", dto);
		if(dto!=null) {
			if(dto.getPwd().equals(pwd)) {
				url = "./home.jsp";
				forward.setPath(url);
			}
		}
		forward.setPath(url);
		return forward;
	}
}