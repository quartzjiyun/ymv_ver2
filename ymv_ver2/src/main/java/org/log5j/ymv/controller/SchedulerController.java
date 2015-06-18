package org.log5j.ymv.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.FieldVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.LocationVO;
import org.log5j.ymv.model.board.RecruitBoardService;
import org.log5j.ymv.model.scheduler.SchedulerService;
import org.log5j.ymv.model.scheduler.SchedulerVO;
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
	public ModelAndView getSchedulerList(SchedulerVO sdvo){
		System.out.println("Contoller:"+sdvo);
		List<BoardVO> list= schedulerService.getSchedulerList(sdvo);
		List<HashMap> dateList=schedulerService.getDateList(sdvo);
		System.out.println(dateList);
		return new ModelAndView("scheduler_test","list",list).addObject("dateList", dateList);
	}
	@RequestMapping("search_board.ymv")
	@NoLoginCheck
	public ModelAndView getSearchList(SearchVO scvo){
		ListVO lvo = schedulerService.getSearchList(scvo);
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
