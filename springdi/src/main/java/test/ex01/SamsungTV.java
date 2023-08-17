package test.ex01;

public class SamsungTV implements TV {
	private Speaker leftSpeaker;
	private Speaker rightSpeaker;
	
	public SamsungTV(Speaker leftSpeaker, Speaker rihgtSpeaker) {
		this.leftSpeaker = leftSpeaker;
		this.rightSpeaker = rightSpeaker;
	}
	
	@Override
	public void turnon() {
		System.out.println("tv를 켭니다.");
	}

	@Override
	public void turnoff() {
		System.out.println("tv를 끕니다.");
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
