package calc.anno04;

import org.springframework.context.*;
import org.springframework.context.support.*;


public class Main {
	public static void main(String[] args) {
	
		ApplicationContext context
		= new GenericXmlApplicationContext("calc-anno04.xml");
		
		MyCalculator c = context.getBean("myCalc", MyCalculator.class);
		c.printResult();
	}
}
