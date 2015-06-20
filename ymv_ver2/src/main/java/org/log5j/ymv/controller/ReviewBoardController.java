package org.log5j.ymv.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 int boardNo=Integer.parseInt(request.getParameter("boardNo"));
	      int pictureNo=boardNo;
		   ModelAndView model = new ModelAndView();
			ReviewBoardVO rvo = null;
			Cookie cookies[] = request.getCookies();
			Cookie cookie = null;
			String cookieValue = null;
			String cookieName =null;
					if (cookies == null || cookies.length == 0) {
				//그냥 쿠키 자체 없음
				cookieName = "hitcookie";
		        cookieValue = "|"+boardNo+"|";
				cookie = new Cookie(cookieName, cookieValue);
				response.addCookie(cookie);
			}else{
				//쿠키는 있음
				for(int i=0; i<cookies.length; i++){
					cookieName = "hitcookie";
					if(cookies[i].getName().equals(cookieName)){//쿠키있고 hitcookie있고
						reviewBoardService.getReviewBoardByBoardNo(boardNo);
						List<CommentVO> commentList=reviewBoardService.findByCommentNo(request.getParameter("boardNo"));
						PictureVO pvo=reviewBoardService.getPicture(pictureNo);
						if(pvo!=null){
							model.addObject("pvo",pvo);
					    }
						 model.addObject("rvo", rvo).addObject("commentList", commentList);
					}
				}
					String value = cookieValue;
			        value += "|"+boardNo+"|";
					cookie = new Cookie(cookieName, value);
					response.addCookie(cookie);
			}
			rvo = reviewBoardService.getPostingByNoticeBoardNoUpdateHit(boardNo);
			List<CommentVO> commentList=reviewBoardService.findByCommentNo(request.getParameter("boardNo"));
			PictureVO pvo=reviewBoardService.getPicture(pictureNo);
			 if(pvo!=null){
		    	  model.addObject("pvo", pvo);
		      }
			 model.addObject("rvo", rvo).addObject("commentList", commentList);
			//조회수 올라가게
			return new ModelAndView("review_show_content", "rvo", rvo);
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
