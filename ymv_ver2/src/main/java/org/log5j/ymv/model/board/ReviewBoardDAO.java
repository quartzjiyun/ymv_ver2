package org.log5j.ymv.model.board;

import java.util.List;

public interface ReviewBoardDAO {
	ReviewBoardVO findByReviewNo(ReviewBoardVO vo);
	List<BoardVO> getBoardList(String pageNo);
	int totalContent();
	BoardVO getReviewBoardByBoardNo(int boardNo);
	void registerReviewComment(CommentVO cmvo);
	List<CommentVO> findByCommentNo(String boardNo);
	void deleteReviewComment(CommentVO cmvo);
	void reviewBoardUpdate(ReviewBoardVO vo);
	void reviewBoardDelete(String boardNo);
	void deleteReviewBoardComment(String boardNo);
	void registerReviewBoard(ReviewBoardVO vo);
}
