package org.log5j.ymv.model.member;

import org.log5j.ymv.exception.DuplicateIdException;

public interface MemberService {
	public MemberVO login(MemberVO vo);

	public String idCheck(String id) throws DuplicateIdException;

	public void registerMember(MemberVO memberVO);
	
}