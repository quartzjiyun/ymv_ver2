package org.log5j.ymv.model.member;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberVO login(MemberVO vo){
		return sqlSessionTemplate.selectOne("member.login",vo);
	}

}
