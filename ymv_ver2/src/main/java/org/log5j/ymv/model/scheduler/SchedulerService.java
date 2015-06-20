package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
import java.util.List;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;

public interface SchedulerService {

	public abstract List<BoardVO> getSchedulerList(SchedulerVO sdvo);

	ListVO getSearchList(SearchVO scvo);

	public abstract List<HashMap> getDateList(SchedulerVO sdvo);

	public abstract SchedulerVO schedulerCheck(String parameter);

	public abstract void registerScheduler(SchedulerVO sdvo);

}