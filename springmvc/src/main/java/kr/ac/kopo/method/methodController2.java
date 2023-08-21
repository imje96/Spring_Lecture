package kr.ac.kopo.method;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class methodController2 {
	@GetMapping("/method/method")
	public String get() { // do get()
		return "method/methodForm";
	}

	@PostMapping("/method/method")
	public String post() {
		System.out.println("post 요청 받았어요");
		return "method/methodProcess"; //view name return
		// WEN-INF/jsp/method/methodProcess.jsp
	}

}
