package org.log5j.ymv.aop.common;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.log5j.ymv.aop.model.CommonService;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//contrxt-component scan 대상이 되도록 하여 컨테이너가 bean을 생성하도록 한다.
@Component
//Aspect 어노테이션을 명시하여 공통기능 정의 빈임을 컨테이너에게 알린다.
@Aspect
public class AroundAspect {
	@Resource(name="commonServiceImpl")
	private CommonService commonService;
	
	private Logger log=LoggerFactory.getLogger(getClass());
	
	/*@Before("execution(public * org.log5j..VoluntaryServiceApplicateServiceImpl*.reg*(..))")
	public void beforeLog(JoinPoint point){
		System.out.println("aop 실행~~!!!!!!!!!!!!!!!!!!");
		log.info("aop 실행~~");
	}*/
	
	@After("execution(public * org.log5j..VoluntaryServiceApplicateServiceImpl.reg*(..))")
	public void afterLog(JoinPoint point) throws SQLException{
		Object param[]=point.getArgs();// 메서드 인자값 - 매개변수
		VoluntaryServiceApplicateVO vvo = (VoluntaryServiceApplicateVO) param[0];
		String ageString = commonService.findIdentityNoByMemberNo(vvo.getMemberNo());
		int age = Integer.parseInt(ageString);
		String field = commonService.findFieldByRecruitNo(vvo.getRecruitNo());
		commonService.saveStatistics(age, field);
	}
	
	
}

