package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.QnABoardService;
import org.log5j.ymv.model.board.QnABoardVO;
import org.log5j.ymv.model.member.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QnABoardController {
	@Resource(name="qnABoardServiceImpl")
	private QnABoardService qnABoardService;
	
	@RequestMapping("qna_board.ymv")
	public ModelAndView getQnABoardList(String pageNo) {	
		ListVO lvo=qnABoardService.getQnABoardList(pageNo);
		return new ModelAndView("qna_board","lvo",lvo);
	}
	
	@RequestMapping("qna_register_view.ymv")
	public ModelAndView QnARegisterView(){
		return new ModelAndView("qna_register_view");
	}
	
	@RequestMapping("qna_register.ymv")
	public String Register_QnA(HttpServletRequest request,QnABoardVO qvo){
		HttpSession session=request.getSession(false);
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		qvo.setWriter(mvo.getName());
		qvo.setMemberNo(mvo.getMemberNo());
		qnABoardService.registerQnABoard(qvo);
		return "redirect:qna_showContent.ymv?qnaNo=" + qvo.getQnaNo();
	}
	@RequestMapping("qna_showContent.ymv")
	   public ModelAndView showContentQnAVol(HttpServletRequest request){
	      int qnaNo=Integer.parseInt(request.getParameter("qnaNo"));
	      QnABoardVO qvo=qnABoardService.getQnABoardByQnANo(qnaNo);
	      return new ModelAndView("qna_show_content","qvo",qvo);
	   }
	@RequestMapping("qna_board_update_view.ymv")
	   public ModelAndView updateQnAView(int qnaNo) {
	  QnABoardVO qvo = (QnABoardVO) qnABoardService.getQnABoardByQnANo(qnaNo);
	  return new ModelAndView("qna_board_update_view","qvo",qvo);
	}
	@RequestMapping("qna_board_update.ymv")
	   public ModelAndView qna_board_update(HttpServletRequest request, QnABoardVO qnABoardVO) {
	      System.out.println("수정받은 qnABoardVO "+qnABoardVO);
	      qnABoardService.updateQnABoard(qnABoardVO);
	      int qnaNo=qnABoardVO.getQnaNo();
	      return new ModelAndView("qna_show_content","qvo",qnABoardService.getQnABoardByQnANo(qnaNo));
	   }
	@RequestMapping("qna_delete.ymv")
	public ModelAndView DeleteQnABoard(HttpServletRequest request) {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));		
		qnABoardService.deleteQnABoard(qnaNo);
		return new ModelAndView("redirect:/qna_board.ymv?pageNo=1");
	}
	@RequestMapping("qna_reply_view.ymv")
	public ModelAndView qnAReplyView(QnABoardVO qvo) {
		qvo = qnABoardService.getQnABoardByQnANo(qvo.getQnaNo());
		return new ModelAndView("qna_reply_view", "qvo", qvo);
	}
	@RequestMapping("qna_reply.ymv")
	public ModelAndView qnAReply(HttpServletRequest request,QnABoardVO qvo) throws Exception{		
		HttpSession session=request.getSession(false);
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		qvo.setMemberNo(mvo.getMemberNo());
		qvo.setWriter(mvo.getName());
		qnABoardService.replyQnABoard(qvo);
		return new ModelAndView("redirect:/qna_showContent.ymv?qnaNo="+qvo.getQnaNo());
	}
	
}
