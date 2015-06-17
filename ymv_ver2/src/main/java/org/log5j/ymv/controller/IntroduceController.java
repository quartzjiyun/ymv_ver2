package org.log5j.ymv.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class IntroduceController {
	@RequestMapping("introduce_ymv.ymv")
	public ModelAndView introduce() {	
		return new ModelAndView("introduce_ymv");
	}
	@RequestMapping("introduce_how_ymv.ymv")
	public ModelAndView howToIntroduce(){
		return new ModelAndView("introduce_how_ymv");
	}
	@RequestMapping("introduce_administrator.ymv")
	public ModelAndView introduceAdministrator(){
		return new ModelAndView("introduce_administrator");
	}
	@RequestMapping("introduce_map.ymv")
	public ModelAndView introduceMap(){
		return new ModelAndView("introduce_map");
	}
}
