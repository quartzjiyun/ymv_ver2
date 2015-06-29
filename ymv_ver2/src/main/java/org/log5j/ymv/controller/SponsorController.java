package org.log5j.ymv.controller;

import java.io.File;
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

@Controller
public class SponsorController {
	@Resource
	private SponsorService sponsorService;
	@Resource(name = "uploadPath")
	private String path;

	@RequestMapping("sponsor_board.ymv")
	@NoLoginCheck
	public ModelAndView getSponsorList(String pageNo) {
		ListVO lvo = sponsorService.getSponsorList(pageNo);
		List<PictureVO> pvo = sponsorService.getPictureList(pageNo);
		return new ModelAndView("sponsor_board", "lvo", lvo).addObject("pvo",
				pvo);
	}

	@RequestMapping("sponsor_register_view.ymv")
	public String sponsorRegisterView() {
		return "sponsor_register_view";
	}

	@RequestMapping("sponsor_register.ymv")
	public ModelAndView registerSponsor(SponsorVO spvo, PictureVO pvo) {
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
		return new ModelAndView("redirect:testTiles.ymv");
	}

	@RequestMapping("sponsor_board_admin.ymv")
	public ModelAndView getSponsorListAdmin(String pageNo) {
		ListVO lvo = sponsorService.getSponsorList(pageNo);
		List<PictureVO> pvo = sponsorService.getPictureList(pageNo);
		return new ModelAndView("sponsor_board_admin", "lvo", lvo).addObject(
				"pvo", pvo);
	}

	@RequestMapping("sponsor_update_view.ymv")
	public ModelAndView updateSponsorView(SponsorVO spvo) {
		spvo = sponsorService.findSponsorByBoardNo(spvo.getBoardNo());
		return new ModelAndView("sponsor_update_view", "spvo", spvo);
	}

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

	@RequestMapping("sponsor_delete.ymv")
	public ModelAndView deleteSponsorByBoardNo(SponsorVO spvo) {
		sponsorService.deleteSponsorByBoardNo(spvo.getBoardNo());
		sponsorService.deletePicture(spvo.getBoardNo());
		return new ModelAndView("redirect:sponsor_board_admin.ymv");
	}

	@RequestMapping("sponsor_update_currentPrice")
	public ModelAndView updateSponsorCurrentPrice(SponsorVO spvo) {
		sponsorService.updateSponsorCurrentPrice(spvo);
		return new ModelAndView("redirect:sponsor_board.ymv");
	}
}
