package org.log5j.ymv.model.scheduler;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class SchedulerDAOImpl implements SchedulerDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> getBoardList(SearchVO scvo) {
		System.out.println("DAO Search"+scvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("scheduler.getBoardList",scvo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalContent(SearchVO scvo) {
		return sqlSessionTemplate.selectOne("scheduler.totalContent",scvo);
	}


}
