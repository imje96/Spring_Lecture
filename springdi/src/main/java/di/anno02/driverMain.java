package di.anno02;

import org.springframework.context.*;
import org.springframework.context.support.GenericXmlApplicationContext;

public class driverMain {

	public static void main(String[] args) {
		ApplicationContext context
		= new GenericXmlApplicationContext("spring-anno02.xml");
		
		Car c = context.getBean("car", Car.class);
		c.printTireBrand();
	}
}
