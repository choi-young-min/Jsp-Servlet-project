package com.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.db.BoardDAO;
import com.assignment.db.BoardDTO;

public class BoardWrite implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String w_id = request.getParameter("id");
		int kind = (int) session.getAttribute("kind");
		
		ActionForward forward = new ActionForward();
		
		
		
		System.out.println(content);
		
		System.out.println(id+"write form 성공");
		System.out.println(content);
		System.out.println(kind);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();
		
		
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setW_id(w_id);
		dto.setKind(kind);
		dao.insertBoard(dto);
		
		
		
		forward.setRedirect(false);
		forward.setPath("/BoardList.go?kind="+kind);
		return forward;
	}

}
