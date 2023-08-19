package tv.anno03;

import org.springframework.beans.factory.annotation.*;

public class SamsungTV implements TV {
	private Speaker leftSpeaker;
	private Speaker rightSpeaker;

	@Autowired
	public SamsungTV(@Qualifier("xyzs")Speaker leftSpeaker, @Qualifier("abcs") Speaker rightSpeaker) {
		this.leftSpeaker = leftSpeaker;
		this.rightSpeaker = rightSpeaker;
	}

	@Override
	public void turnon() {
		System.out.println("SamsungTV가 켜졌습니다.");
	}

	@Override
	public void turnoff() {
		System.out.println("SamsungTV가 꺼졌습니다.");
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

	@Override
	public void printSpeakerBrand() {
		System.out.println("SamsungTV의 왼쪽 스피커 브랜드: "+ leftSpeaker.getBrand());
		System.out.println("SamsungTV의 왼쪽 스피커 브랜드: "+ rightSpeaker.getBrand());
	}

}
