package di.anno04;

import org.springframework.stereotype.Component;

@Component("h")
public class HankookTire implements Tire {
	
	public String getTireBrand() {
		// TODO Auto-generated method stub
		return "한국타이어";
	}
	

}