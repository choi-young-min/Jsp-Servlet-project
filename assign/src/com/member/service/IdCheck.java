package com.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.db.MemberDAO;

public class IdCheck implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		//idcheck
		int result = dao.idCheck(id);
		System.out.println(result);
		
		//set
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		
		//setpath
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./idcheck.jsp");
		
		return forward;
	}
}
