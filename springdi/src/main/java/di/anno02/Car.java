package di.anno02;

import javax.annotation.*;

import org.springframework.beans.factory.annotation.*;

public class Car {
	
	private Tire tire;
	
	public Car() {
		System.out.println("Car() 생성자입니다.");
	}
	public Car(Tire t) {
		this.tire = t;
		System.out.println("Car(Tire t) 생성자입니다.");
	}

	public Tire getTire() {
		return tire;
	}

	@Resource
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire tire)입니다.");
	}
	
	
	public void printTireBrand() {
	System.out.println("타이어브랜드는 " + tire.getClass());
	}
	
}
