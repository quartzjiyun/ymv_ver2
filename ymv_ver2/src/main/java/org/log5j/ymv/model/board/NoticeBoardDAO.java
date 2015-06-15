package org.log5j.ymv.model.board;

import java.util.List;

public interface NoticeBoardDAO {
	List<BoardVO> getNoticeBoardList(String pageNo);
	int totalContent();
	void registerNoticeBoard(NoticeBoardVO vo);
	BoardVO getReviewBoardByBoardNo(int boardNo);
	void noticeBoardUpdate(NoticeBoardVO vo);
	void noticeBoardDelete(String boardNo);
}
