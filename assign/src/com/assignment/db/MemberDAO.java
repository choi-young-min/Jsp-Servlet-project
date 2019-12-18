package com.assignment.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private SqlSession session;
	
	// 싱글톤
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO(){}
	public static MemberDAO getInstance(){
		return instance;
	}
	
	// myBatis
	private SqlSession getSession() {
		Reader reader=null;
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
	
	// 회원 가입
	public void memberJoin(MemberDTO member){
		try {
			session = getSession();
			session.insert("member.member_insert", member);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberJoin 에러 : " + e);
		}
	}
	
	//로그인
	public MemberDTO memberLogin(String id) {
		MemberDTO vo = null;
		try {
		session = getSession();
		vo = (MemberDTO)session.selectOne("member.member_login",id);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public int idCheck(String id) {
		int result = 0;
		try {
			session= getSession();
			System.out.println("dao"+ id);
			result = (int) session.selectOne("member.member_confimId",id);
			System.out.println("DAO"+result);
		} catch (Exception e) {
			System.out.println("idcheck 에러" + e.getMessage());
		}
		return result;
	}
}
