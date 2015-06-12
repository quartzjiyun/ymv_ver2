package org.log5j.ymv.controller;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.CommentVO;
import org.log5j.ymv.model.board.ReviewBoardService;
import org.log5j.ymv.model.board.ReviewBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LYHController {
   @Resource
   private ReviewBoardService reviewBoardService;
   @RequestMapping("findByReviewNo.ymv")
   public ModelAndView findByReviewNo(ReviewBoardVO vo){
      ModelAndView mv=new ModelAndView();
      vo.setBoardNo(1);
      vo=reviewBoardService.findByReviewNo(vo);
      mv.setViewName("findbyreviewno_result");
      mv.addObject("result",vo);
      return mv;
   }
   @RequestMapping("update_review_view.ymv")
   public ModelAndView updateReview(ReviewBoardVO vo){
	   ModelAndView mv=new ModelAndView();
	   reviewBoardService.findByReviewNo(vo);
	   return mv;
   }
   
}