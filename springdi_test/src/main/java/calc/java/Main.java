package calc.java;

import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;


public class Main {
	public static void main(String[] args) {
	
		ApplicationContext context
		= new AnnotationConfigApplicationContext(Config.class);
		
		MyCalculator c = context.getBean("myCalc", MyCalculator.class);
		c.printResult();
	}
}
