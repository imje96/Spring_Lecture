package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes("currentUser")
@Controller
public class MemberController {
// 핸들러 먼저 만들기
	@Autowired
	private MemberService memberService;

	@GetMapping("/logout")
	public String logout2(SessionStatus sessionStatus) {
		// session.invalidate();
		sessionStatus.setComplete();
		return "redirect:/";
	}

	// @GetMapping("/logout")
	public String logout(HttpSession session) {
		// session.setAttribute("curentUser", memberVO)
		// session.removeAttribute("currentUser");
		session.invalidate();
		// "index" WEB-INF/jsp/index.jsp(x)
		// http://localhost:8080/springboard/
		return "redirect:/";
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		// 빈 깡통 만들기
		LoginVO loginVO = new LoginVO();
		model.addAttribute(loginVO);
		return "member/loginForm";
		// member/loginForn.jsp
	}

	@PostMapping("/login")
	public String loginProcess(@Valid LoginVO loginVO, Errors errors, Model model, HttpServletRequest request,
			HttpSession session) {

		if (errors.hasErrors()) { // error가 존재
			return "member/loginForm"; // 다시 로그인하는 페이지로 이동
		} else { // null 값이 없을 때, DB 쿼리 실행
			MemberVO memberVO = memberService.login(loginVO);
			if (memberVO == null) {
				System.err.println("id/password가 틀렸습니다. ");
				model.addAttribute("msg", "id와 password를 다시 확인하세요.");
				return "member/loginForm"; // 다시 로그인 하는 페이지로 이동
			} else {

				System.out.println("Login이 완료되었습니다" + memberVO);
				// 세션등록 jsp ${currunetUser} honh/1111
				// 1) session.setAttribute("curruentUser", memberVO);
				// 2) @SessionAtrribute를 class명 위에 설정한다
				model.addAttribute("currentUser", memberVO);
				// *************************************
				// 수정 필요. redirect 주소 수정 필요
				// **************************************
				String dest = (String) session.getAttribute("dest");
				session.removeAttribute("dest");

				if (dest == null) {
					return "redirect:/";
				} else { // dest가 있으면, 로그인을 안해서 interceptor가 잡아와서 생긴 dest 세션임
					return "redirect:" + dest;
				}

			}
		}
	}

	@GetMapping("/join")
	public String joinForm(Model model) {
		MemberVO memberVO = new MemberVO();
		model.addAttribute(memberVO);
		return "member/joinForm";
	}

	@PostMapping("/join")
	public String joinProcess(@Valid MemberVO memberVO, Errors errors, Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("msg", "모든 입력을 완료해주세요");
			return "member/joinForm";
		} else {
			memberService.join(memberVO);
			model.addAttribute(memberVO);
			return "redirect:/loginForm";
		}
	}
}