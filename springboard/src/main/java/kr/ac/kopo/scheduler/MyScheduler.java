package kr.ac.kopo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

	public void crontest() {
		System.out.println("cron test 입니다");
		
		// 금일 회원가입한 회원 수를 통계 db table에 저장해라.
	}
	
	@Scheduled(cron = "0/10 * * * * * ")
	public void crontest2() {
		System.out.println("10초 crontest");
	}
}
