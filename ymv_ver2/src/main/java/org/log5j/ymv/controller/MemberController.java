package org.log5j.ymv.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.member.MemberService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateService;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Resource(name="voluntaryServiceApplicateServiceImpl")
	private VoluntaryServiceApplicateService voluntaryServiceApplicateService;
	
	@Resource(name="memberServiceImpl")
	private MemberService memberService;

	@Resource(name="uploadProfilePath")
	private String path;
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
		System.out.println(vsavo);
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
		if(memberType.equals("company")){
			return new ModelAndView("member_register_form_company_detail","memberVO",memberVO);
		}
		return new ModelAndView("member_register_form_detail","memberVO",memberVO);
	}

	@RequestMapping("member_register_idcheck.ymv")
	@ResponseBody
	public boolean memberRegisterIdcheck(MemberVO memberVO) {
		boolean flag = true;

		String idcheck = memberService.idCheck(memberVO.getId());
		if(idcheck.equals("ok")){
			return flag;
		}else{
			flag = false;
		}
		return flag;
	}

	@RequestMapping(value = "member_register_validation.ymv", method = RequestMethod.POST)
	public ModelAndView register(@Valid MemberVO memberVO, BindingResult result, PictureVO pvo) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("member_register_form_detail");
			mv.addObject("memberVO", memberVO);
			return mv;
		}
		memberService.registerMember(memberVO);
		
		mv.setViewName("member_register_result");
		return mv;// 문제 없으면 결과 페이지로 이동한다.
	}
	@RequestMapping("member_profileUpload.ymv")
	public ModelAndView profileUpload(HttpServletRequest request, PictureVO pvo){
		MemberVO memberVO=(MemberVO)request.getSession().getAttribute("mvo");
		System.out.println("memberVO.getMemberNo : "+memberVO.getMemberNo());
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
			String fileName="[memberNo"+memberVO.getMemberNo()+"]"+file.getOriginalFilename();			
			String filePath="profileupload\\"+fileName;
/*			memberVO.setFilePath(filePath);
			pvo.setPictureNo(memberVO.getMemberNo());*/
			if(!fileName.equals("")/*&&(fileName.contains(".jpg")||fileName.contains(".png") )*/){
				try {
					memberVO.setFilePath(filePath);
					pvo.setPictureNo(memberVO.getMemberNo());
					file.transferTo(new File(path+fileName));
					// 픽쳐 디비에 파일정보 저장
					System.out.println("PictureNo: "+pvo.getPictureNo()+" fileName: "+pvo.getFileName());
					memberService.profileUpdate(memberVO);
					/*nameList.add(fileName);*/
					System.out.println("fileupload ok:"+fileName);
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
		return new ModelAndView("home");
	}
	
	@RequestMapping("member_update_form.ymv")
	public ModelAndView memberUpdateForm(HttpServletRequest request){
		return new ModelAndView("member_update_form");
	}
	@RequestMapping("member_update.ymv")
	public ModelAndView memberUpdate(HttpServletRequest request, MemberVO mvo){
		HttpSession session=request.getSession(false);
		/*MemberVO smvo=(MemberVO)session.getAttribute("mvo");*/
		memberService.updateMember(mvo);
		System.out.println("mvo전:"+mvo);
		System.out.println("mvo 멤버 memberNo:"+mvo.getMemberNo());
		mvo=memberService.findMemberByMemberNo(mvo.getMemberNo());
		System.out.println("mvo후:"+mvo);
		session.setAttribute("mvo",mvo);
		return new ModelAndView("member_update","mvo",mvo);
	}
}
