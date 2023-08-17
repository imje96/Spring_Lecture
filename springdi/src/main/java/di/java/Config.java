package di.java;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

//@ComponentScan(basePackages = {"di.java"})
//@Configuration
public class Config {

	@Qualifier("mycar")
	@Bean // bean으로 만들어줘. 
	public Car car() {
		return new Car();
	}
	
	@Qualifier("h1")
	@Bean 
	public HankookTire hankookTire() {
		return new HankookTire();
	}

	@Qualifier("k")
	@Bean 
	public KumhoTire kumhoTire() {
		return new KumhoTire();
	}

}
