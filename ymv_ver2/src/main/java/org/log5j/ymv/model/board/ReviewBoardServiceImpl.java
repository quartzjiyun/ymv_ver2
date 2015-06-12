package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardService {
	@Resource
	private ReviewBoardDAO reviewBoardDAO;

	@Override
	public ReviewBoardVO findByReviewNo(ReviewBoardVO vo) {
		// TODO Auto-generated method stub
		return reviewBoardDAO.findByReviewNo(vo);
	}

	@Override
	public ListVO getBoardList(String pageNo) {
		if (pageNo == null || pageNo == "")
			pageNo = "1";
		List<BoardVO> list = reviewBoardDAO.getBoardList(pageNo);
		int total = reviewBoardDAO.totalContent();
		PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
		ListVO lvo = new ListVO(list, paging);
		return lvo;
	}

	@Override
	public BoardVO getReviewBoardByBoardNo(int boardNo) {
		return reviewBoardDAO.getReviewBoardByBoardNo(boardNo);
	}

	@Override
	public void registerReviewComment(CommentVO cmvo) {
		reviewBoardDAO.registerReviewComment(cmvo);
	}

	@Override
	public List<CommentVO> findByCommentNo(String boardNo) {
		return reviewBoardDAO.findByCommentNo(boardNo);
	}

	@Override
	public void deleteReviewComment(CommentVO cmvo) {
		reviewBoardDAO.deleteReviewComment(cmvo);
	}

}