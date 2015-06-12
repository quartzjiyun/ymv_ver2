package org.log5j.ymv.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.CommentVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.ReviewBoardService;
import org.log5j.ymv.model.board.ReviewBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@Resource
	private ReviewBoardService reviewBoardService;
	
	@RequestMapping("home.ymv")
	public String test(){
		return "index";
	}
	@RequestMapping("testTiles.ymv")
	public String testTiles(){
		return "home";
	}
	@RequestMapping("review_board.ymv")
	public ModelAndView reviewBoard(String pageNo) {	
		pageNo="1";
		ListVO lvo = reviewBoardService.getBoardList(pageNo);
		System.out.println(lvo+"컨틀롤러");
		return new ModelAndView("review_board","lvo",lvo);
	}
	@RequestMapping("review_showContent.ymv")
	   public String showContentReview(HttpServletRequest request,Model model){
	      int boardNo=Integer.parseInt(request.getParameter("boardNo"));
	      System.out.println("boardNo:"+boardNo);
	      BoardVO rvo=reviewBoardService.getReviewBoardByBoardNo(boardNo);
	      List<CommentVO> commentList=reviewBoardService.findByCommentNo(request.getParameter("boardNo"));
	      model.addAttribute("rvo", rvo).addAttribute("commentList", commentList);
	      return "review_show_content";
	   }
	
	
	
	@RequestMapping("register_review_comment.ymv")
	public String registerReviewComment(HttpServletRequest request,CommentVO cmvo){
		reviewBoardService.registerReviewComment(cmvo);
		System.out.println(cmvo);
		return "redirect:review_showContent.ymv?boardNo="+cmvo.getBoardNo();
	}
	@RequestMapping("delete_review_comment.ymv")
	public String deleteReviewComment(CommentVO cmvo){
		reviewBoardService.deleteReviewComment(cmvo);
		return "redirect:review_showContent.ymv?boardNo="+cmvo.getBoardNo();
	}
	/*@RequestMapping("voluntary_showContentRecruitVol.ymv")
	   public ModelAndView showContentRecruitVol(HttpServletRequest request){
	      int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	      System.out.println("recruitNo:"+recruitNo);
	      RecruitBoardVO rvo=recruitBoardService.getRecruitBoardByRecruitNo(recruitNo);
	      return new ModelAndView("voluntary_show_content","rvo",rvo);
	   }
	
	@RequestMapping("voluntary_board_update_view.ymv")
	public ModelAndView updateView(int recruitNo) {
		System.out.println("recruitNo 는 "+recruitNo);
		RecruitBoardVO recruitbvo = (RecruitBoardVO) recruitBoardService.getRecruitBoardByRecruitNo(recruitNo);
		System.out.println("recruitbvo 는 " + recruitbvo);
		return new ModelAndView("voluntary_board_update_view","rvo"
				,recruitbvo);
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
	   }*/
}
