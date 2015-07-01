package org.log5j.ymv.model.board;

import java.util.List;

public interface AuctionBoardDAO {
	AuctionBoardVO findByAuctionNO(AuctionBoardVO vo);
	 List<BoardVO> getBoardList(String pageNo);
	int totalContent();
	BoardVO getAuctionBoardByBoardNo(int boardNo);
	void registerAuctionComment(CommentVO cmvo);
	List<CommentVO> findByCommentNo(String boardNo);
	void deleteAuctionComment(CommentVO cmvo);
	void auctionBoardUpdate(AuctionBoardVO vo);
	void auctionBoardDelete(String boardNo);
	void deleteAuctionBoardComment(String boardNo);
	void registerAuctionBoard(AuctionBoardVO vo);
	void registerPicture(PictureVO pvo);
	PictureVO getPicture(int pictureNo);
	void deletePicture(int pictureNo);
	CommentVO getAuctionBoardCommentByBoardNo(int boardNo);
	void updateHit(int boardNo);
}