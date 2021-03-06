///**
// * 
// */
//package com.gootdate.reply.dao.lhw;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.stereotype.Repository;
//
//import com.gootdate.domain.CSReplyVo;
//import com.mysql.cj.Session;
//
///**
// * @author baekd
// * @packageName: persistence.reply
// * @fileName: ReplyDaoImpl.java
// * @date: 2021. 9. 8.
// * description:
// */
//@Repository
//public class CsReplyDaoImpl implements CsReplyDao {
//	private static String ns="com.gootdate.mapper.replyMapper";
//	@Inject
//	private SqlSession ses;
//	@Override
//	public List<CSReplyVo> replyList(@Param("bno")int bno,@Param("userid") String userid) throws Exception {
//		
//		return ses.selectList(ns+".replyList");
//	}
//
//	@Override
//	public int create(CSReplyVo vo) throws Exception {
//		
//		return ses.insert(ns+".create",vo);
//	}
//
//	@Override
//	public int update(CSReplyVo vo) throws Exception {
//		
//		return ses.update(ns+".modify",vo);
//	}
//
//	@Override
//	public int delete(int no) throws Exception {
//		
//		return ses.delete(ns+".remove",no);
//	}
//
//}
