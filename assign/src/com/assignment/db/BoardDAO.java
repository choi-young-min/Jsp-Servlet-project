package com.assignment.db;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class BoardDAO {
	private SqlSession session;
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	// myBatis
	private SqlSession getSession() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("./SqlMapConfig.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
			session = sf.openSession(true);
		} catch (IOException e) {
			System.out.println("getSession 에러 : " + e);
			e.printStackTrace();
		}
		return session;
	}

	// 해당 section 페이징 처리
	public List<BoardDTO> getList(int kind) {
		List<BoardDTO> list = null;
		try {
			session = getSession();
			System.out.println("야야야");
			list = (ArrayList<BoardDTO>)session.selectList("BoardDTO.board_list",kind);
		} catch (Exception e) {
			System.out.println("getList 에러 : " + e);
			e.printStackTrace();
		}
		return list;
	}
	
	public BoardDTO getboard(int bno) {
		BoardDTO dto = null;
		try {
			session = getSession();
			dto = (BoardDTO)session.selectOne("BoardDTO.board_get",bno);
		} catch (Exception e) {
			System.out.println("getBoard 에러 : "+e.getMessage());
		}
		return dto;
	}
	
	public void insertBoard(BoardDTO dto) {
		try {
			session = getSession();
			session.selectOne("BoardDTO.board_insert",dto);
		} catch (Exception e) {e.printStackTrace();}
	}
	
	public void updateBoard(BoardDTO dto) {
		try {
			session = getSession();
			session.selectOne("BoardDTO.board_update",dto);
		} catch (Exception e) {
			System.out.println("업데이트 에러 : "+e.getMessage());
		}
	}
	
	public int deleteBoard(int bno) {
		int result = 0; 
		try {
			session = getSession();
			result = session.delete("BoardDTO.board_delete",bno);
		} catch (Exception e) {
			System.out.println("게시물 삭제 예외 : "+e.getMessage());
		}
		return result;
	}
}
