package di.java;

import org.springframework.stereotype.*;

// default hankookTire -> h1
@Component("h1")
public class HankookTire implements Tire {

	public String getTireBrand() {
		// TODO Auto-generated method stub
		return "한국타이어";
	}

}
