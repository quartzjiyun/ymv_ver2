package org.log5j.ymv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.CommentVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.NoticeBoardService;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.ReviewBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LYHController {
	@Resource
	private NoticeBoardService noticeBoardService;
	@RequestMapping("notice_board.ymv")
	public ModelAndView noticeBoard(String pageNo) {	
		System.out.println("controller pageNo: "+pageNo);
		ListVO lvo = noticeBoardService.getNoticeBoardList(pageNo);
		System.out.println(lvo+"컨틀롤러");
		return new ModelAndView("notice_board","lvo",lvo);
	}
   @RequestMapping("notice_register_view.ymv")
   public ModelAndView noticeRegisterView(){
	   
	   return new ModelAndView("notice_register_view");
   }
   @RequestMapping("notice_register.ymv")
   public ModelAndView noticeRegister(NoticeBoardVO vo){
	   noticeBoardService.registerNoticeBoard(vo);
	   return new ModelAndView("redirect:notice_board.ymv");
   }
   @RequestMapping("notice_showContent.ymv")
   public String showContentReview(HttpServletRequest request,Model model){
      int boardNo=Integer.parseInt(request.getParameter("boardNo"));
      System.out.println("boardNo:"+boardNo);
      BoardVO rvo=noticeBoardService.getNoticeBoardByBoardNo(boardNo);
      model.addAttribute("rvo", rvo);
      return "notice_show_content";
   }
   @RequestMapping("notice_board_update_view.ymv")
	public ModelAndView noticeBoardUpdateView(int boardNo) {
		System.out.println("boardNo 는 "+boardNo);
		NoticeBoardVO noticebvo = (NoticeBoardVO) noticeBoardService.getNoticeBoardByBoardNo(boardNo);
		System.out.println("noticebvo 는 " + noticebvo);
		return new ModelAndView("notice_board_update_view","rvo"
				,noticebvo);
	}
   @RequestMapping("notice_board_update.ymv")
	public ModelAndView noticeBoardUpdate(NoticeBoardVO vo){
		ModelAndView mv=new ModelAndView();
		noticeBoardService.noticeBoardUpdate(vo);
		mv.setViewName("redirect:notice_showContent.ymv?boardNo="+vo.getBoardNo());
		mv.addObject("rvo", vo);
		return mv;
	}
   @RequestMapping("notice_board_delete.ymv")
	public ModelAndView noticeBoardDelete(String boardNo){
		noticeBoardService.noticeBoardDelete(boardNo);
		return new ModelAndView("redirect:notice_board.ymv");
	}
}