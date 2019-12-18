package com.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.db.BoardDAO;
import com.assignment.db.BoardDTO;

public class BoardUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("BoardUpdate �꽌鍮꾩뒪�엫");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String id = (String)session.getAttribute("id");
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		
		System.out.println(id+bno+title+content);
		BoardDTO dto = new BoardDTO();
		dto.setBno(bno);
		dto.setTitle(title);
		dto.setContent(content);
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/get.go?bno="+bno);
		return forward;
	}

}
