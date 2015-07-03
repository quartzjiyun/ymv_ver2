package org.log5j.ymv.model.cookie;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class CookieDAOImpl implements CookieDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;	

	@Override
	public void updateHit(int no,BoardVO boardVO) {
		String temp = boardVO.getClass().getName();
		System.out.println(temp);
		if(temp.equals("org.log5j.ymv.model.board.RecruitBoardVO")){
			sqlSessionTemplate.update("recruitboard.updateHit",no);
		}else if (temp.equals("org.log5j.ymv.model.board.ReviewBoardVO")){
			sqlSessionTemplate.update("reviewBoard.updateHit",no);
		}else if (temp.equals("org.log5j.ymv.model.board.NoticeBoardVO")){
			sqlSessionTemplate.update("noticeBoard.updateHit",no);
		}else if (temp.equals("org.log5j.ymv.model.board.QnABoardVO")){
			sqlSessionTemplate.update("qnaBoard.updateHit",no);
		}
	}

	/*@Override
	public BoardVO findRecruitBoardByNo(int no) {
		String temp = boardVO.getClass().getName();
		System.out.println(temp);
		if(temp.equals("class org.log5j.ymv.model.board.RecruitBoardVO")){
			System.out.println("class org.log5j.ymv.model.board.RecruitBoardVO로 들어옴");
			sqlSessionTemplate.update("reviewBoard.findRecruitBoardByRecruitNo",no);
		}else if (temp.equals("RecruitBoardVO")){
			System.out.println("RecruitBoardVO로 들어옴");
			sqlSessionTemplate.update("reviewBoard.findRecruitBoardByRecruitNo",no);
		}
		else if (temp.equals("class org.log5j.ymv.model.board.QnABoardVO")){
			sqlSessionTemplate.update("qnaBoard.findRecruitBoardByRecruitNo",no);
		}else{
			System.out.println("잘못왔네");
		}
		
		return boardVO;
	}*/

}
