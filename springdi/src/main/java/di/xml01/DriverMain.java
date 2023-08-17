package di.xml01;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {

	public static void main(String[] args) {
		ApplicationContext context
			= new GenericXmlApplicationContext("spring-xml01.xml");
	
	     // id를 이용하여 빈 객체 가져오기
        Car car = (Car) context.getBean("car");
        Car car1 = (Car) context.getBean("car1");
        Car car2 = (Car) context.getBean("car2");
        Car car3 = (Car) context.getBean("car3");
        Car car4 = (Car) context.getBean("car4");
        Car car5 = (Car) context.getBean("car5");
       

        car.printTireBrand();
        car1.printTireBrand();
        car2.printTireBrand();
        car3.printTireBrand();
        car4.printTireBrand();
        List<String> list = car5.getDriver();
        for(String str : list) {
        	System.out.println(str);
        }
        
        // 맵 빈 가져오기
        Map<String, Car> car6 = (Map<String, Car>) context.getBean("car6");

        // 맵 내의 각 자동차 빈 출력
        for (Map.Entry<String, Car> entry : car6.entrySet()) {
            String carId = entry.getKey();
            Car carEntry = entry.getValue();

            System.out.println("Car ID: " + carId);
            carEntry.printTireBrand();
        }
	}

}
