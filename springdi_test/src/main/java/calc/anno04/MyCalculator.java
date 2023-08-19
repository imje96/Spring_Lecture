package calc.anno04;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

public class MyCalculator {
	int firstNum = 10;
	int secondNum = 3;
	Calculator c;
	
	@Autowired
	public MyCalculator(@Qualifier("add") Calculator c) {
		this.c = c;
	}

	public void printResult() {
		System.out.println(firstNum + c.symbol() + secondNum + " 결과는 "  + c.calculate(firstNum, secondNum));
	}
	
}
