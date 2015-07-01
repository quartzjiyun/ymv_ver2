package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuctionBoardDAOImpl implements AuctionBoardDAO  {
@Resource
private SqlSessionTemplate sqlSessionTemplate;

@Override
public AuctionBoardVO findByAuctionNO(AuctionBoardVO vo){
	// TODO Auto-generated method stub
	return sqlSessionTemplate.selectOne("auctionBoard.findByAuctionNo", vo.getBoardNo());	
}

@Override
public List<BoardVO> getBoardList(String pageNo){
	// TODO Auto-generated method stub
	List<BoardVO> list=sqlSessionTemplate.selectList("auctionBoard.getBoardList",Integer.parseInt(pageNo));
	return list;
}

@Override
public int totalContent(){
	return sqlSessionTemplate.selectOne("auctionBoard.totalContent");	
}

@Override
public BoardVO getAuctionBoardByBoardNo(int boardNo){
	// TODO Auto-generated method stub
	return sqlSessionTemplate.selectOne("auctionBoard.getAuctionBoardByBoardNo",boardNo);	
}

@Override
public void registerAuctionComment(CommentVO cmvo){
	sqlSessionTemplate.insert("auctionBoard.registerAuctionComment",cmvo);
}

@Override
public List<CommentVO> findByCommentNo(String boardNo) {
	return sqlSessionTemplate.selectList("auctionBoard.findByCommentNo",boardNo);
}

@Override
public void deleteAuctionComment(CommentVO cmvo) {
	sqlSessionTemplate.delete("auctionBoard.deleteAuctionComment",cmvo);
}

@Override
public void auctionBoardUpdate(AuctionBoardVO vo) {
	sqlSessionTemplate.update("auctionBoard.auctionBoardUpdate",vo);
}

@Override
public void auctionBoardDelete(String boardNo) {
	sqlSessionTemplate.delete("auctionBoard.auctionBoardDelete",Integer.parseInt(boardNo));
}

@Override
public void deleteAuctionBoardComment(String boardNo) {
	sqlSessionTemplate.delete("auctionBoard.deleteAuctionBoardComment",Integer.parseInt(boardNo));
}

@Override
public void registerAuctionBoard(AuctionBoardVO vo) {
	System.out.println("DAO"+vo);
	sqlSessionTemplate.insert("auctionBoard.registerAuctionBoard",vo);
}

@Override
public void registerPicture(PictureVO pvo) {
	// TODO Auto-generated method stub
	sqlSessionTemplate.insert("auctionBoard.registerPicture",pvo);
}

@Override
public PictureVO getPicture(int pictureNo) {
	// TODO Auto-generated method stub
	return sqlSessionTemplate.selectOne("auctionBoard.getPicture",pictureNo);
}

@Override
public void deletePicture(int pictureNo) {
	// TODO Auto-generated method stub
	sqlSessionTemplate.delete("auctionBoard.deletePicture",pictureNo);
}

@Override
public CommentVO getAuctionBoardCommentByBoardNo(int boardNo) {
	CommentVO comment = sqlSessionTemplate.selectOne("auctionBoard.getRevieBoardCommentByBoardNo", boardNo);
	System.out.println(comment);
	return comment;
}

@Override
public void updateHit(int boardNo) {
	sqlSessionTemplate.update("auctionBoard.updateHit",boardNo);	
}

}


































