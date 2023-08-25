package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.vo.MemberVO;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		 //로그인 안했으면 , 로그인 얼른 하세요
        //login.jsp 화면으로 이동
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("currentUser");
		System.out.println("preHandle - 로그인 체크 동작입니다.");
		System.out.println("prehandler 동작입니다.");
		
		System.out.println("handler: " + handler);
		System.out.println("request.getContextPath() : " + request.getContextPath());
		System.out.println("request.getServletPath() : " + request.getServletPath());
		System.out.println("request.getQueryString() : " + request.getQueryString());
		System.out.println("request.getRequestURI() : " + request.getRequestURI());

		// session에 등록(dest에 서블릿패스 저장)
		session.setAttribute("dest", request.getServletPath());
		
		// 로그인을 안했다면 null이 들어올 것 
		if (memberVO == null) { // 로그인 안했으면
			System.out.println("memberVO is null");
			// springboard/login 으로 가
			response.sendRedirect(request.getContextPath() + "/login");
			return false; // 아무 일도 안하고 가만히 있음
		} 
		  else { // 로그인 이미 한 경우
			System.out.println("memberVO 로그인 했음 ");
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println();
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}


}