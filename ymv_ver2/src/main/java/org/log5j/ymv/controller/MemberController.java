package org.log5j.ymv.controller;

import javax.annotation.Resource;

import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateService;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@Resource(name="voluntaryServiceApplicateServiceImpl")
	private VoluntaryServiceApplicateService voluntaryServiceApplicateService;
	
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
