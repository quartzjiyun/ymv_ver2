package org.log5j.ymv.model.statistics;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsDAOImpl implements StatisticDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectStatistics() throws SQLException {
		return sqlSessionTemplate.selectList("statistics.selectStatistics");
	}

	@Override
	public List selectStatisticsByAge(int age) {
		System.out.println("selectStatisticsByAge   dao   " + age);
		List list = sqlSessionTemplate.selectList("statistics.selectStatisticsByAge", age);
		return list;
	}
}
