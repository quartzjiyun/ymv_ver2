package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.log5j.ymv.exception.DuplicateIdException;
import org.log5j.ymv.model.member.MemberService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateService;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//병준
	
	@RequestMapping(value="member_register_form.ymv",method=RequestMethod.GET)
	public ModelAndView memberRegisterForm(){	
		// Validation 을 위해 register_form.jsp 에서 사용할 수 있도록 객체를 생성해 전달한다. 
		//<form:form action="register.do" commandName="memberVO">
		return new ModelAndView("member_register_form","memberVO",new MemberVO());
	}
	@RequestMapping("member_register.ymv")
	public ModelAndView memberRegister(String identityNo, String memberType){	
		MemberVO memberVO = new MemberVO();
		memberVO.setIdentityNo(identityNo);
		memberVO.setMemberType(memberType);
		return new ModelAndView("member_register_form_detail","memberVO",memberVO);
	}
	@RequestMapping("member_register_idcheck.ymv")
	@ResponseBody
	public boolean memberRegisterIdcheck(MemberVO memberVO) {	
		boolean flag = true;
		try {
			memberService.idCheck(memberVO.getId());
		} catch (DuplicateIdException e) {
			flag = false;
			return flag;
		}
		return flag;
	}
	@RequestMapping(value="member_register_validation.ymv",method=RequestMethod.POST)
	public ModelAndView register(@Valid MemberVO memberVO,BindingResult result){
		System.out.println(memberVO);
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		try {
			if(!memberVO.getId().equals(null)){
			memberService.idCheck(memberVO.getId());
			}
		} catch (DuplicateIdException e) {
		}
		finally{
			if(result.hasErrors()){
				mv.setViewName("member_register_form_detail");
				mv.addObject("memberVO", memberVO);
				return mv;
			}
			memberService.registerMember(memberVO);
			mv.setViewName("member_register_result");
		}
		return mv;// 문제 없으면 결과 페이지로 이동한다. 
	}
}
