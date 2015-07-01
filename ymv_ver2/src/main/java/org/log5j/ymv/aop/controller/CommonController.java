package org.log5j.ymv.aop.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
		List<Map<String, Object>> list = statisticsService.selectStatistics();
		model.addAttribute("list", list);
		System.out.println("list   " + list);
		/*for (int i = 0; i < list.size(); i++) {
			model.addAttribute("map" + i, list.get(i));
			System.out.println(list.get(i));
			if((list.get(i)).get("FIELD").equals("환경")){
				model.addAttribute("environmentValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("노인")){
				model.addAttribute("oldValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("아동")){
				model.addAttribute("newValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("동물")){
				model.addAttribute("animalValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("장애")){
				model.addAttribute("disabilityValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
		}*/
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
		List<Map<String, Object>> list = statisticsService.selectStatisticsByAge(age);
		model.addAttribute("list", list);
		System.out.println("list   " + list);
		for (int i = 0; i < list.size(); i++) {
			model.addAttribute("map" + i, list.get(i));
			System.out.println(list.get(i));
			if((list.get(i)).get("FIELD").equals("환경")){
				model.addAttribute("environmentValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("노인")){
				model.addAttribute("oldValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("아동")){
				model.addAttribute("newValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("동물")){
				model.addAttribute("animalValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("장애")){
				model.addAttribute("disabilityValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
		}
		return list;
	}
	
}
