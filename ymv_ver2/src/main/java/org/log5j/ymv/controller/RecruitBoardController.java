package org.log5j.ymv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.model.board.CompanyVO;
import org.log5j.ymv.model.board.FieldVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.LocationVO;
import org.log5j.ymv.model.board.RecruitBoardService;
import org.log5j.ymv.model.board.RecruitBoardVO;
import org.log5j.ymv.model.member.MemberVO;
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
		return new ModelAndView("voluntary_board","lvo",lvo);
	}
	@RequestMapping("voluntary_showContentRecruitVol.ymv")
	   public ModelAndView showContentRecruitVol(HttpServletRequest request){
	      int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	      RecruitBoardVO rvo=recruitBoardService.getRecruitBoardByRecruitNo(recruitNo);
	      return new ModelAndView("voluntary_show_content","rvo",rvo);
	   }

	@RequestMapping("voluntary_board_update_view.ymv")
	public ModelAndView updateView(int recruitNo) {
		RecruitBoardVO recruitbvo = (RecruitBoardVO) recruitBoardService
				.getRecruitBoardByRecruitNo(recruitNo);
		List<FieldVO> Flist = recruitBoardService.getFieldList();
		List<LocationVO> Llist = recruitBoardService.getLocationList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voluntary_board_update_view");
		mv.addObject("fieldlist", Flist);
		mv.addObject("locationlist", Llist);
		mv.addObject("rvo", recruitbvo);
		return mv;
	}

	@RequestMapping("voluntary_board_update.ymv")
	   public ModelAndView voluntary_board_update(HttpServletRequest request, int recruitNo, String title, String field, String location, String age, String startDate, String endDate, String content) {
	      RecruitBoardVO recruitbvo = new RecruitBoardVO(recruitNo, title, field, location, age, startDate, endDate, content);
	      recruitBoardService.updateBoard(recruitbvo);
	      return new ModelAndView("voluntary_show_content","rvo",recruitBoardService.getRecruitBoardByRecruitNo(recruitbvo.getRecruitNo()));
	   }
	
	@RequestMapping("voluntary_register_view.ymv")
	   public ModelAndView RegisterVolunteer_form(){
	      List<FieldVO> Flist = recruitBoardService.getFieldList(); 
	      List<LocationVO> Llist = recruitBoardService.getLocationList();
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("voluntary_register_view");
	      mv.addObject("fieldlist", Flist);
	      mv.addObject("locationlist", Llist);
	      return mv;
	   }
	
	@RequestMapping("Volunteer_register.ymv")
	public String RegisterVolunteer_result(HttpServletRequest request,RecruitBoardVO rbvo){
		recruitBoardService.registerVolunteer(rbvo);
		//return "redirect:RegisterVolunteer_detail.ymv?title=" + rbvo.getTitle();
		return "redirect:voluntary_showContentRecruitVol.ymv?recruitNo=" + rbvo.getRecruitNo();
	}
	
	@RequestMapping("voluntary_delete.ymv")
	   public ModelAndView DeleteRecruitVol(HttpServletRequest request){
	         int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	         int pictureNo=recruitNo;
	         recruitBoardService.deleteVoluntaryServiceApplicateNo(recruitNo);
	         recruitBoardService.deleteRecruitVolunteer(recruitNo);
	         recruitBoardService.deletePicture(pictureNo);
	      return new ModelAndView("redirect:/voluntary_board.ymv?pageNo=1");
	   }
	@RequestMapping("voluntary_board_company.ymv")
	public ModelAndView voluntaryBoardCompany(HttpServletRequest request,CompanyVO cpvo){
		//세션에 들어있는 멤버넘버로 등록된 글 조회 
		MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
		cpvo.setMemberNo(mvo.getMemberNo());
		ListVO lvo = recruitBoardService.getCompanyBoardList(cpvo);
		return new ModelAndView("voluntary_board_company","lvo",lvo);
	}
	@RequestMapping("voluntary_board_normal.ymv")
	public ModelAndView voluntaryBoardNormal(HttpServletRequest request, CompanyVO cpvo){
		MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
		cpvo.setMemberNo(mvo.getMemberNo());
		ListVO lvo = recruitBoardService.getNormalBoardList(cpvo);
		return new ModelAndView("voluntary_board_normal","lvo",lvo);
	}
}
