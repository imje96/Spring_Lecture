package calc.java;

import org.springframework.stereotype.*;

@Component("div")
public class DivideCalculator implements Calculator {

	@Override
	public int calculate(int n1, int n2) {
		return n1 / n2;
	}

	@Override
	public String symbol() {
		return "/";
	}
	
}