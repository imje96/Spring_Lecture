package kr.ac.kopo.response;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import kr.ac.kopo.form.*;

@RestController
public class ResponseBodyController {
    
//	member list return 작성
	
	   //@ResponseBody
	   @RequestMapping("/listresponse")
	public List<MemberVO> memberlist() {
	    List<MemberVO> members = new ArrayList<>();

	    MemberVO member = new MemberVO();
	    member.setId("김");
	    member.setPassword("1234");
	    members.add(member);
		return members;
	}
	 

    //@ResponseBody
    @RequestMapping("/voresponse")
    public MemberVO voresponse() {
        MemberVO member = new MemberVO();
    	member.setId("홍");
    	member.setPassword("1111");
    	return member;
    }
	
    //@ResponseBody
    @RequestMapping("/stringresponse")
    public String response() {
        return "ok. 성공";
    }


}