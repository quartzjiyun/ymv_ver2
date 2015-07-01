package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class AuctionBoardServiceImpl implements AuctionBoardService {
@Resource
private AuctionBoardDAO auctionBoardDAO;

@Override
public AuctionBoardVO findByAuctionNO(AuctionBoardVO vo){
	return auctionBoardDAO.findByAuctionNO(vo);
}

@Override
public ListVO getBoardList(String pageNo) {
	if (pageNo == null || pageNo == "")
		pageNo = "1";
	List<BoardVO> list =auctionBoardDAO.getBoardList(pageNo);
	int total = auctionBoardDAO.totalContent();
	PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
	ListVO lvo = new ListVO(list, paging);
	return lvo;
}

@Override
public BoardVO getAuctionBoardByBoardNo(int boardNo) {
	return auctionBoardDAO.getAuctionBoardByBoardNo(boardNo);
}

@Override
public void registerAuctionComment(CommentVO cmvo) {
	auctionBoardDAO.registerAuctionComment(cmvo);
}

@Override
public List<CommentVO> findByCommentNo(String boardNo) {
	return auctionBoardDAO.findByCommentNo(boardNo);
}

@Override
public void deleteAuctionComment(CommentVO cmvo) {
	auctionBoardDAO.deleteAuctionComment(cmvo);
}

@Override
public void auctionBoardUpdate(AuctionBoardVO vo) {
	auctionBoardDAO.auctionBoardUpdate(vo);
}

@Override
public void auctionBoardDelete(String boardNo) {
	auctionBoardDAO.auctionBoardDelete(boardNo);
}

@Override
public void deleteAuctionBoardComment(String boardNo) {
	auctionBoardDAO.deleteAuctionBoardComment(boardNo);
}

@Override
public void registerAuctionBoard(AuctionBoardVO vo) {
	auctionBoardDAO.registerAuctionBoard(vo);
}

@Override
public void registerPicture(PictureVO pvo) {
	auctionBoardDAO.registerPicture(pvo);
}

@Override
public PictureVO getPicture(int pictureNo) {
	return auctionBoardDAO.getPicture(pictureNo);
}

@Override
public void deletePicture(int pictureNo) {
	// TODO Auto-generated method stub
	auctionBoardDAO.deletePicture(pictureNo);
}

@Override
public CommentVO getAuctionBoardCommentByBoardNo(int boardNo) {
	System.out.println("service getAuctionBoardCommentByBoardNo boardNo: "+boardNo);
	return 	auctionBoardDAO.getAuctionBoardCommentByBoardNo(boardNo);
}

@Override
public AuctionBoardVO getPostingByNoticeBoardNoUpdateHit(int boardNo) {
	auctionBoardDAO.updateHit(boardNo);
	return (AuctionBoardVO) auctionBoardDAO.getAuctionBoardByBoardNo(boardNo);
}
}




























