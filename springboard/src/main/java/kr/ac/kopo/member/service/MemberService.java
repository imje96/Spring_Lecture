package kr.ac.kopo.member.service;

import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

public interface MemberService {

    public MemberVO login(LoginVO loginVO); 
    
    public void join(MemberVO memberVO); 
}
