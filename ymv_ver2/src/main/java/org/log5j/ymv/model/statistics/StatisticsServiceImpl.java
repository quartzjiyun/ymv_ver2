package org.log5j.ymv.model.statistics;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	@Resource(name="statisticsDAOImpl")
	private StatisticDAO statisticDAO;
	

	@Override
	public List selectStatistics() throws SQLException {
		return statisticDAO.selectStatistics();
	}
	
	@Override
	public List selectStatisticsByAge(int age) {
		System.out.println("selectStatisticsByAge  service" + age);
		return statisticDAO.selectStatisticsByAge(age);
	}
}
