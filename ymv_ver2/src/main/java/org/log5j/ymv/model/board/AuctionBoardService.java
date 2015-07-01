package org.log5j.ymv.model.board;

import java.util.List;

public interface AuctionBoardService {
	AuctionBoardVO findByAuctionNO(AuctionBoardVO vo);
	ListVO getBoardList(String pageNo);
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
	AuctionBoardVO getPostingByNoticeBoardNoUpdateHit(int boardNo);
}