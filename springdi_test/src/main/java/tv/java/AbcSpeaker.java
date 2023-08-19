package tv.java;

import org.springframework.stereotype.*;

@Component("abcs")
public class AbcSpeaker implements Speaker {

	@Override
	public void volumeup() {
			System.out.println("volumeup: 볼륨을 올립니다.");
	}

	@Override
	public void volumedown() {
		System.out.println("volumedown: 볼륨을 내립니다.");
	}


	@Override
	public String getBrand() {
		return "abcSpeaker";
	}

}
