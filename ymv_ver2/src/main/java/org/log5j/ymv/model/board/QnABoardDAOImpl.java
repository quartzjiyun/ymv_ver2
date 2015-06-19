package org.log5j.ymv.model.board;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class QnABoardDAOImpl implements QnABoardDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> getQnABoardList(String pageNo){
		List<BoardVO> list = sqlSessionTemplate.selectList("qnaBoard.getQnABoardList",pageNo);
		return list;
	}

	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("qnaBoard.totalQnABoardContent");
	}
	@Override
	public void registerQnABoard(QnABoardVO qvo){
		sqlSessionTemplate.delete("qnaBoard.registerQnABoard",qvo);
	}
	@Override
	public QnABoardVO getQnABoardByQnANo(int qnaNo){
		return sqlSessionTemplate.selectOne("qnaBoard.showQnAContent",qnaNo);
	}

	@Override
	public void updateQnABoard(QnABoardVO qnABoardVO){
		sqlSessionTemplate.update("qnaBoard.updateQnABoard",qnABoardVO);
	}
	@Override
	public void deleteQnABoard(int qnaNo){
		sqlSessionTemplate.delete("qnaBoard.deleteQnABoard",qnaNo);
	}
	@Override
    public void updateRestep(int ref, int restep){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ref", ref);
		map.put("restep", restep);
		sqlSessionTemplate.update("qnaBoard.updateRestep", map);		
	}
	@Override
	public void replyQnABoard(QnABoardVO qvo){
		sqlSessionTemplate.insert("qnaBoard.replyQnABoard", qvo);		
	}
	
	@Override
	public void getPostingByQnaNoNotHit(int qnaNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.selectOne("qnaBoard.showQnAContent",qnaNo);
	}

	@Override
	public void updateHit(int qnaNo) {
		sqlSessionTemplate.update("qnaBoard.updateHit",qnaNo);
		
	}
}
