package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
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
	public List<BoardVO> getSchedulerList(SchedulerVO sdvo) {
		System.out.println("DAO Scheduler"+sdvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("scheduler.getSchedulerList",sdvo);
		return list;
	}
	@Override
	public List<BoardVO> getSearchList(SearchVO scvo) {
		System.out.println("DAO Search"+scvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("scheduler.getSearchList",scvo);
		return list;
	}

	@Override
	public int totalContent(SearchVO scvo) {
		return sqlSessionTemplate.selectOne("scheduler.totalContent",scvo);
	}
	@Override
	public List<HashMap> getDateList(SchedulerVO sdvo) {
		return sqlSessionTemplate.selectList("scheduler.getDateList",sdvo);
	}
	@Override
	public SchedulerVO schedulerCheck(String memberNo) {
		
		return sqlSessionTemplate.selectOne("scheduler.schedulerCheck",memberNo);
	}


}
