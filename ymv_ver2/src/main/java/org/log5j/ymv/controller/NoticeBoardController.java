package org.log5j.ymv.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.NoticeBoardService;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.PictureVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeBoardController {
	@Resource(name="uploadNoticePath")
	private String path;
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
   public ModelAndView noticeRegister(NoticeBoardVO vo,PictureVO pvo){
	   noticeBoardService.registerNoticeBoard(vo);
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
			String filePath="noticeupload\\"+fileName;
			pvo.setFilePath(filePath);
			pvo.setPictureNo(vo.getBoardNo());
			if(!fileName.equals("")){
				try {
					file.transferTo(new File(path+fileName));
					// 픽쳐 디비에 파일정보 저장
					System.out.println("PictureNo: "+pvo.getPictureNo()+" fileName: "+pvo.getFileName());
					noticeBoardService.registerPicture(pvo);
					/*nameList.add(fileName);*/
					System.out.println("fileupload ok:"+fileName);
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}

	   
	   return new ModelAndView("redirect:notice_board.ymv");
   }
   @RequestMapping("notice_showContent.ymv")
   public String showContentReview(HttpServletRequest request,Model model){
      int boardNo=Integer.parseInt(request.getParameter("boardNo"));
      int pictureNo=boardNo;
      System.out.println("boardNo:"+boardNo);
      BoardVO rvo=noticeBoardService.getNoticeBoardByBoardNo(boardNo);
      System.out.println("pictureNo: "+pictureNo);
      PictureVO pvo=noticeBoardService.getPicture(pictureNo);
      if(pvo!=null){
    	  model.addAttribute("pvo",pvo);
      }
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
