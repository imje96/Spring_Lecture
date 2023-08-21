package kr.ac.kopo.hello;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HelloController {
	
	
	public HelloController() {
		System.out.println("HelloController() 생성자");
	}
	
	// handler 생성
	// method. client가 요청하면 요청을 받아주는 것 
	// localhost:8080/springmvc/hello/h1
	@RequestMapping("/hello/h1")
	public ModelAndView hello() {
		System.err.println("111");
		
		ModelAndView mav = new ModelAndView("hello/hello");
		mav.addObject("msg", "HelloWorld");
		
		//view -> jsp 파일
		//WEB-INF/jsp/hello/hello.jsp
		//WEB-INF/jsp/ + value + .jsp
		return mav;
	}
	
}
