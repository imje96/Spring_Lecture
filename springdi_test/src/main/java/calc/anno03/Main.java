package calc.anno03;

import org.springframework.context.*;
import org.springframework.context.support.*;


public class Main {
	public static void main(String[] args) {
	
		ApplicationContext context
		= new GenericXmlApplicationContext("calc-anno03.xml");
		
		MyCalculator c = (MyCalculator) context.getBean("myCalc");
		c.printResult();
	}
}
