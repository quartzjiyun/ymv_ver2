package org.log5j.ymv.model.member;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public MemberVO login(MemberVO vo){
		return sqlSessionTemplate.selectOne("member.login",vo);
	}

	@Override
	public String idCheck(String id) {
		int flag=sqlSessionTemplate.selectOne("member.idcheck",id);
		System.out.println(flag+" 이 값이 아디 갯수");
		return (flag==0) ? "ok":"fail"; 	
	}
	@Override
	public void registerMember(MemberVO memberVO) {
		sqlSessionTemplate.insert("member.registerMember",memberVO);
	}
}
