package org.log5j.ymv.model.statistics;

import java.sql.SQLException;
import java.util.List;

public interface StatisticDAO {
	public List selectStatistics() throws SQLException;
	public List selectStatisticsByAge(int age);
}