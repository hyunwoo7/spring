package com.gootdate.cs.service.lhw;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.naming.NamingException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.gootdate.cs.dao.lhw.CsDAO;
import com.gootdate.domain.CSLikeVo;
import com.gootdate.domain.CSVo;
import com.gootdate.domain.PagingInfoDTO;


@Service
public class CsServiceImpl implements CsService {
	@Inject
	private CsDAO dao;

	@Override
	public boolean addBoard(CSVo bo) throws NamingException, SQLException {

		int result = dao.insertCSVo(bo);

		if (result == 1) { // 글쓰기 정상
			return true;

		} else {
			return false;
		}

	}

	@Override
	public Map<String, Object> readAllBoard(int pageNo) throws NamingException, SQLException {
		PagingInfoDTO pi = pagingProcess(pageNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardList", dao.selectAllBoard(pi));
		map.put("pagingInfo", pi);
		return map;
	}


	@Override
	public List<CSVo> getList(CSVo vo) throws NamingException, SQLException {
//		PagingInfoDTO pi = pagingProcesstmp(pageno);	
		return  dao.getList(vo);
		
	}
	// 페이징을 위한 처리 작업 전담 메서드
	private PagingInfoDTO pagingProcess(int pageNo) throws NamingException, SQLException {
		PagingInfoDTO pi = new PagingInfoDTO();

		pi.setStartNum(pageNo); // 출력 시작할 번호
		int totalPost = 0;

		totalPost = dao.selectCntPost(); // 전체 글 수를 얻음

		pi.setTotalPage(totalPost); // 전체 페이지 수
		pi.setCurrentPagingBlock(pageNo); // 현재 페이지블록

		pi.setStartPageNoOfBlock(pi.getCurrentPagingBlock());// 시작페이지 블록
		pi.setEndPageNoOfBlock(pi.getStartPageNoOfBlock());// 끝페이지 블록
		pi.setTotalPagingBlockCnt(pi.getTotalPage());// 페이지블록 개수

		return pi;
	}
	private PagingInfoDTO pagingProcesstmp(int pageNo) throws NamingException, SQLException {
		PagingInfoDTO pi = new PagingInfoDTO();

		pi.setStartNum(pageNo); // 출력 시작할 번호
		int totalPost = 0;

		totalPost = dao.selectCntPost(); // 전체 글 수를 얻음

		pi.setTotalPage(totalPost); // 전체 페이지 수
		pi.setCurrentPagingBlock(pageNo); // 현재 페이지블록

		pi.setStartPageNoOfBlock(pi.getCurrentPagingBlock());// 시작페이지 블록
		pi.setEndPageNoOfBlock(pi.getStartPageNoOfBlock());// 끝페이지 블록
		pi.setTotalPagingBlockCnt(pi.getTotalPage());// 페이지블록 개수

		return pi;
	}
	@Transactional(isolation = Isolation.READ_COMMITTED) // 조회수 업데이트 문이 커밋된 데이터에 한해 셀렉트되도록 격리 레벨을 올림
	@Override
	public CSVo readBoard(int no) throws NamingException, SQLException {
		// 하루에 한번 증가시키는거 아이피주소로하는거 jsp할때 했었음 그거참고하자

		dao.updateCs(no);
		CSVo vo = dao.selectBoard(no);

		return vo;
	}

	@Override
	public void deleteBoard(int bno) {
		dao.deleteBoard(bno);

	}

//좋아요 정보받아오기
	@Override
	public CSLikeVo getCSLikeVo(CSLikeVo vo) {
		// TODO Auto-generated method stub
		return dao.getCSLikeVo(vo);
	}

	@Override
	public int countLikes(CSLikeVo vo) {
		// TODO Auto-generated method stub
		return dao.countLikes(vo);
	}

	@Override
	public int countDisLikes(CSLikeVo vo) {
		// TODO Auto-generated method stub
		return dao.countDisLikes(vo);
	}

//좋아요 status 바꾸기
	@Override
	public void makeLikeTo1(CSLikeVo vo) {
		// TODO Auto-generated method stub
		dao.makeLikeTo1(vo);
	}

	@Override
	public void makeLikeToMinus1(CSLikeVo vo) {
		// TODO Auto-generated method stub
		dao.makeLikeToMinus1(vo);
	}

//좋아요 삭제
	@Override
	public void deleteLike(CSLikeVo vo) {
		// TODO Auto-generated method stub
		dao.deleteLike(vo);
	}

//좋아요 
	@Override
	public void insertLike(CSLikeVo vo) {
		// TODO Auto-generated method stub
		dao.inserLike(vo);
	}

	@Override
	public void processCs(CSLikeVo vo) {
		// TODO Auto-generated method stub
		dao.processCs(vo);
	}

	@Override
	public void editBoard(CSVo vo) {
		// TODO Auto-generated method stub
		dao.editBoard(vo);
	}



}
