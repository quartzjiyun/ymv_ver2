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


}