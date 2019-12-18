package com.member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.db.MemberDAO;
import com.assignment.db.MemberDTO;

public class MemberJoin implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberJoin");
		// out 객체에서 사용할 타입
		response.setContentType("text/html;charset=utf-8");
		// out  객체 생성
		PrintWriter out=response.getWriter();
		// post 방식으로 넘어오는 데이터의 인코딩 타입 설정
		request.setCharacterEncoding("utf-8");
		// 폼에서 넘어온 id값 저장
		String id = request.getParameter("id");
		// DAO 객체 생성
		MemberDAO manager = MemberDAO.getInstance();
		// 아이디 중복검사
		
		// 동일한 id가 없으면 DTO 객체에 값을 저장하여 DAO로 전달
		MemberDTO member = new MemberDTO();
		System.out.println(request.getParameter("id"));
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		manager.memberJoin(member);
		
		// 포워딩 방식 및 경로 설정
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./index.go");
		
		return forward;
	}
}
