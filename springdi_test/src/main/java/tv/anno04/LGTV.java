package tv.anno04;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("lgtv")
public class LGTV implements TV {
	private Speaker leftSpeaker;
	private Speaker rightSpeaker;

	@Autowired
	public LGTV(@Qualifier("abcs")Speaker leftSpeaker, @Qualifier("xyzs") Speaker rightSpeaker) {
		this.leftSpeaker = leftSpeaker;
		this.rightSpeaker = rightSpeaker;
	}

	@Override
	public void printSpeakerBrand() {
		System.out.println("LGTV의 왼쪽 스피커 브랜드: " + leftSpeaker.getBrand());
		System.out.println("LGTV의 오른쪽 스피커 브랜드: " + rightSpeaker.getBrand());
	}

	@Override
	public void turnon() {
		System.out.println("LGTV가 켜졌습니다.");
	}

	@Override
	public void turnoff() {
		System.out.println("LGTV가 꺼졌습니다.");
	}


	@Override
	public void volumeup() {
		leftSpeaker.volumeup();
		rightSpeaker.volumeup();
	}

	@Override
	public void volumedown() {
		leftSpeaker.volumedown();
		rightSpeaker.volumedown();
	}
}
