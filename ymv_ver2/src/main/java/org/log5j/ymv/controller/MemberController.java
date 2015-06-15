package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.member.MemberService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateService;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Resource(name="voluntaryServiceApplicateServiceImpl")
	private VoluntaryServiceApplicateService voluntaryServiceApplicateService;
	
	@Resource(name="memberServiceImpl")
	private MemberService memberService;

	/*
	 * 로그인부분
	 */
	@RequestMapping("login.ymv")
	public ModelAndView login(HttpServletRequest request,MemberVO  vo) {	
		System.out.println("memberVO:"+vo);
		MemberVO mvo=memberService.login(vo);
		String loginSession="";
		if(mvo!=null){
			request.getSession().setAttribute("mvo", mvo);
			System.out.println("로그인 mvo:"+mvo);
			loginSession="Y";
		}else{
			loginSession="X";
		}
		return new ModelAndView("home","loginSession",loginSession);
	}
	
	@RequestMapping("logout.ymv")
	public ModelAndView logout(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		return new ModelAndView("home");
	}
	
	//지윤 끝
	
	
	@RequestMapping("voluntary_register_applicant.ymv")
	@ResponseBody
	public boolean voluntary_register_applicant(VoluntaryServiceApplicateVO vsavo){
		boolean flag =  voluntaryServiceApplicateService.checkVolunteerApplicant(vsavo.getRecruitNo(), vsavo.getMemberNo());
		System.out.println("111111111"+flag);
		if(flag==false){
			System.out.println("registerVolunteerApplicant 실행  " + vsavo);
			voluntaryServiceApplicateService.registerVolunteerApplicant(vsavo);
		}
		return flag;
	}
}
