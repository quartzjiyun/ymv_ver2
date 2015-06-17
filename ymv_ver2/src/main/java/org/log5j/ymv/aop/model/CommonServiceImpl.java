package org.log5j.ymv.aop.model;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
	@Resource(name="commonDAOImpl")
	private CommonDAO commonDAO;

	@Override
	public String findIdentityNoByMemberNo(int memberNo) {
		return commonDAO.findIdentityNoByMemberNo(memberNo);
	}

	@Override
	public void saveStatistics(int age, String field) throws SQLException {
		int ageTemp = (115-(age/10000))+1;
		//(올해년도(115)-일반회원 태어난연도(age/10000))+1 == 일반회원 나이
		if(ageTemp>=10 && ageTemp<20){
			ageTemp = 10;
		}else if(ageTemp>=20 && ageTemp<30){
			ageTemp=20;
		}else if(ageTemp>=30 && ageTemp<40){
			ageTemp=30;
		}else if(ageTemp>=40 && ageTemp<50){
			ageTemp=40;
		}else if(ageTemp>=50 && ageTemp<60){
			ageTemp=50;
		}else{
			ageTemp=0;
			//age가 0이면 기타
		}
		System.out.println("ageTemp    "+ageTemp);
		int result=commonDAO.updateStatistics(ageTemp, field);
		if(result==0)
			commonDAO.insertStatistics(ageTemp, field);	
		
	}

	@Override
	public String findFieldByRecruitNo(int RecruitNo) {
		return commonDAO.findFieldByRecruitNo(RecruitNo);
	}

}
