package di.anno04;

import org.springframework.stereotype.Component;

@Component("n")
public class NexenTire implements Tire {
	
	public String getTireBrand() {
		// TODO Auto-generated method stub
		return "넥센타이어";
	}
	

}