package di.xml01;

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

	public void setTire(Tire tire) {
		System.out.println("SetTire(Tire tire)입니다.");
		this.tire = tire;
	}
	
	public void printTireBrand() {
	System.out.println("타이어브랜드는 " + tire.getClass());
	}
	
}
