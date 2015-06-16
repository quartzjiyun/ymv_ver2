package org.log5j.ymv.model.member;


public interface MemberService {
	public MemberVO login(MemberVO vo);

	public String idCheck(String id);

	public void registerMember(MemberVO memberVO);
	
}