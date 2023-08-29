package kr.ac.kopo.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@ResponseBody
	@PostMapping("/reply")
	public void writeReply(ReplyVO replyVO) {
        //  서비스에게 시킬 일 
        // 1. 댓글 수 1 증가 로직 필요해 - t_board에서
        // 2. reply를 insert - t_reply 

		replyService.insertReply(replyVO);
		// responseBody가 없으면 void로 적었을 때 view resolver를 이용해서 /reply가 있는줄 알고 보내버림 
		
		
	}
	
	//http://localhost:8080/springboard/reply/3
	// 3번 게시글의 댓글 전체 , get
	
	@GetMapping("/reply/{bno}")
	@ResponseBody
	public List<ReplyVO> getAllReply(@PathVariable("bno") int bno) {
		//미리확인해보기
		List<ReplyVO> replylist = replyService.getReplybyBoardNo(bno);
		for (ReplyVO replyVO : replylist) {
			System.out.println(replyVO);
		}
		return replylist;
//		return replyService.getReplybyBoardNo(bno);
	}
	@ResponseBody
	@DeleteMapping("/reply/{bno}/{replyNo}") //reply/59/100
	public void deleteReply(@PathVariable("bno") int bno,
							@PathVariable("replyNo")int replyNo) {
		// 100번 댓글 지워줘
		  replyService.deleteReplyByNo(bno, replyNo);
	}
	
	

	
	
	
}




