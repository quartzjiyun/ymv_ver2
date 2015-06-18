package org.log5j.ymv.controller;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.FieldVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.LocationVO;
import org.log5j.ymv.model.board.RecruitBoardService;
import org.log5j.ymv.model.scheduler.SchedulerService;
import org.log5j.ymv.model.scheduler.SearchVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SchedulerController {
	@Resource 
	private SchedulerService schedulerService; 
	@Resource(name="recruitBoardServiceImpl")
	private RecruitBoardService recruitBoardService;
	
	@RequestMapping("scheduler_board.ymv")
	public ModelAndView testController(SearchVO scvo){
		ListVO lvo = schedulerService.getBoardList(scvo);
		System.out.println(lvo+"컨트롤러");
		return new ModelAndView("scheduler_board","lvo",lvo).addObject("scvo", scvo);
	}
	@RequestMapping("search_view.ymv")
	@NoLoginCheck
	public ModelAndView searchView(){
	     List<FieldVO> Flist = recruitBoardService.getFieldList(); 
	      List<LocationVO> Llist = recruitBoardService.getLocationList();
		return new ModelAndView("search_view").addObject("fieldlist", Flist).addObject("locationlist", Llist);
	}
}
