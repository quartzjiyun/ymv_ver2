package org.log5j.ymv.model.board;

import java.util.List;

public interface NoticeBoardDAO {
	List<BoardVO> getNoticeBoardList(String pageNo);
	int totalContent();
	void registerNoticeBoard(NoticeBoardVO vo);
	BoardVO getReviewBoardByBoardNo(int boardNo);
	void noticeBoardUpdate(NoticeBoardVO vo);
	void noticeBoardDelete(String boardNo);
	void registerPicture(PictureVO pvo);
	PictureVO getPicture(int pictureNo);
	void deletePicture(int pictureNo);
	NoticeBoardVO getNoticeBoardByBoardNo(int boardNo);
	void updateHit(int boardNo);
}
