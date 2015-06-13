package org.log5j.ymv.model.board;

import java.util.List;

public interface ReviewBoardService {

	ReviewBoardVO findByReviewNo(ReviewBoardVO vo);

	ListVO getBoardList(String pageNo);

	BoardVO getReviewBoardByBoardNo(int boardNo);

	void registerReviewComment(CommentVO cmvo);

	List<CommentVO> findByCommentNo(String string);

	void deleteReviewComment(CommentVO cmvo);

}