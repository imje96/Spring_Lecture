package basic;

import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class HelloMain {

	public static void main(String[] args) {
		
//		Hello h1 = new Hello();
//		h1.printHello();
//		Spring Container 생성 
		
		
		ApplicationContext context 
//		= new GenericXmlApplicationContext("basic-beanContainer.xml");
		= new ClassPathXmlApplicationContext("basic-beanContainer.xml");
		
		// 새로운 Hello에 아까 만든 h1을 넣어줘
		Hello h = (Hello)context.getBean("h1");
		h.printHello();
		
		// 캐스트를 쓰기 싫어 
		Hello hh = context.getBean("h2", Hello.class);
		hh.printHello();

		System.err.println(h);
		System.err.println(hh);
		
	}
}