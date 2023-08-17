package test.ex01;

public class LGTV implements TV {
	private Speaker leftSpeaker;
	private Speaker rightSpeaker;
	
	
	public LGTV(Speaker leftSpeaker, Speaker rightSpeaker) {
		super();
		this.leftSpeaker = leftSpeaker;
		this.rightSpeaker = rightSpeaker;
	}

	@Override
	public void turnon() {
		System.out.println("tv가 켜졌습니다.");
	}

	@Override
	public void turnoff() {
		System.out.println("tv가 꺼졌습니다.");
	}

	@Override
	public void volumeup() {
		System.out.println("volumeup: 볼륨을 높입니다.");
	}

	@Override
	public void volumedown() {
		System.out.println("volumedown: 볼륨을 내립니다.");

	}

	@Override
	public void printSpeakerBrand() {
		System.out.println("LGTV의 왼쪽 스피커 브랜드: " + leftSpeaker.getBrand());
		System.out.println("LGTV의 오른쪽 스피커 브랜드: " + rightSpeaker.getBrand());
	}

}
