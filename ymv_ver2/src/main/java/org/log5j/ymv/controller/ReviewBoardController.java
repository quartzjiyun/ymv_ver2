package org.log5j.ymv.controller;

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
public class ReviewBoardController {
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
	@RequestMapping("review_board_update_view.ymv")
	public ModelAndView reviewBoardUpdateView(int boardNo) {
		System.out.println("boardNo 는 "+boardNo);
		ReviewBoardVO reviewbvo = (ReviewBoardVO) reviewBoardService.getReviewBoardByBoardNo(boardNo);
		System.out.println("reviewbvo 는 " + reviewbvo);
		return new ModelAndView("review_board_update_view","rvo"
				,reviewbvo);
	}

	@RequestMapping("review_board_update.ymv")
	public ModelAndView reviewBoardUpdate(ReviewBoardVO vo){
		ModelAndView mv=new ModelAndView();
		reviewBoardService.reviewBoardUpdate(vo);
		mv.setViewName("redirect:review_showContent.ymv?boardNo="+vo.getBoardNo());
		mv.addObject("rvo", vo);
		return mv;
	}
	
	@RequestMapping("review_board_delete.ymv")
	public ModelAndView reviewBoardDelete(String boardNo){
		reviewBoardService.deleteReviewBoardComment(boardNo);
		reviewBoardService.reviewBoardDelete(boardNo);
		return new ModelAndView("redirect:review_board.ymv");
	}
	
	@RequestMapping("review_register_view.ymv")
	public ModelAndView reviewRegisterView(){

		return new ModelAndView("review_register_view");
	}
	@RequestMapping("review_register.ymv")
	public ModelAndView reviewRegister(ReviewBoardVO vo){
		reviewBoardService.registerReviewBoard(vo);
		return new ModelAndView("redirect:review_board.ymv");
	}
	
	
	
}
