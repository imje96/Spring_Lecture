package di.xml01;

import java.util.List;

import di.xml01.Tire;

public class Car {
	private Tire tire;
	private String carName;
	private int year;
	private List<String> driver;
	
	public List<String> getDriver() {
		return driver;
	}
	public void setDriver(List<String> driver) {
		this.driver = driver;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Car() {
		System.out.println("Car() 생성자입니다. ");
	}
	public Car(Tire t) {
		this.tire =t;
		System.out.println("Car(Tire t) 생성자입니다. ");
	}
	public Car(String carName, Tire t) {
		this.tire =t;
		this.carName=carName;
		System.out.println("Car(String carName, Tire t) 생성자입니다. ");
	}
	public Car(Tire t,String carName) {
		this.tire =t;
		this.carName=carName;
		System.out.println("Car(Tire t,String carName) 생성자입니다. ");
	}
	public Car(String carName, int year, Tire t) {
	    this.tire = t;
	    this.year = year;
	    this.carName = carName;
	    System.out.println("Car(Tire t, int year, String carName) 생성자입니다. ");
	}
	
	public Tire getTire() {
		return tire;
	}
	public void setTire(Tire tire) {
		System.out.println("setTire(Tire tire) 입니다. ");
		this.tire = tire;
		
	}
	public void printTireBrand() {
		System.out.println("타이어 브랜드는 : "+tire.getTireBrand());
	}
}
