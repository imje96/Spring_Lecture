package test.ex01;

import org.springframework.context.*;
import org.springframework.context.annotation.*;

import di.java.*;

public class User {
		public static void main(String[] args) {
			

	        
			
			Speaker abcSpeaker = new AbcSpeaker();
			Speaker xyzSpeaker = new XyzSpeaker();
			
	        TV samsungTV = new SamsungTV(abcSpeaker, xyzSpeaker);
	        TV lgTv = new LGTV(abcSpeaker, xyzSpeaker);


	        // TV와 Speaker의 메소드 사용
	        samsungTV.turnon();
	        samsungTV.volumeup();
	        samsungTV.volumedown();
	        samsungTV.printSpeakerBrand();
	        samsungTV.turnoff();
	        
	        lgTv.turnon();
	        lgTv.volumeup();
	        lgTv.volumedown();
	        lgTv.printSpeakerBrand();
	        lgTv.turnoff();

		}
}
