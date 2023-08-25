package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.member.dao.MemberDAOImpl;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAOImpl memberDAO;

    @Override
    public MemberVO login(LoginVO loginVO) {

        return memberDAO.login(loginVO);
    }

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.join(memberVO);        
    }

}