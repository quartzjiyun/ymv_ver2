package org.log5j.ymv.model.member;

import javax.annotation.Resource;

import org.log5j.ymv.exception.DuplicateIdException;
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
	public String idCheck(String id) throws DuplicateIdException {
		if(memberDAO.idCheck(id).equals("ok")){
			System.out.println("아이디 ok 서비스 디에이오");
		}else{
			throw new DuplicateIdException("아이디가 중복됩니다!");
		}
		return memberDAO.idCheck(id);
	}
	
	@Override
	public void registerMember(MemberVO memberVO) {
		/*memberDAO.idCheck(memberVO.getId());*/
		memberDAO.registerMember(memberVO);		
		
	}
	
}
