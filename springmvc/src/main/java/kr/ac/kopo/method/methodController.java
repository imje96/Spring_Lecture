package kr.ac.kopo.method;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/method/method")
//@Controller
public class methodController {
	// http://localhost:8080/springmvc/method/method
	// "/method/method" 이걸로 get 메소드가 들어올 텐데 그럼 get() 실행
	@RequestMapping(method = RequestMethod.GET)
	public String get() { // do get()
		// view의 이름을 return
		// /WEB-INF/jsp/method/methodForm.jsp
		return "method/methodForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post() {
		System.out.println("post 요청 받았어요");
		return "method/methodProcess"; //view name return
		// WEN-INF/jsp/method/methodProcess.jsp
	}

}
