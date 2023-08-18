package di.anno03;

import org.springframework.context.*;
import org.springframework.context.support.GenericXmlApplicationContext;

public class driverMain {

	public static void main(String[] args) {
		ApplicationContext context
		= new GenericXmlApplicationContext("spring-anno03.xml");
		
		Car c = context.getBean("car", Car.class);
		c.printTireBrand();
	}
}