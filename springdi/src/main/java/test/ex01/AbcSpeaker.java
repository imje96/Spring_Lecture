package test.ex01;

public class AbcSpeaker implements Speaker {
	
	@Override
	public void volumeup() {
		System.out.println("volumeup: 볼륨을 올립니다.");
	}

	@Override
	public void volumedown() {
		System.out.println("volumeup: 볼륨을 올립니다.");
	}


	@Override
	public String getBrand() {
		return "abcSpeaker";
	}

}
