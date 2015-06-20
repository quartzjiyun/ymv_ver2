package org.log5j.ymv.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SchedulerController {
	@Resource 
	private SchedulerService schedulerService; 
	@Resource(name="recruitBoardServiceImpl")
	private RecruitBoardService recruitBoardService;
	
	@RequestMapping("scheduler_board.ymv")
	@ResponseBody
	public HashMap getSchedulerList(SchedulerVO sdvo){
		System.out.println("ContollergetSchedulerList:"+sdvo);
		List<BoardVO> list= schedulerService.getSchedulerList(sdvo);
		List<HashMap> dateList=schedulerService.getDateList(sdvo);
		System.out.println(list);
		System.out.println(dateList);
		HashMap schedulerMap=new HashMap();
		schedulerMap.put("list", list);
		schedulerMap.put("dateList", dateList);
		return schedulerMap;
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
	@RequestMapping("scheduler_Check")
	@ResponseBody
	public Object schedulerCheck(HttpServletRequest request){
		SchedulerVO sdvo=schedulerService.schedulerCheck(request.getParameter("memberNo"));
		System.out.println("Controller scheduler_check"+sdvo);
		if(sdvo==null){
			return sdvo=new SchedulerVO();
		}
		return sdvo;
	}
	@RequestMapping("scheduler_register_view")
	public ModelAndView schedulerRegisterView(){
		 List<FieldVO> Flist = recruitBoardService.getFieldList(); 
	      List<LocationVO> Llist = recruitBoardService.getLocationList();
		return new ModelAndView("scheduler_register_view","fieldlist",Flist).addObject("locationlist", Llist);
	}
	@RequestMapping("scheduler_register")
	public String schedulerRegister(SchedulerVO sdvo){
		System.out.println("scheduler_register sdvo:"+sdvo);
		schedulerService.registerScheduler(sdvo);
		return "redirect:testTiles.ymv";
	}
}
