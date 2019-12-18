package com.assignment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.service.Action;
import com.member.service.ActionForward;
import com.member.service.BoardContent;
import com.member.service.BoardDelete;
import com.member.service.BoardList;
import com.member.service.BoardUpdate;
import com.member.service.BoardWrite;
import com.member.service.IdCheck;
import com.member.service.LoginMember;
import com.member.service.LogoutMember;
import com.member.service.MemberJoin;
import com.member.service.ReplyInsert;

@WebServlet("*.go")
public class Controller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 실행");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메서드 실행");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("requestURI : " + requestURI);
		System.out.println("contextPath : " + contextPath);
		System.out.println("command : " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 회원가입 폼
		if (command.equals("/MemberJoinForm.go")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/memberJoinForm.jsp");
		}
		// 회원 가입
		else if (command.equals("/MemberJoin.go")) {
			try {
				action = new MemberJoin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 아이디 중복 확인
		else if (command.equals("/idCheck.go")) {
			try {
				action = new IdCheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// index 
		else if (command.equals("/index.go")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./home.jsp");
		}
		// 게시판 목록
		else if (command.equals("/BoardList.go")) {
			try {
				action = new BoardList();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//게시판 리스트 이동
		else if (command.equals("/get.go")) {
			try {
				action = new BoardContent();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//댓글 달기
		else if (command.equals("/replyinsert.go")) {
			try {
				action = new ReplyInsert();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//로그인
		else if (command.equals("/Login.go")) {
			try {
				action = new LoginMember();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//로그아웃
		else if (command.equals("/Logout.go")) {
			try {
				action = new LogoutMember();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//게시물 작성
		else if (command.equals("/addboard.go")) {
			try { 
				action = new BoardWrite();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//게시물 수정 페이지
		/*
		 * else if(command.equals("/update.go")) { try { action = new Update(); forward
		 * = action.execute(request,response); } catch (Exception e) {
		 * e.printStackTrace(); } }
		 */
		//게시물 수정
		else if (command.equals("/UpdateBoard.go")) {
			try {
				action = new BoardUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//
		//게시물 삭제
		else if (command.equals("/deleteboard.go")) {
			try {
				System.out.println("delete 컨트롤러 도착");
				action = new BoardDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 페이지 이동
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
}
