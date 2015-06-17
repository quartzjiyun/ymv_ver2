package org.log5j.ymv.model.scheduler;

import java.util.List;

import org.log5j.ymv.model.board.BoardVO;

public interface SchedulerDAO {

	List<BoardVO> getBoardList(SearchVO scvo);

	int totalContent(SearchVO scvo);

}
