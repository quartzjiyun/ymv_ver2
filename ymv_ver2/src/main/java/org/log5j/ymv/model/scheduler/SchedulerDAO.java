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

}
