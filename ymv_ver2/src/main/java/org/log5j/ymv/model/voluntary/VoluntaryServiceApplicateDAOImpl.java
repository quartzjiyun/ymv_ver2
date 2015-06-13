package org.log5j.ymv.model.voluntary;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VoluntaryServiceApplicateDAOImpl implements VoluntaryServiceApplicateDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void registerVolunteerApplicant(VoluntaryServiceApplicateVO vsavo) {
		System.out.println("registerVolunteerApplicant    vsavo    " + vsavo);
		sqlSessionTemplate.insert("member.RegisterVoluntaryApplicant",vsavo);
	}

	@Override
	public Integer checkVolunteerApplicant(Map<String,Object> map) {
		System.out.println("checkVolunteerApplicant - dao");
		/*VoluntaryServiceApplicateVO vsvo = new VoluntaryServiceApplicateVO();
		vsvo.setRecruitNo(recruitNo);
		vsvo.setMemberNo(memberNo);
		System.out.println(vsvo);*/
		System.out.println("map   "+map);
		return sqlSessionTemplate.selectOne("member.checkVolunteerApplicant",map);
	}

}