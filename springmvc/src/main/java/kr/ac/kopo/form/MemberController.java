package kr.ac.kopo.form;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.servlet.*;

@Controller
public class MemberController {

	@GetMapping("/member/joinForm")
    public String joinForm() {
        return "member/joinForm";
        //WEB-INF/jsp/ member/joinForm  .jsp
    }

	//@PostMapping("/member/join")
	public String post() {
		return "member/join"; 
	}

	@PostMapping("/member/join")
	public ModelAndView join6(MemberVO member) {
			ModelAndView mav = new ModelAndView("member/join");
			mav.addObject("member", member);
		return mav;
	}
	
	//@PostMapping("/member/join")
	public String join5(@ModelAttribute("member") MemberVO member) {
		return "member/join";
	}
	
	//@PostMapping("/member/join")
	public String join4(MemberVO member) {
		System.out.println(member.getId() + " : " 
							+ member.getPassword());
		return "member/join";
		//memberVO 으로 바꿔서 member/join에 넘겨줌
	}
	
	
	//@PostMapping("/member/join")
	public String join3(HttpServletRequest request,
			String id,
			String password
			) { //@RequestParam 생략가능
		
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(id);
		// 다음 join.jsp에서 member 변수로 찾아내기 
		request.setAttribute("member", member);
		return "member/join";
	}
	
	
	//@PostMapping("/member/join")
	public String join2(HttpServletRequest request,
						@RequestParam("id") String id2,
						@RequestParam("password") String password2
						) {
		//String id = request.getParameter("id");
		//String passwrod = request.getParameter("password");
//		request.setAttribute(id, passwrod);
		
		
		MemberVO member = new MemberVO();
		member.setId(id2);
		member.setPassword(password2);
		// 다음 join.jsp에서 member 변수로 찾아내기 
		request.setAttribute("member", member);
		return "member/join";
	}
	
	//@PostMapping("/member/join")
	public String join(HttpServletRequest request) {
		String id = request.getParameter("id");
		String passwrod = request.getParameter("password");
//		request.setAttribute(id, passwrod);
		
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(id);
		// 다음 join.jsp에서 member 변수로 찾아내기 
		request.setAttribute("member", member);
		return "member/join";
	}

}
