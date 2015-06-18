package org.log5j.ymv.aop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.controller.NoLoginCheck;
import org.log5j.ymv.model.statistics.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
	@Resource(name="statisticsServiceImpl")
	private StatisticsService statisticsService;
	
	@RequestMapping("voluntary_statistics.ymv")
	@NoLoginCheck
	public String voluntary_findStatistics(Model model) throws SQLException{
		List list = statisticsService.selectStatistics();
		model.addAttribute("list", list);
		System.out.println("list   " + list);
		return "voluntary_statistics";
	}
	
	@RequestMapping("voluntary_statisticsByAge.ymv")
	@NoLoginCheck
	public String voluntary_findStatisticsByAge(Model model) throws SQLException{
		List list = statisticsService.selectStatistics();
		model.addAttribute("list", list);
		System.out.println("list   " + list);
		return "voluntary_statisticsByAge";
	}
	
	@RequestMapping("voluntary_selectStatisticsByAge.ymv")
	@NoLoginCheck
	@ResponseBody
	public List selectStatisticsByAge(HttpServletRequest request, Model model){
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("1234age      "+age);
		List list = statisticsService.selectStatisticsByAge(age);
		System.out.println("1111111  list  "+list);
		return list;
	}
	
}
