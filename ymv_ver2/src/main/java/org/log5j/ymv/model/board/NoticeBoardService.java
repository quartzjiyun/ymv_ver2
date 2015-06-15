package org.log5j.ymv.model.board;

public interface NoticeBoardService {

	ListVO getNoticeBoardList(String pageNo);

	void registerNoticeBoard(NoticeBoardVO vo);

	BoardVO getNoticeBoardByBoardNo(int boardNo);

	void noticeBoardUpdate(NoticeBoardVO vo);

	void noticeBoardDelete(String boardNo);

}