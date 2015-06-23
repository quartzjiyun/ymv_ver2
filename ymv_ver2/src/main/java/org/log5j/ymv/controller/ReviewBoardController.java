package org.log5j.ymv.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.CommentVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.board.ReviewBoardService;
import org.log5j.ymv.model.board.ReviewBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewBoardController {
	@Resource
	private ReviewBoardService reviewBoardService;
	@Resource(name="uploadPath")
	private String path;
	
	@RequestMapping("home.ymv")
	@NoLoginCheck
	public String test(){
		return "index";
	}
	@RequestMapping("loginCheck.ymv")
	@NoLoginCheck
	public String loginCheck(){
		return "loginCheck";
	}
	@RequestMapping("testTiles.ymv")
	@NoLoginCheck
	public String testTiles(){
		return "home";
	}
	@RequestMapping("review_board.ymv")
	@NoLoginCheck
	public ModelAndView reviewBoard(String pageNo) {	
		ListVO lvo = reviewBoardService.getBoardList(pageNo);
		System.out.println(lvo+"컨틀롤러");
		return new ModelAndView("review_board","lvo",lvo);
	}
	/*@RequestMapping("review_showContent.ymv")
	@NoLoginCheck
	   public String showContentReview(HttpServletRequest request,Model model){
	      int boardNo=Integer.parseInt(request.getParameter("boardNo"));
	      int pictureNo=boardNo;
	      System.out.println("boardNo:"+boardNo);
	      BoardVO rvo=reviewBoardService.getReviewBoardByBoardNo(boardNo);
	      List<CommentVO> commentList=reviewBoardService.findByCommentNo(request.getParameter("boardNo"));
	      System.out.println("pictureNo: "+pictureNo);
	      PictureVO pvo=reviewBoardService.getPicture(pictureNo);
	      if(pvo!=null){
	    	  model.addAttribute("pvo",pvo);
	      }
	      System.out.println("pvo: " + pvo);
	      model.addAttribute("rvo", rvo).addAttribute("commentList", commentList);
	      return "review_show_content";
	   }*/
	

	@RequestMapping("review_showContent.ymv")
	@NoLoginCheck
	 public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		 int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		 System.out.println("review_showContent boardNo: " + boardNo);
		 int pictureNo=boardNo;
		BoardVO bvo=null;
		// 개별 게시물 조회 ( 조회수 증가 )
		Cookie cookies[] = request.getCookies();
		Cookie cookie = null;

		if (cookies == null || cookies.length == 0) {
			cookie = new Cookie("myboard", "|" + boardNo + "|");
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
				cookie = new Cookie("myboard", "|" + boardNo + "|");
				response.addCookie(cookie);
				reviewBoardService.getPostingByNoticeBoardNoUpdateHit(boardNo);//BoardDAO.getInstance().updateHit(boardNo);
			/*	BoardVO bvo=reviewBoardService.getReviewBoardByBoardNo(boardNo);//vo = BoardDAO.getInstance().getPostingByNo(boardNo);*/				
				System.out.println("쿠키가 존재하지만 myboard 쿠키가 존재하지 않은 상태");
			} else {// 쿠키가 존재하는데 myboard가 있을때
				String value = cookie.getValue();
				System.out.println("쿠키 존재하고 myboard 쿠키가 존재하는 상태");
				if (value.indexOf("|" + boardNo + "|") != -1) {
					// myboard cookie의 value 정보에서 해당 게시글 번호가 존재하는 상태
					System.out.println("myboard 쿠키에 해당 게시글 번호가 존재..조회수 증가x");
					//vo = BoardDAO.getInstance().getPostingByNo(boardNo);
				} else {
					// myboard cookie의 value 정보에서 해당 게시글 번호가 존재하지 않은 상태
					value += "|" + boardNo + "|";
					System.out.println("myboard 쿠키에 해당 게시글 번호가 존재x..조회수 증가0");
					reviewBoardService.getPostingByNoticeBoardNoUpdateHit(boardNo);//BoardDAO.getInstance().updateHit(boardNo);
					//vo = BoardDAO.getInstance().getPostingByNo(boardNo);
					response.addCookie(new Cookie("myboard", value));
				}// else1
			}// else2
			
		}// else3
		bvo=reviewBoardService.getReviewBoardByBoardNo(boardNo);//vo = BoardDAO.getInstance().getPostingByNo(boardNo);
		List<CommentVO> commentList=reviewBoardService.findByCommentNo(request.getParameter("boardNo"));
		PictureVO pvo=reviewBoardService.getPicture(pictureNo);
		System.out.println("review_showContent commentList : "+ commentList);
		if(pvo!=null){
			mv.addObject("pvo",pvo);
	    }
		mv.addObject("rvo", bvo).addObject("commentList", commentList);
		mv.setViewName("review_show_content");
		 return mv;
}
	
	
	@RequestMapping("register_review_comment.ymv")
	public String registerReviewComment(HttpServletRequest request,CommentVO cmvo){
		reviewBoardService.registerReviewComment(cmvo);
		System.out.println(cmvo+" register_review_comment.ymv");
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
		int pictureNo=Integer.parseInt(boardNo);
		reviewBoardService.deletePicture(pictureNo);
		return new ModelAndView("redirect:review_board.ymv");
	}
	
	@RequestMapping("review_register_view.ymv")
	public ModelAndView reviewRegisterView(){
		
		return new ModelAndView("review_register_view");
	}
	@RequestMapping("review_register.ymv")
	public ModelAndView reviewRegister(ReviewBoardVO vo,PictureVO pvo){
		System.out.println("ReviewBoardVO: "+vo);
		reviewBoardService.registerReviewBoard(vo);
		System.out.println("userInfo:"+vo.getBoardNo());
		MultipartFile file=pvo.getFileName();
		/*
		 *  파일 얻는 메서드  : list.get(i) 을 호출하면 File이 반환 
		 *  실제 디렉토리로 전송(업로드) 메서드 : 파일.transferTo(파일객체)
		 *  ModelAndView 에서 결과 페이지로 업로드한 파일 정보를 문자열배열로
		 *  할당해 jsp에서 사용하도록 한다. 
		 */
		/*ArrayList<String> nameList=new ArrayList<String>();
		for(int i=0;i<list.size();i++){*/
			//System.out.println(list.get(i).getOriginalFilename().equals(""));
			String fileName="["+vo.getBoardNo()+"]"+file.getOriginalFilename();			
			String filePath="upload\\"+fileName;
			pvo.setFilePath(filePath);
			pvo.setPictureNo(vo.getBoardNo());
			if(!fileName.equals("")){
				try {
					file.transferTo(new File(path+fileName));
					// 픽쳐 디비에 파일정보 저장
					System.out.println("PictureNo: "+pvo.getPictureNo()+" fileName: "+pvo.getFileName());
					reviewBoardService.registerPicture(pvo);
					/*nameList.add(fileName);*/
					System.out.println("fileupload ok:"+fileName);
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}

		return new ModelAndView("redirect:review_board.ymv");
}
}
