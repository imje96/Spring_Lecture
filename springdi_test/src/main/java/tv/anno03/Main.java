package tv.anno03;

import org.springframework.context.*;
import org.springframework.context.support.*;

public class Main {
		public static void main(String[] args) {


			ApplicationContext context
			= new GenericXmlApplicationContext("tv-anno03.xml");


			// tv기능 사용
			TV tv = (LGTV) context.getBean("lgtv");
			tv.turnon();
			tv.volumeup();
			tv.volumedown();
			tv.printSpeakerBrand();
			tv.turnoff();
			System.out.println("======================");
			TV tv2 = (TV) context.getBean("stv");
			tv2.turnon();
			tv2.volumeup();
			tv2.volumedown();
			tv2.printSpeakerBrand();
			tv2.turnoff();

		}
}

