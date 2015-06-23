package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	@NoLoginCheck
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
	/*@RequestMapping("qna_showContent.ymv")
	@NoLoginCheck
	   public ModelAndView showContentQnAVol(HttpServletRequest request){
	      int qnaNo=Integer.parseInt(request.getParameter("qnaNo"));
	      QnABoardVO qvo=qnABoardService.getQnABoardByQnANo(qnaNo);
	      return new ModelAndView("qna_show_content","qvo",qvo);
	   }*/
	
	@RequestMapping("qna_showContent.ymv")
	@NoLoginCheck
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qnaNo=Integer.parseInt(request.getParameter("qnaNo"));
		QnABoardVO qvo = null;
		// 개별 게시물 조회 ( 조회수 증가 )
		Cookie cookies[] = request.getCookies();
		Cookie cookie = null;

		if (cookies == null || cookies.length == 0) {
			cookie = new Cookie("myboard", "|" + qnaNo + "|");
			response.addCookie(cookie);
			System.out.println(" 쿠키가 존재하지 않은 상태");

		} else {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("myboard")) {
					cookie = cookies[i];
					break;
				}
			}
			if (cookie == null) {
				// 쿠키가 존재하는데 myboard가 없을때
				cookie = new Cookie("myboard", "|" + qnaNo + "|");
				response.addCookie(cookie);
				qvo = qnABoardService.getPostingByQnaNoUpdateHit(qnaNo);
				System.out.println("쿠키가 존재하지만 myboard 쿠키가 존재하지 않은 상태");
			} else {// 쿠키가 존재하는데 myboard가 있을때
				String value = cookie.getValue();
				System.out.println("쿠키 존재하고 myboard 쿠키가 존재하는 상태");
				if (value.indexOf("|" + qnaNo + "|") != -1) {
					// myboard cookie의 value 정보에서 해당 게시글 번호가 존재하는 상태
					System.out.println("myboard 쿠키에 해당 게시글 번호가 존재..조회수 증가x");
					qnABoardService.getPostingByQnaNoNotHit(qnaNo);

				} else {
					// myboard cookie의 value 정보에서 해당 게시글 번호가 존재하지 않은 상태
					value += "|" + qnaNo + "|";
					System.out.println("myboard 쿠키에 해당 게시글 번호가 존재x..조회수 증가0");
					qvo = qnABoardService.getPostingByQnaNoUpdateHit(qnaNo);
	
					response.addCookie(new Cookie("myboard", value));
				}// else1
			}// else2
		}// else3
		qvo = qnABoardService.getQnABoardByQnANo(qnaNo);
		return new ModelAndView("qna_show_content", "qvo", qvo);
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
