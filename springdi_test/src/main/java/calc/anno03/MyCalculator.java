package calc.anno03;

import org.springframework.beans.factory.annotation.*;

public class MyCalculator {
	int firstNum = 10;
	int secondNum = 3;
	Calculator c;
	
	@Autowired
	public MyCalculator(@Qualifier("sub") Calculator c) {
		this.c = c;
	}

	public void printResult() {
		System.out.println(firstNum + c.symbol() + secondNum + " 결과는 "  + c.calculate(firstNum, secondNum));
	}
	
}
