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
import org.springframework.dao.DuplicateKeyException;
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
	
	/**
	 * 작성자 : 백지영, 장지윤
	 * 내용 : 로그인 메서드를 수행해 id와 password에 해당하는 회원정보를 가져온다.
	 * 				가져 온 회원정보가 null이 아니라면 세션이 있는지 없는지 확인 후 
	 * 				세션이 없다면 세션을 만들어주고 loginSession에 Y를 할당한다.
	 * 				null이라면 loginSession에 X를 할당한다.
	 * 				"home.jsp"로 보내주고 loginSession이라는 이름의 세션도 함께 보낸다.
	 * @param request : 세션 유무를 확인하기 위해 사용
	 * @param vo : id와 password를 같이 담기 위해서 사용
	 * @return 
	 */
	@RequestMapping("login.ymv")
	@NoLoginCheck
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
	
	/**
	 * 작성자 : 백지영, 장지윤
	 * 내용 : 만약 세션이 null이 아니라면 세션을 해제 한 후 "home.jsp"로 보내준다.
	 * @param request : 세션 유무를 확인하기 위해 사용
	 * @return 
	 */
	@RequestMapping("logout.ymv")
	@NoLoginCheck
	public ModelAndView logout(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		return new ModelAndView("home");
	}
	
	//지윤 끝
	
	/**
	 * 작성자 : 백지영
	 * 내용 : checkVolunteerApplicant를 수행해 회원번호와 글번호에 해당하는 사람이 있다면 true를 없다면 false를 반환한다.
	 * 				만약 false를 반환할 경우 registerVolunteerApplicant를 수행해 신청자리스트에 insert한다.
	 * @param vsavo : 글번호와 회원번호를 같이 담아오기 위해 사용
	 * @return boolean
	 */
	@RequestMapping("voluntary_register_applicant.ymv")
	@ResponseBody
	public boolean voluntaryRegisterApplicant(VoluntaryServiceApplicateVO vsavo){
		boolean flag =  voluntaryServiceApplicateService.checkVolunteerApplicant(vsavo.getRecruitNo(), vsavo.getMemberNo());
		if(flag==false){
			voluntaryServiceApplicateService.registerVolunteerApplicant(vsavo);
		}
		return flag;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 회원가입 폼이 있는 페이지로 넘겨준다.
	 * @return
	 */
	@RequestMapping(value="member_register_form.ymv",method=RequestMethod.GET)
	@NoLoginCheck
	public ModelAndView memberRegisterForm(){	
		// Validation 을 위해 register_form.jsp 에서 사용할 수 있도록 객체를 생성해 전달한다. 
		//<form:form action="register.do" commandName="memberVO">
		return new ModelAndView("member_register_form","memberVO",new MemberVO());
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 일반회원의 경우에는 생년월일을 입력받아 "member_register_form_detail.jsp"로 보내준다.
	 * 				기업회원의 경우에는 사업자등록번호를 입력받아 "member_register_form_detail.jsp"로 보내준다.
	 * @param identityNo : 생년월일이나 사업자등록번호를 입력하기 위해 사용
	 * @param memberType : 기업회원인지 일반회원인지 구분하기 위해 사용
	 * @return
	 */
	@RequestMapping("member_register.ymv")
	@NoLoginCheck
	public ModelAndView memberRegister(String identityNo, String memberType){	
		MemberVO memberVO = new MemberVO();
		memberVO.setIdentityNo(identityNo);
		memberVO.setMemberType(memberType);
		return new ModelAndView("member_register_form_detail","memberVO",memberVO);
	}

	/**
	 * 작성자 : 박병준
	 * 내용 : validation과 idcheck를 동시에 수행하고 있다. 
	 *  validation을 통해 에러가 발생하면 정보들을 vo에 담아 다시 보내주고
	 *  에러가 없다면 글 등록을 하게된다. 이 때 id가 중복되게 되면
	 *   DuplicateKeyException이 발생하는데 이 때 이 exception을 catch해서
	 *   ModelAndView에 정보를 담아 보내준다. 문제가 없으면 member_register_result.jsp로 넘어간다.
	 * @param memberVO
	 * @param result
	 * @param pvo
	 * @return
	 */
	@RequestMapping(value = "member_register_validation.ymv", method = RequestMethod.POST)
	@NoLoginCheck
	public ModelAndView register(@Valid MemberVO memberVO,
			BindingResult result, PictureVO pvo) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("member_register_form_detail");
			mv.addObject("memberVO", memberVO);
			return mv;
		}
		try {
			memberService.registerMember(memberVO);
		} catch (DuplicateKeyException de) {
			mv.setViewName("member_register_form_detail");
			mv.addObject("info", "아이디 중복됩니다.");
			return mv;
		}
		mv.setViewName("member_register_result");
		return mv;// 문제 없으면 결과 페이지로 이동한다.
	}
	/**
	 * 
	 * 작성자 : 임영학
	 * 내용 : 
	 * @param request
	 * @param pvo
	 * @return
	 */
	@RequestMapping("member_profileUpload.ymv")
	public ModelAndView profileUpload(HttpServletRequest request, PictureVO pvo){
		MemberVO memberVO=(MemberVO)request.getSession().getAttribute("mvo");
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
					memberService.updateProfile(memberVO);
					/*nameList.add(fileName);*/
					System.out.println("fileupload ok:"+fileName);
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
		return new ModelAndView("home");
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 회원수정폼이 있는 페이지로 보내준다.
	 * @return
	 */
	@RequestMapping("member_update_form.ymv")
	public ModelAndView memberUpdateForm(HttpServletRequest request){
		return new ModelAndView("member_update_form");
	}
	
	/**
	 * 작성자 : 백지영, 박병준
	 * 내용 : 회원정보 수정 폼에서 수정된 회원 정보들을 받아와서 updateMember를 사용해 회원정보를 수정한다.
	 * 				현재 회원의 회원번호를 사용해서 회원의 정보를 찾는다.
	 * 				바뀐 회원의 정보를 세션에 setting해주고 "member_update.jsp"로 보내준다.
	 * @param request : 세션의 유무를 확인하기 위해 사용
	 * @param mvo : 회원정보 수정 폼에서 수정된 회원 정보들을 같이 담기 위해 사용
	 * @return
	 */
	@RequestMapping("member_update.ymv")
	public ModelAndView memberUpdate(HttpServletRequest request, MemberVO mvo){
		HttpSession session=request.getSession(false);
		/*MemberVO smvo=(MemberVO)session.getAttribute("mvo");*/
		memberService.updateMember(mvo);
		mvo=memberService.findMemberByMemberNo(mvo.getMemberNo());
		session.setAttribute("mvo",mvo);
		return new ModelAndView("member_update","mvo",mvo);
	}
}
