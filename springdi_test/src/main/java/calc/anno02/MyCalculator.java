package calc.anno02;

import javax.annotation.*;

import org.springframework.beans.factory.annotation.*;

public class MyCalculator {
	int firstNum = 10;
	int secondNum = 3;
	private Calculator c;
	

	public MyCalculator(Calculator c) {
		this.c = c;
	}
	
	
	public Calculator getC() {
		return c;
	}
	
	@Resource
	public void setC(Calculator c) {
		this.c = c;
	}

	public void printResult() {
		System.out.println(firstNum + c.symbol() + secondNum + " 결과는 "  + c.calculate(firstNum, secondNum));
	}
	
}
