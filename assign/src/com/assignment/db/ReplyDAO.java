package com.assignment.db;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReplyDAO {
	private SqlSession session;
	
	// 싱글톤
	private static ReplyDAO instance = new ReplyDAO();
	private ReplyDAO(){}
	public static ReplyDAO getInstance(){
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
	
	public int replyInsert(ReplyDTO dto) {
		int result = 0;
		try {
			session = getSession();
			result = session.insert("reply.reply_insert",dto);
		} catch (Exception e) {
			System.out.println("댓글 예외 : "+e.getMessage());
		}
		return result;
	}
	public float getReplyCount(int bno) {
		float result = 0;
		try {
			session = getSession();
			result = (float) session.selectOne("reply.reply_count",bno);
		} catch (Exception e) {
			System.out.println("댓글 갯수:" + e.getMessage());
		}
		return result;
	}
	
	public List<ReplyDTO> getReply(int bno, int start, int cnt){
		List<ReplyDTO> list = new ArrayList<ReplyDTO>();
		try {
			Map<String,Integer> map = new HashMap<String, Integer>();
			map.put("bno", bno);
			map.put("start", start);
			map.put("cnt", cnt);
			
			session = getSession();
			list = (ArrayList<ReplyDTO>)session.selectList("reply.get_reply",map);
		} catch (Exception e) {
			System.out.println("댓글 출력 : "+e.getMessage());
		}
		return list;
	}

}
