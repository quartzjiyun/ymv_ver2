package org.log5j.ymv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("home.ymv")
	public String test(){
		return "index";
	}
	@RequestMapping("testTiles.ymv")
	public String testTiles(){
		return "home";
	}
	
}
