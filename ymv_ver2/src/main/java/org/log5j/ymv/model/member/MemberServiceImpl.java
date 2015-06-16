package org.log5j.ymv.model.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class MemberServiceImpl implements MemberService {
	@Resource(name="memberDAOImpl")
	private MemberDAO memberDAO;
	@Override
	public MemberVO login(MemberVO vo){
		return memberDAO.login(vo);
	}
	@Override
	public String idCheck(String id) {
		return memberDAO.idCheck(id);
	}
	
	@Override
	public void registerMember(MemberVO memberVO) {
		/*memberDAO.idCheck(memberVO.getId());*/
		memberDAO.registerMember(memberVO);		
		
	}
	
}
