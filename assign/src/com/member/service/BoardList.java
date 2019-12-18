package com.member.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.db.BoardDAO;
import com.assignment.db.BoardDTO;

public class BoardList implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardList");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ActionForward forward = null;
		
		System.out.println(id+"dggd");
		if(id!=null) {
			BoardDAO manager = BoardDAO.getInstance();
			int kind=Integer.parseInt(request.getParameter("kind"));
			session.setAttribute("kind", kind);
			List<BoardDTO> list = null;
			list = manager.getList(kind);
			session.setAttribute("id", id);
			// 뷰페이지로 공유할 값 설정
			request.setAttribute("list", list);
			request.setAttribute("kind", kind);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./index.jsp");
			
		}else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/index.go");
			System.err.println("잘못된 접근입니다.");
		}
		

		return forward;
	}
	
}
