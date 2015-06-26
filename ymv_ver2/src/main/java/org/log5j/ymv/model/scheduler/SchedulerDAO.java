package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
import java.util.List;

import org.log5j.ymv.model.board.BoardVO;

public interface SchedulerDAO {

	List<BoardVO> getSchedulerList(SchedulerVO sdvo);

	int totalContent(SearchVO scvo);

	List<BoardVO> getSearchList(SearchVO scvo);

	List<HashMap> getDateList(SchedulerVO sdvo);

	SchedulerVO schedulerCheck(String memberNo);

	void registerScheduler(SchedulerVO sdvo);

	void updateScheduler(SchedulerVO sdvo);

	int getRecruitTotalContent(String search);

	List<BoardVO> getRecruitBoardList(SearchBoardVO sebvo);

	int getNoticeBoardTotalContent(String search);

	List<BoardVO> getNoticeBoardList(SearchBoardVO sebvo);

	List<BoardVO> getReviewBoardList(SearchBoardVO sebvo);

	int getReviewBoardTotalContent(String search);

	List<BoardVO> getQnABoardList(SearchBoardVO sebvo);

	int getQnABoardTotalContent(String search);

	List<BoardVO> getThRecruitBoardList(String search);

	List<BoardVO> getThNoticeBoardList(String search);

	List<BoardVO> getThReviewBoardList(String search);

	List<BoardVO> getThQnABoardList(String search);
}
