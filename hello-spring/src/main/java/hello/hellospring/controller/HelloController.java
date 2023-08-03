package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    // 외부에서 파라미터를 받는 경우
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    // 응답 body 부에 이 내용을 직접 넣어주겠다는 뜻
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // spring 이라는 문자를 넣어주면 hello spring  이라고 뜰 것
        // 템플릿 엔진과의 차이점은 view 가 없이 문자가 그대로 나감(html 태그 없이 문자가 그대로 나오는 것)
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }
    static class Hello {
        public String getName() {
              v
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;


    }

}
