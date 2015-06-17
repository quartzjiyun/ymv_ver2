package org.log5j.ymv.model.member;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.PictureVO;
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
	@Override
	public void registerPicture(PictureVO pvo) {
		// TODO Auto-generated method stub
		memberDAO.registerPicture(pvo);
	}
	@Override
	public void profileUpdate(MemberVO memberVO) {
		// TODO Auto-generated method stub
		memberDAO.profileUpdate(memberVO);
	}
	@Override
	public void updateMember(MemberVO memberVO) {
		memberDAO.updateMember(memberVO);
	}
	@Override
	public MemberVO findMemberByMemberNo(int memberNo) {
		return memberDAO.findMemberByMemberNo(memberNo);
	}
	
}
