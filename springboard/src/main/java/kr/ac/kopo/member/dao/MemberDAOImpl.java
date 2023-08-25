package kr.ac.kopo.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public MemberVO login(LoginVO loginVO) {
		MemberVO memberVO = sqlSessionTemplate.selectOne("springboard.member.dao.MemberDAO.login", loginVO);
		return memberVO;
	}

	@Override
	public MemberVO join(MemberVO memberVO) {
		MemberVO memberVO2 = sqlSessionTemplate.selectOne("springboard.member.dao.MemberDAO.join", memberVO);
		return memberVO2;
	}

}
