package di.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

//	   @Autowired 
//	   @Qualifier("h1") 
    private Tire tire;

    public Car() {
        System.out.println("Car() 생성자입니다.");
    }
    
    
//    @Autowired 
    public Car(Tire t) {
        this.tire = t;
        System.out.println("Car(Tire t) 생성자입니다.");
    }
    
    public Tire getTire() {
        return tire;
    }
    
	   @Autowired 
	   @Qualifier("h1") 
	public void setTire(Tire tire) {
			this.tire = tire;
			System.out.println("setTire(Tire tire)입니다.");
		}

    public void printTireBrand() {
        System.out.println("타이어브랜드는 " + tire.getTireBrand());
    }

}