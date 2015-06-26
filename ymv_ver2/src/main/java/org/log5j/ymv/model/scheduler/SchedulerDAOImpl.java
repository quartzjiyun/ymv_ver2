package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class SchedulerDAOImpl implements SchedulerDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> getSchedulerList(SchedulerVO sdvo) {
		System.out.println("DAO Scheduler"+sdvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("scheduler.getSchedulerList",sdvo);
		return list;
	}
	@Override
	public List<BoardVO> getSearchList(SearchVO scvo) {
		System.out.println("DAO Search"+scvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("scheduler.getSearchList",scvo);
		return list;
	}

	@Override
	public int totalContent(SearchVO scvo) {
		return sqlSessionTemplate.selectOne("scheduler.totalContent",scvo);
	}
	@Override
	public List<HashMap> getDateList(SchedulerVO sdvo) {
		return sqlSessionTemplate.selectList("scheduler.getDateList",sdvo);
	}
	@Override
	public SchedulerVO schedulerCheck(String memberNo) {
		
		return sqlSessionTemplate.selectOne("scheduler.schedulerCheck",memberNo);
	}
	@Override
	public void registerScheduler(SchedulerVO sdvo) {
		sqlSessionTemplate.insert("scheduler.registerScheduler",sdvo);
	}
	@Override
	public void updateScheduler(SchedulerVO sdvo) {
		sqlSessionTemplate.update("scheduler.updateScheduler",sdvo);
	}

	@Override
	public List<BoardVO> getRecruitBoardList(SearchBoardVO sebvo) {
		List<BoardVO> list =  sqlSessionTemplate.selectList("search.getRecruitBoardList",sebvo);
		return list;
	}
	@Override
	public int getRecruitTotalContent(String search) {
		return sqlSessionTemplate.selectOne("search.getRecruitTotalContent",search);
	}
	@Override
	public List<BoardVO> getNoticeBoardList(SearchBoardVO sebvo) {
		return sqlSessionTemplate.selectList("search.getNoticeBoardList",sebvo);
	}
	@Override
	public int getNoticeBoardTotalContent(String search) {
		return sqlSessionTemplate.selectOne("search.getNoticeBoardTotalContent",search);
	}
	@Override
	public List<BoardVO> getReviewBoardList(SearchBoardVO sebvo) {
		return sqlSessionTemplate.selectList("search.getReviewBoardList",sebvo);
	}
	@Override
	public int getReviewBoardTotalContent(String search) {
		return sqlSessionTemplate.selectOne("search.getReviewBoardTotalContent",search);
	}
	@Override
	public List<BoardVO> getQnABoardList(SearchBoardVO sebvo) {
		return sqlSessionTemplate.selectList("search.getQnABoardList",sebvo);
	}
	@Override
	public int getQnABoardTotalContent(String search) {
		return sqlSessionTemplate.selectOne("search.getQnABoardTotalContent",search);
	}
	
	@Override
	public List<BoardVO> getThRecruitBoardList(String search) {
		List<BoardVO> list = sqlSessionTemplate.selectList("search.getThRecruitBoardList", search);
		return list;
	}
	@Override
	public List<BoardVO> getThNoticeBoardList(String search) {
		List<BoardVO> list = sqlSessionTemplate.selectList("search.getThNoticeBoardList", search);
		return list;
	}
	@Override
	public List<BoardVO> getThReviewBoardList(String search) {
		List<BoardVO> list = sqlSessionTemplate.selectList("search.getThReviewBoardList", search);
		return list;
	}
	@Override
	public List<BoardVO> getThQnABoardList(String search) {
		List<BoardVO> list = sqlSessionTemplate.selectList("search.getThQnABoardList", search);
		return list;
	}

}
