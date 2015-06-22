package org.log5j.ymv.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.board.CompanyVO;
import org.log5j.ymv.model.board.FieldVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.LocationVO;
import org.log5j.ymv.model.board.RecruitBoardService;
import org.log5j.ymv.model.board.RecruitBoardVO;
import org.log5j.ymv.model.member.MemberService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecruitBoardController {
	@Resource(name="recruitBoardServiceImpl")
	private RecruitBoardService recruitBoardService;
	@Resource(name="voluntaryServiceApplicateServiceImpl")
	private VoluntaryServiceApplicateService voluntaryServiceApplicateService;
	@Resource
	private MemberService memberService;
	
	@RequestMapping("voluntary_board.ymv")
	@NoLoginCheck
	public ModelAndView list(String pageNo) {	
		ListVO lvo = recruitBoardService.getBoardList(pageNo);
		return new ModelAndView("voluntary_board","lvo",lvo);
	}
	/*@RequestMapping("voluntary_showContentRecruitVol.ymv")
	@NoLoginCheck
	   public ModelAndView showContentRecruitVol(HttpServletRequest request){
	      int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	      RecruitBoardVO rvo=recruitBoardService.getRecruitBoardByRecruitNo(recruitNo);
	      return new ModelAndView("voluntary_show_content","rvo",rvo);
	   }*/
	
	@RequestMapping("voluntary_showContentRecruitVol.ymv")
	@NoLoginCheck
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noComp = request.getParameter("recruitNo");
		int recruitNo = Integer.parseInt(noComp);
		RecruitBoardVO rvo = null;
		Cookie cookies[] = request.getCookies();
		Cookie cookie = null;
		String cookieValue = null;
		String cookieName =null;
				if (cookies == null || cookies.length == 0) {
			//그냥 쿠키 자체 없음
			cookieName = "hitcookie";
	        cookieValue = "|"+recruitNo+"|";
			cookie = new Cookie(cookieName, cookieValue);
			response.addCookie(cookie);
		}else{
			//쿠키는 있음
			for(int i=0; i<cookies.length; i++){
				cookieName = "hitcookie";
				if(cookies[i].getName().equals(cookieName)){//쿠키있고 hitcookie있고
					recruitBoardService.getPostingByRecruitNoNotHit(recruitNo);
				}
			}
				String value = cookieValue;
		        value += "|"+recruitNo+"|";
				cookie = new Cookie(cookieName, value);
				response.addCookie(cookie);
		}
		rvo = recruitBoardService.getPostingByRecruitNoUpdateHit(recruitNo);
		//조회수 올라가게
		MemberVO vo=memberService.findMemberByMemberNo(rvo.getMemberNo());
	      System.out.println("rvo:"+rvo);
		return new ModelAndView("voluntary_show_content", "rvo", rvo).addObject("vo",vo);
	}
    
    @RequestMapping("voluntary_showContentRecruitVolType.ymv")
	   public ModelAndView showContentRecruitVolType(HttpServletRequest request){
    		HttpSession session=request.getSession();
    		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
    		String url="voluntary_show_content_company";
    		//List<VoluntaryServiceApplicateVO> list=null;
    		int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
    		if(mvo.getMemberType().equals("normal")){
    			url="voluntary_show_content_normal";
    			//list=voluntaryServiceApplicateService.getApplicantList(recruitNo);
                //System.out.println("list:"+list);

    		}
	      
	      RecruitBoardVO rvo=recruitBoardService.getRecruitBoardByRecruitNo(recruitNo);
	      MemberVO vo=memberService.findMemberByMemberNo(rvo.getMemberNo());
	      System.out.println("rvo:"+rvo);
	      System.out.println("vo:"+vo);
	      return new ModelAndView(url,"rvo",rvo).addObject("vo", vo);
	   }
    
    
    //신청자리스트보기
    @RequestMapping("getApplicantList.ymv")
    @ResponseBody
    public List getApplicantList(HttpServletRequest request){
    	HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
		List<ApplicantListVO> list=null;
    	if(mvo.getMemberType().equals("company")){
    		list=voluntaryServiceApplicateService.getApplicantList(recruitNo);
    		System.out.println("getApplicantList list: "+list);
    	}
    	return list;
    }

    
    
	@RequestMapping("voluntary_board_update_view.ymv")
	public ModelAndView updateView(int recruitNo) {
		RecruitBoardVO recruitbvo = (RecruitBoardVO) recruitBoardService
				.getRecruitBoardByRecruitNo(recruitNo);
		List<FieldVO> Flist = recruitBoardService.getFieldList();
		List<LocationVO> Llist = recruitBoardService.getLocationList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voluntary_board_update_view");
		mv.addObject("fieldlist", Flist);
		mv.addObject("locationlist", Llist);
		mv.addObject("rvo", recruitbvo);
		return mv;
	}

	@RequestMapping("voluntary_board_update.ymv")
	   public ModelAndView voluntary_board_update(HttpServletRequest request, int recruitNo, String title, String field, String location, String age, String startDate, String endDate, String content) {
	      RecruitBoardVO recruitbvo = new RecruitBoardVO(recruitNo, title, field, location, age, startDate, endDate, content);
	      recruitBoardService.updateBoard(recruitbvo);
	      return new ModelAndView("voluntary_show_content","rvo",recruitBoardService.getRecruitBoardByRecruitNo(recruitbvo.getRecruitNo()));
	   }
	
	@RequestMapping("voluntary_register_view.ymv")
	   public ModelAndView RegisterVolunteer_form(){
	      List<FieldVO> Flist = recruitBoardService.getFieldList(); 
	      List<LocationVO> Llist = recruitBoardService.getLocationList();
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("voluntary_register_view");
	      mv.addObject("fieldlist", Flist);
	      mv.addObject("locationlist", Llist);
	      return mv;
	   }
	
	@RequestMapping("Volunteer_register.ymv")
	public String RegisterVolunteer_result(HttpServletRequest request,RecruitBoardVO rbvo){
		rbvo.setStartDate(rbvo.getStartDate()+" "+request.getParameter("startTime"));
		rbvo.setEndDate(rbvo.getEndDate()+" "+request.getParameter("endTime"));
		recruitBoardService.registerVolunteer(rbvo);
		return "redirect:voluntary_showContentRecruitVol.ymv?recruitNo=" + rbvo.getRecruitNo();
	}
	
	@RequestMapping("voluntary_delete.ymv")
	   public ModelAndView DeleteRecruitVol(HttpServletRequest request){
	         int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	         int pictureNo=recruitNo;
	         recruitBoardService.deleteVoluntaryServiceApplicateNo(recruitNo);
	         recruitBoardService.deleteRecruitVolunteer(recruitNo);
	         recruitBoardService.deletePicture(pictureNo);
	      return new ModelAndView("redirect:/voluntary_board.ymv?pageNo=1");
	   }
	@RequestMapping("voluntary_board_company.ymv")
	public ModelAndView voluntaryBoardCompany(HttpServletRequest request,CompanyVO cpvo){
		//세션에 들어있는 멤버넘버로 등록된 글 조회 
		MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
		cpvo.setMemberNo(mvo.getMemberNo());
		ListVO lvo = recruitBoardService.getCompanyBoardList(cpvo);
		return new ModelAndView("voluntary_board_company","lvo",lvo);
	}
	@RequestMapping("voluntary_board_normal.ymv")
	@NoLoginCheck
	public ModelAndView voluntaryBoardNormal(HttpServletRequest request, CompanyVO cpvo){
		MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
		cpvo.setMemberNo(mvo.getMemberNo());
		ListVO lvo = recruitBoardService.getNormalBoardList(cpvo);
		return new ModelAndView("voluntary_board_normal","lvo",lvo);
	}
	@RequestMapping("voluntary_applicantOK.ymv")
	@NoLoginCheck
	@Transactional
	public ModelAndView applicantOK(HttpServletRequest request,ApplicantListVO alvo){
		String memberList=request.getParameter("memberList");
		System.out.println("OK: "+ memberList);
		String member[]=memberList.split(",");
		System.out.println("OK: "+ member[0]);
		// recruitNo, memberNo 
		for(int i=0;i<member.length;i++){
			System.out.println("ok: " +member[i]);
			alvo.setMemberNo(Integer.parseInt(member[i]));
			System.out.println("alvo: "+alvo);
			recruitBoardService.registerApplicantOK(alvo);
			System.out.println("for문 끝");
			voluntaryServiceApplicateService.deleteApplicant(alvo);
		}
			List<ApplicantListVO> list=recruitBoardService.getApplicantOkList(alvo.getRecruitNo());
		return new ModelAndView("voluntary_applicantOK","list",list);
	}
	
}
