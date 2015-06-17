package org.log5j.ymv.aop.model;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.log5j.ymv.model.statistics.StatisticsVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	public void insertStatistics(int age, String field) throws SQLException {
		StatisticsVO stvo = new StatisticsVO();
		stvo.setAge(age);
		stvo.setField(field);
		sqlSessionTemplate.insert("statistics.insertStatistics", stvo);
	}

	public int updateStatistics(int age, String field) throws SQLException {
		StatisticsVO stvo = new StatisticsVO();
		stvo.setAge(age);
		stvo.setField(field);
		return sqlSessionTemplate.update("statistics.updateStatistics",stvo);
	}

	@Override
	public String findIdentityNoByMemberNo(int memberNo) {
		return sqlSessionTemplate.selectOne("statistics.findIdentityNoByMemberNo",memberNo);
	}

	@Override
	public String findFieldByRecruitNo(int RecruitNo) {
		return sqlSessionTemplate.selectOne("statistics.findFieldByRecruitNo",RecruitNo);
	}

	
}
