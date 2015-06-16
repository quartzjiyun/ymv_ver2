package org.log5j.ymv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.model.board.FieldVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.LocationVO;
import org.log5j.ymv.model.board.RecruitBoardService;
import org.log5j.ymv.model.board.RecruitBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecruitBoardController {
	@Resource(name="recruitBoardServiceImpl")
	private RecruitBoardService recruitBoardService;
	
	@RequestMapping("voluntary_board.ymv")
	public ModelAndView list(String pageNo) {	
		ListVO lvo = recruitBoardService.getBoardList(pageNo);
		System.out.println(lvo+"컨틀롤러");
		return new ModelAndView("voluntary_board","lvo",lvo);
	}
	@RequestMapping("voluntary_showContentRecruitVol.ymv")
	   public ModelAndView showContentRecruitVol(HttpServletRequest request){
	      int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	      System.out.println("recruitNo:"+recruitNo);
	      System.out.println("memberNo:"+request.getParameter("memberNo"));
	      RecruitBoardVO rvo=recruitBoardService.getRecruitBoardByRecruitNo(recruitNo);
	      System.out.println("rvo: "+ rvo);
	      return new ModelAndView("voluntary_show_content","rvo",rvo);
	   }
	
	@RequestMapping("voluntary_board_update_view.ymv")
	   public ModelAndView updateView(int recruitNo) {
	      System.out.println("recruitNo 는 "+recruitNo);
	      RecruitBoardVO recruitbvo = (RecruitBoardVO) recruitBoardService.getRecruitBoardByRecruitNo(recruitNo);
	      System.out.println("recruitbvo 는 " + recruitbvo);
	       List<FieldVO> Flist = recruitBoardService.getFieldList(); 
	         System.out.println("getFieldList 입니다."+Flist);
	         List<LocationVO> Llist = recruitBoardService.getLocationList();
	         System.out.println("getLocationList 입니다."+Llist);
	         ModelAndView mv = new ModelAndView();
	         mv.setViewName("voluntary_board_update_view");
	         mv.addObject("fieldlist", Flist);
	         mv.addObject("locationlist", Llist);
	      mv.addObject("rvo",recruitbvo);
	      return mv;
	   }
	
	@RequestMapping("voluntary_board_update.ymv")
	   public ModelAndView voluntary_board_update(HttpServletRequest request, int recruitNo, String title, String field, String location, String age, String startDate, String endDate, String content) {
	      RecruitBoardVO recruitbvo = new RecruitBoardVO(recruitNo, title, field, location, age, startDate, endDate, content);
	      System.out.println("수정받은 recruitbvo "+recruitbvo);
	      recruitBoardService.updateBoard(recruitbvo);
	      return new ModelAndView("voluntary_show_content","rvo",recruitBoardService.getRecruitBoardByRecruitNo(recruitbvo.getRecruitNo()));
	   }
	
	@RequestMapping("voluntary_register_view.ymv")
	   public ModelAndView RegisterVolunteer_form(){
	      System.out.println("컨트롤러 실행");
	      List<FieldVO> Flist = recruitBoardService.getFieldList(); 
	      System.out.println("getFieldList 입니다."+Flist);
	      List<LocationVO> Llist = recruitBoardService.getLocationList();
	      System.out.println("getLocationList 입니다."+Llist);
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("voluntary_register_view");
	      mv.addObject("fieldlist", Flist);
	      mv.addObject("locationlist", Llist);
	      return mv;
	   }
	
	@RequestMapping("Volunteer_register.ymv")
	public String RegisterVolunteer_result(HttpServletRequest request,RecruitBoardVO rbvo){
		System.out.println("rbvo  " + rbvo);
		System.out.println("register sql 실행전");
		recruitBoardService.registerVolunteer(rbvo);
		System.out.println("register sql실행후");
		System.out.println("rbvo  " + rbvo);
		//return "redirect:RegisterVolunteer_detail.ymv?title=" + rbvo.getTitle();
		//세션넘버도 보내야하나?
		return "redirect:voluntary_showContentRecruitVol.ymv?recruitNo=" + rbvo.getRecruitNo();
	}
	
	@RequestMapping("voluntary_delete.ymv")
	   public ModelAndView DeleteRecruitVol(HttpServletRequest request){
	         int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	         System.out.println("delete recruitNo:"+recruitNo);
	         recruitBoardService.deleteVoluntaryServiceApplicateNo(recruitNo);
	         recruitBoardService.deleteRecruitVolunteer(recruitNo);
	         System.out.println("delete 성공");
	      return new ModelAndView("redirect:/voluntary_board.ymv?pageNo=1");
	   }
}
