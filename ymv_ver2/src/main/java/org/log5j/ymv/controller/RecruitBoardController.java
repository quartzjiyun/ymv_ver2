package org.log5j.ymv.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.log5j.ymv.model.member.Email;
import org.log5j.ymv.model.member.EmailSender;
import org.log5j.ymv.model.member.MemberService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	@Autowired
    private EmailSender emailSender;
	//
	@RequestMapping("voluntary_board.ymv")
	@NoLoginCheck
	public ModelAndView list(String pageNo) {	
		ModelAndView mv = new ModelAndView("voluntary_board");
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		ListVO lvo = recruitBoardService.findBoardList(pageNo);
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((RecruitBoardVO) lvo.getList().get(i)).getEndDate());
			if(compare > 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집완료");
			}else if(compare < 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}else{
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}
		}
		mv.addObject("lvo", lvo);
		return mv;
	}
	//
	@RequestMapping("voluntary_show_content_recruit_vol.ymv")
	@NoLoginCheck
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		String mojib = request.getParameter("mojib");
		String noComp = request.getParameter("recruitNo");
		int recruitNo = Integer.parseInt(noComp);
		 System.out.println("recruit_showContent boardNo: " + recruitNo);
		RecruitBoardVO rvo=null;
		// 개별 게시물 조회 ( 조회수 증가 )
		Cookie cookies[] = request.getCookies();
		Cookie cookie = null;
		if (cookies == null || cookies.length == 0) {
			cookie = new Cookie("myboard", "|" + recruitNo + "|");
			response.addCookie(cookie);
			System.out.println(" 쿠키가 존재하지 않은 상태");
		} else {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("myboard")) {
					cookie = cookies[i];
					break;
				}
			}
			if (cookie == null) {
				// 쿠키가 존재하는데 myboard가 없을때
				cookie = new Cookie("myboard", "|" + recruitNo + "|");
				response.addCookie(cookie);
				recruitBoardService.findPostingByRecruitNoUpdateHit(recruitNo);//BoardDAO.getInstance().updateHit(boardNo);
			/*	BoardVO bvo=reviewBoardService.getReviewBoardByBoardNo(boardNo);//vo = BoardDAO.getInstance().getPostingByNo(boardNo);*/				
				System.out.println("쿠키가 존재하지만 myboard 쿠키가 존재하지 않은 상태");
			} else {// 쿠키가 존재하는데 myboard가 있을때
				String value = cookie.getValue();
				System.out.println("쿠키 존재하고 myboard 쿠키가 존재하는 상태");
				if (value.indexOf("|" + recruitNo + "|") != -1) {
					// myboard cookie의 value 정보에서 해당 게시글 번호가 존재하는 상태
					System.out.println("myboard 쿠키에 해당 게시글 번호가 존재..조회수 증가x");
		/*			recruitBoardService.getPostingByRecruitNoNotHit(recruitNo);//vo = BoardDAO.getInstance().getPostingByNo(boardNo);
*/				} else {
					// myboard cookie의 value 정보에서 해당 게시글 번호가 존재하지 않은 상태
					value += "|" + recruitNo + "|";
					System.out.println("myboard 쿠키에 해당 게시글 번호가 존재x..조회수 증가0");
					recruitBoardService.findPostingByRecruitNoUpdateHit(recruitNo);//BoardDAO.getInstance().updateHit(boardNo);
					//vo = BoardDAO.getInstance().getPostingByNo(boardNo);
					response.addCookie(new Cookie("myboard", value));
				}// else1
			}// else2
		}// else3
		rvo=recruitBoardService.findRecruitBoardByRecruitNo(recruitNo);//vo = BoardDAO.getInstance().getPostingByNo(boardNo);
		System.out.println("Rvo:"+rvo);
		MemberVO vo=memberService.findMemberByMemberNo(rvo.getMemberNo());
		rvo.setMojib(mojib);
		mv.addObject("rvo", rvo).addObject("vo",vo);
		mv.setViewName("voluntary_show_content");
		 return mv;
}
	//
    @RequestMapping("voluntary_show_content_recruit_vol_type.ymv")
	   public ModelAndView showContentRecruitVolType(HttpServletRequest request){
    	String mojib = request.getParameter("mojib");
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
	      RecruitBoardVO rvo=recruitBoardService.findRecruitBoardByRecruitNo(recruitNo);
	      MemberVO vo=memberService.findMemberByMemberNo(rvo.getMemberNo());
	      System.out.println("rvo:"+rvo);
	      System.out.println("vo:"+vo);
	      rvo.setMojib(mojib);
	      return new ModelAndView(url,"rvo",rvo).addObject("vo", vo);
	   }
    
    //신청자리스트보기
    @RequestMapping("find_applicant_list.ymv")
    @ResponseBody
    public List getApplicantList(HttpServletRequest request){
    	HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
		List<ApplicantListVO> list=null;
    	if(mvo.getMemberType().equals("company")){
    		list=voluntaryServiceApplicateService.findApplicantList(recruitNo);
    		System.out.println("getApplicantList list: "+list);
    	}
    	return list;
    }
    //
	@RequestMapping("voluntary_board_update_view.ymv")
	public ModelAndView updateView(int recruitNo,HttpServletRequest request) {
		RecruitBoardVO recruitbvo = (RecruitBoardVO) recruitBoardService
				.findRecruitBoardByRecruitNo(recruitNo);
		String StartDate[]=recruitbvo.getStartDate().split(" ");
		recruitbvo.setStartDate(StartDate[0]);
		recruitbvo.setStartTime(StartDate[1]);
		String EndDate[]=recruitbvo.getEndDate().split(" ");
		recruitbvo.setEndDate(EndDate[0]);
		recruitbvo.setEndTime(EndDate[1]);
		List<FieldVO> Flist = recruitBoardService.findFieldList();
		List<LocationVO> Llist = recruitBoardService.findLocationList();
		ModelAndView mv = new ModelAndView();
		String command=request.getParameter("command");
		mv.setViewName("voluntary_board_update_view");
		mv.addObject("fieldlist", Flist);
		mv.addObject("locationlist", Llist);
		mv.addObject("rvo", recruitbvo);
		mv.addObject("command",command);
		return mv;
	}
//
	@RequestMapping("voluntary_board_update.ymv")
	   public ModelAndView voluntary_board_update(HttpServletRequest request, int recruitNo, String title, String field, String location, String age, String startDate, String endDate, String content) {
	      ModelAndView mv=new ModelAndView();
		RecruitBoardVO recruitbvo = new RecruitBoardVO(recruitNo, title, field, location, age, startDate, endDate, content);
	      recruitBoardService.updateBoard(recruitbvo);
	      String command=request.getParameter("command");
	      if(command.equals("company")){
	    	  mv.setViewName("voluntary_show_content_company");
	      }else if(command.equals("normal")){
	    	  mv.setViewName("voluntary_show_content_normal");
	      }else{
	    	  mv.setViewName("voluntary_show_content");
	      }
	      mv.addObject("rvo",recruitBoardService.findRecruitBoardByRecruitNo(recruitbvo.getRecruitNo()));
	      return mv;
	   }
	//
	@RequestMapping("voluntary_register_view.ymv")
	   public ModelAndView RegisterVolunteer_form(){
	      List<FieldVO> Flist = recruitBoardService.findFieldList(); 
	      List<LocationVO> Llist = recruitBoardService.findLocationList();
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("voluntary_register_view");
	      mv.addObject("fieldlist", Flist);
	      mv.addObject("locationlist", Llist);
	      return mv;
	   }
	//
	@RequestMapping("volunteer_register.ymv")
	public String RegisterVolunteer_result(HttpServletRequest request,RecruitBoardVO rbvo){
		rbvo.setStartDate(rbvo.getStartDate()+" "+request.getParameter("startTime"));
		rbvo.setEndDate(rbvo.getEndDate()+" "+request.getParameter("endTime"));
		recruitBoardService.registerVolunteer(rbvo);
		return "redirect:voluntary_show_content_recruit_vol.ymv?recruitNo=" + rbvo.getRecruitNo();
	}
	//
	@RequestMapping("voluntary_delete.ymv")
	   public ModelAndView DeleteRecruitVol(HttpServletRequest request){
	         int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	         int pictureNo=recruitNo;
	         recruitBoardService.deleteVoluntaryServiceApplicateNo(recruitNo);
	         recruitBoardService.deleteRecruitVolunteer(recruitNo);
	         recruitBoardService.deletePicture(pictureNo);
	      return new ModelAndView("redirect:/voluntary_board.ymv?pageNo=1");
	   }
	//
	@RequestMapping("voluntary_board_company.ymv")
	public ModelAndView voluntaryBoardCompany(HttpServletRequest request,CompanyVO cpvo){
		//세션에 들어있는 멤버넘버로 등록된 글 조회 
		ModelAndView mv = new ModelAndView("voluntary_board_company");
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
		cpvo.setMemberNo(mvo.getMemberNo());
		ListVO lvo = recruitBoardService.findCompanyBoardList(cpvo);
		
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((RecruitBoardVO) lvo.getList().get(i)).getEndDate());
			if(compare > 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집완료");
			}else if(compare < 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}else{
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}
		}
		mv.addObject("lvo", lvo);
		return mv;
	}
	//
	@RequestMapping("voluntary_board_normal.ymv")
	@NoLoginCheck
	public ModelAndView voluntaryBoardNormal(HttpServletRequest request, CompanyVO cpvo){
		ModelAndView mv = new ModelAndView("voluntary_board_normal");
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
		cpvo.setMemberNo(mvo.getMemberNo());
		ListVO lvo = recruitBoardService.findNormalBoardList(cpvo);
		
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((RecruitBoardVO) lvo.getList().get(i)).getEndDate());
			if(compare > 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집완료");
			}else if(compare < 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}else{
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}
		}
		mv.addObject("lvo", lvo);
		return mv;
	}
	//
	@RequestMapping("voluntary_applicantOK.ymv")
	@NoLoginCheck
	@Transactional
	public ModelAndView applicantOK(HttpServletRequest request,ApplicantListVO alvo) throws Exception{
		Email email = new Email();
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
			//선정된 인원에게 메일 발송 memberNo로 메일 뽑아오기
			MemberVO mailList=recruitBoardService.findMailAddressByMemberNo(Integer.parseInt(member[i]));
			System.out.println("mailList:"+mailList);
			
			String reciver = mailList.getMailAddress(); //받을사람의 이메일입니다.
	        String subject = "병준아 제발";
	        String content = "메일이 도착했다고 말해";
	        
	        email.setReciver(reciver);
	        email.setSubject(subject);
	        email.setContent(content);
	        emailSender.SendEmail(email);
		}
			List<ApplicantListVO> list=recruitBoardService.findApplicantOkList(alvo.getRecruitNo());

		return new ModelAndView("voluntary_applicantOK","list",list);
	}
	//
	@RequestMapping("voluntary_OKList.ymv")
	public ModelAndView voluntary_OKList(HttpServletRequest request,ApplicantListVO alvo){
		//String recruitNo=request.getParameter("recruitNo");
		List<ApplicantListVO> list=recruitBoardService.findApplicantOkList(alvo.getRecruitNo());
		System.out.println("OKLIST alvo : "+alvo.getRecruitNo());
		System.out.println("OKLIST : "+list);
		return new ModelAndView("voluntary_OKList","list",list);
	}
	//
	@RequestMapping("voluntary_confirm.ymv")
	public ModelAndView voluntary_confirm(HttpServletRequest request,ApplicantListVO alvo){
		//선택된 인원들 새로운 디비에 저장(confirm)
		String memberList=request.getParameter("memberList");
		System.out.println("OK: "+ memberList);
		String member[]=memberList.split(",");
		System.out.println("OK: "+ member[0]);
		for(int i=0;i<member.length;i++){
			alvo.setMemberNo(Integer.parseInt(member[i]));
			System.out.println("confirm: " +alvo);
			ConfirmBoardVO confirmbvo=new ConfirmBoardVO();
			RecruitBoardVO recruitbvo=recruitBoardService.findRecruitBoardByRecruitNo(alvo.getRecruitNo());
			System.out.println("recruitbvo: "+recruitbvo);
			confirmbvo.setBoardNo(recruitbvo.getRecruitNo());
			confirmbvo.setTitle(recruitbvo.getTitle());
			confirmbvo.setField(recruitbvo.getField());
			confirmbvo.setLocation(recruitbvo.getLocation());
			confirmbvo.setAge(recruitbvo.getAge());
			confirmbvo.setStartDate(recruitbvo.getStartDate());
			confirmbvo.setEndDate(recruitbvo.getEndDate());
			confirmbvo.setContent(recruitbvo.getContent());
			confirmbvo.setMemberNo(recruitbvo.getMemberNo());
			System.out.println("confirmbvo: "+confirmbvo);
			recruitBoardService.registerConfirmBoard(confirmbvo);
			//글등록 먼저하고나서 컨펌등록
			ConfirmVO confirmvo=new ConfirmVO();
			confirmvo.setBoardNo(alvo.getRecruitNo());
			confirmvo.setMemberNo(alvo.getMemberNo());
			System.out.println("confirmvo: "+confirmvo);
			recruitBoardService.registerConfirm(confirmvo);
			recruitBoardService.deleteVoluntaryApplicantOK(recruitbvo.getRecruitNo());
			recruitBoardService.deleteVoluntaryServiceApplicateByRecruitNo(recruitbvo.getRecruitNo());
			recruitBoardService.deleteRecruitVolunteer(recruitbvo.getRecruitNo());
			
		}
		//해당 글 삭제.
		return new ModelAndView("voluntary_confirm");
	}
	//
	//장지윤
	@RequestMapping("voluntary_board_normal_confirmList.ymv")
	   @NoLoginCheck
	   public ModelAndView voluntaryBoardNormalConfirmList(HttpServletRequest request, CompanyVO cpvo){
	      MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
	      String pageNo=request.getParameter("pageNo");
	      System.out.println("mvo11111:"+mvo);
	      cpvo.setMemberNo(mvo.getMemberNo());
	      //멤버넘버로 컨펌을 찾아와서 컨펌에 있는 보드넘버로 그 보드넘버에 해당하는 컨펌보드글들을 불러와야지
	      //List<ConfirmVO> confirmList=recruitBoardService.getConfirmListByMemberNo(mvo.getMemberNo());
	      //System.out.println("confirmList:"+confirmList);
	      ConfirmPageVO confirmPageVO=new ConfirmPageVO();
	      confirmPageVO.setMemberNo(mvo.getMemberNo());
	      //confirmPageVO.setPageNo(Integer.parseInt(pageNo));
	      ListVO lvo=recruitBoardService.findConfirmBoardListByMemberNo(confirmPageVO);
	      
	      return new ModelAndView("voluntary_board_normal_confirmList","lvo",lvo);
	   }
	//
	@RequestMapping("voluntary_confirm_normal.ymv")
	   @NoLoginCheck
	   public ModelAndView voluntaryConfirmNormal(HttpServletRequest request, ConfirmVO cvo){
		System.out.println("cvo:"+cvo);
		ConfirmBoardVO cbvo= recruitBoardService.findConfirmBoardByConfirm(cvo);
		System.out.println("cbvo:"+cbvo);
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		String arr[]= today.split("-");
		HashMap map=new HashMap();
		map.put("year",arr[0] );
		map.put("month",arr[1] );
		map.put("date",arr[2] );
		return new ModelAndView("voluntary_confirm_show_content","cbvo",cbvo).addObject("today",map);
	   }
}
