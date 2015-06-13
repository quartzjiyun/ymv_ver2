package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class RecruitBoardDAOImpl implements RecruitBoardDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> getBoardList(String pageNo){
		System.out.println(pageNo+"   RecruitBoardDAOImpl  getBoardList pageno");
		
		List<BoardVO> list = sqlSessionTemplate.selectList("board.getBoardList", pageNo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("board.totalContent");
	}

	@Override
	public BoardVO showContent(int recruitNo) {
		return (BoardVO)sqlSessionTemplate.selectOne("board.showContent",recruitNo);
	}

	@Override
	public RecruitBoardVO getRecruitBoardByRecruitNo(int recruitNo){
	      return sqlSessionTemplate.selectOne("board.getRecruitBoardByRecruitNo",recruitNo);
	   }

	@Override
	public List<FieldVO> getFieldList() {
		List<FieldVO> list = sqlSessionTemplate.selectList("board.getFieldList");
		return list;
	}

	@Override
	public List<LocationVO> getLocationList() {
		List<LocationVO> list = sqlSessionTemplate.selectList("board.getLocationList");
		return list;
	}

	@Override
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo) {
		return sqlSessionTemplate.selectOne("board.findRecruitBoardByrecruitNo", recruitNo);
	}
	
	@Override
	public void registerVolunteer(RecruitBoardVO rbvo) {
		System.out.println("dao register volunterr"+rbvo);
		sqlSessionTemplate.insert("board.registerVolunteer",rbvo);
		
	}

	@Override
	public void updateBoard(BoardVO bvo) {
		sqlSessionTemplate.update("board.updateBoard",bvo);
		
	}

	@Override
	public void deleteRecruitVolunteer(int recruitNo) {
		sqlSessionTemplate.delete("board.deleteRecruitVolunteer",recruitNo);
	}

	@Override
	public void deleteVoluntaryServiceApplicateNo(int recruitNo) {
		sqlSessionTemplate.delete("member.deleteVoluntaryServiceApplicateNo",recruitNo);		
	}

}