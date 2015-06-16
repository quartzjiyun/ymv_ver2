package org.log5j.ymv.model.scheduler;

import org.log5j.ymv.model.board.ListVO;

public interface SchedulerService {

	public abstract ListVO getBoardList(SearchVO scvo);

}