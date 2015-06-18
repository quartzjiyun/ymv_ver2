package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewBoardDAOImpl implements ReviewBoardDAO {
   @Resource
   private SqlSessionTemplate sqlSessionTemplate;

   @Override
   public ReviewBoardVO findByReviewNo(ReviewBoardVO vo) {
      // TODO Auto-generated method stub
      
      return sqlSessionTemplate.selectOne("reviewBoard.findByReviewNo", vo.getBoardNo());
   }

@Override
public List<BoardVO> getBoardList(String pageNo) {
	// TODO Auto-generated method stub
	List<BoardVO> list=sqlSessionTemplate.selectList("reviewBoard.getBoardList",Integer.parseInt(pageNo));
	return list;
}

@Override
public int totalContent(){
	return sqlSessionTemplate.selectOne("reviewBoard.totalContent");
}

@Override
public BoardVO getReviewBoardByBoardNo(int boardNo) {
	// TODO Auto-generated method stub
	return sqlSessionTemplate.selectOne("reviewBoard.getReviewBoardByBoardNo",boardNo);
}

@Override
public void registerReviewComment(CommentVO cmvo) {
	sqlSessionTemplate.insert("reviewBoard.registerReviewComment",cmvo);
}

@Override
public List<CommentVO> findByCommentNo(String boardNo) {
	return sqlSessionTemplate.selectList("reviewBoard.findByCommentNo",boardNo);
}

@Override
public void deleteReviewComment(CommentVO cmvo) {
	sqlSessionTemplate.delete("reviewBoard.deleteReviewComment",cmvo);
}

@Override
public void reviewBoardUpdate(ReviewBoardVO vo) {
	sqlSessionTemplate.update("reviewBoard.reviewBoardUpdate",vo);
}

@Override
public void reviewBoardDelete(String boardNo) {
	sqlSessionTemplate.delete("reviewBoard.reviewBoardDelete",Integer.parseInt(boardNo));
}

@Override
public void deleteReviewBoardComment(String boardNo) {
	sqlSessionTemplate.delete("reviewBoard.deleteReviewBoardComment",Integer.parseInt(boardNo));
}

@Override
public void registerReviewBoard(ReviewBoardVO vo) {
	System.out.println("DAO"+vo);
	sqlSessionTemplate.insert("reviewBoard.registerReviewBoard",vo);
}

@Override
public void registerPicture(PictureVO pvo) {
	// TODO Auto-generated method stub
	sqlSessionTemplate.insert("reviewBoard.registerPicture",pvo);
}

@Override
public PictureVO getPicture(int pictureNo) {
	// TODO Auto-generated method stub
	return sqlSessionTemplate.selectOne("reviewBoard.getPicture",pictureNo);
}

@Override
public void deletePicture(int pictureNo) {
	// TODO Auto-generated method stub
	sqlSessionTemplate.delete("reviewBoard.deletePicture",pictureNo);
}

@Override
public CommentVO getReviewBoardCommentByBoardNo(int boardNo) {
	CommentVO comment = sqlSessionTemplate.selectOne("reviewBoard.getReviewBoardCommentByBoardNo", boardNo);
	System.out.println(comment);
	return comment;
}


}