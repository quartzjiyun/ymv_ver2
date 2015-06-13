package org.log5j.ymv.model.voluntary;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class VoluntaryServiceApplicateServiceImpl implements VoluntaryServiceApplicateService {
	@Resource(name="voluntaryServiceApplicateDAOImpl")
	private VoluntaryServiceApplicateDAO voluntaryServiceApplicateDAO;
	
	@Override
	public void registerVolunteerApplicant(VoluntaryServiceApplicateVO vsavo) {
		System.out.println("register service 시작" + vsavo);
		voluntaryServiceApplicateDAO.registerVolunteerApplicant(vsavo);
	}

	@Override
	public boolean checkVolunteerApplicant(int recruitNo, int memberNo) {
		System.out.println("checkVolunteerApplicant - service");
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("recruitNo", recruitNo);
		map.put("memberNo", memberNo);
		System.out.println("map   "+map);
		int count=voluntaryServiceApplicateDAO.checkVolunteerApplicant(map);
		System.out.println("service    check  "+count);
		boolean flag=false;
		if(count>0)
			flag=true;
		return flag;
	}

}
