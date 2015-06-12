package org.log5j.ymv.controller;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.ReviewBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JJHController {
	@Resource
	private ReviewBoardService reviewBoardService;
	@RequestMapping("registerReviewComment")
	public String registerReviewComment(){
		return "";
	}
}
