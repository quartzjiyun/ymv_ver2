package org.log5j.ymv.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.sponsor.SponsorService;
import org.log5j.ymv.model.sponsor.SponsorVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
/**
 * 후원할 수 있는 게시판
 * @author jjh
 *
 */
@Controller
public class SponsorController {
	@Resource
	private SponsorService sponsorService;
	@Resource(name = "uploadPath")
	private String path;
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 현재 시간과 게시글의 시간을 비교하여 후원완료와 후원중으로 분류하고 페이지에 해당하는 후원글들을 반환한다. 
	 * @param pageNo : 페이지 번호를 받아온다.
	 * @return
	 */
	@RequestMapping("sponsor_board.ymv")
	@NoLoginCheck
	public ModelAndView findSponsorList(String pageNo) {
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		ListVO lvo = sponsorService.findSponsorList(pageNo);
		List<PictureVO> pvo = sponsorService.findPictureList(pageNo);
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((SponsorVO) lvo.getList().get(i)).getEndDate());
			if(compare > 0){
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원완료");
			}else if(compare < 0){
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원중");
			}else{
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원중");
			}
		}
		return new ModelAndView("sponsor_board").addObject("lvo", lvo).addObject("pvo", pvo);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 :  후원글 등록 페이지로 이동한다.
	 * @return
	 */
	@RequestMapping("sponsor_register_view.ymv")
	public String sponsorRegisterView() {
		return "sponsor_register_view";
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 사진을 서버에 업로드하고 상세정보와 사진정보를 등록한다.
	 * @param spvo : 후원게시판 상세정보를 받아온다.
	 * @param pvo : 사진정보를 받아온다.
	 * @return
	 */
	@RequestMapping("sponsor_register.ymv")
	public ModelAndView sponsorRegister(SponsorVO spvo, PictureVO pvo) {
		sponsorService.registerSponsor(spvo);
		MultipartFile file = pvo.getFileName();
		String fileName = "[" + spvo.getBoardNo() + "]"
				+ file.getOriginalFilename();
		String filePath = "upload\\" + fileName;
		pvo.setFilePath(filePath);
		pvo.setPictureNo(spvo.getBoardNo());
		if (!fileName.equals("")) {
			try {
				file.transferTo(new File(path + fileName));
				System.out.println("PictureNo: " + pvo.getPictureNo()
						+ " fileName: " + pvo.getFileName());
				sponsorService.registerPicture(pvo);
				System.out.println("fileupload ok:" + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:sponsor_board_admin.ymv");
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 페이지번호에 해당하는 관리자용 후원게시판 정보를 받아 반환한다.
	 * @param pageNo : 페이지 번호를 받아온다
	 * @return
	 */
	@RequestMapping("sponsor_board_admin.ymv")
	public ModelAndView findSponsorListAdmin(String pageNo) {
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		ListVO lvo = sponsorService.findSponsorList(pageNo);
		List<PictureVO> pvo = sponsorService.findPictureList(pageNo);
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((SponsorVO) lvo.getList().get(i)).getEndDate());
			if(compare > 0){
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원완료");
			}else if(compare < 0){
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원중");
			}else{
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원중");
			}
		}
		return new ModelAndView("sponsor_board_admin").addObject("lvo", lvo).addObject("pvo", pvo);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시글 번호로 조회하고 게시글의 정보를 수정페이지(sponsor_update_view.jsp)으로 반환한다.
	 * @param spvo : 해당 게시글의 글번호를 받아오기 위해 사용
	 * @return
	 */
	@RequestMapping("sponsor_update_view.ymv")
	public ModelAndView updateSponsorView(SponsorVO spvo) {
		spvo = sponsorService.findSponsorByBoardNo(spvo.getBoardNo());
		return new ModelAndView("sponsor_update_view", "spvo", spvo);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시물을 수정한 후 글번호를 이용해 redirect 사용하여 상세글보기로 이동
	 * @param spvo : 후원게시글의 수정된 상세 정보를 받아옴.
	 * @param pvo : 게시판의 사진정보를 받아온다.
	 * @return
	 */
	@RequestMapping("sponsor_update.ymv")
	public ModelAndView updateSponsor(SponsorVO spvo, PictureVO pvo) {
		sponsorService.updateSponsorByBoardNo(spvo);
		MultipartFile file = pvo.getFileName();
		String fileName = "[" + spvo.getBoardNo() + "]"
				+ file.getOriginalFilename();
		String filePath = "upload\\" + fileName;
		pvo.setFilePath(filePath);
		pvo.setPictureNo(spvo.getBoardNo());
		if (!fileName.equals("")) {
			try {
				file.transferTo(new File(path + fileName));
				System.out.println("PictureNo: " + pvo.getPictureNo()
						+ " fileName: " + pvo.getFileName());
				sponsorService.registerPicture(pvo);
				System.out.println("fileupload ok:" + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:sponsor_board_admin.ymv");
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시글을 삭제한다. 해당 글을 참조하고 있는 사진도 삭제한다.
	 * @param spvo : 해당 게시글의 글번호를 받아오기 위해 사용
	 * @return
	 */
	@RequestMapping("sponsor_delete.ymv")
	public ModelAndView deleteSponsorByBoardNo(SponsorVO spvo) {
		sponsorService.deleteSponsorByBoardNo(spvo.getBoardNo());
		sponsorService.deletePicture(spvo.getBoardNo());
		return new ModelAndView("redirect:sponsor_board_admin.ymv");
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 해당 게시글의 현재 모집액을 입력된 모집액과 합산하여 수정한다.
	 * @param spvo : 해당 게시글의 글번호와 현재 모집액을 받아오기 위해 사용
	 * @return
	 */
	@RequestMapping("sponsor_update_currentPrice")
	public ModelAndView updateSponsorCurrentPrice(SponsorVO spvo) {
		sponsorService.updateSponsorCurrentPrice(spvo);
		return new ModelAndView("redirect:sponsor_board.ymv");
	}
}
