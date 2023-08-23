package kr.ac.kopo.board.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import kr.ac.kopo.board.service.*;
import kr.ac.kopo.board.vo.*;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//http://localhost:8080.springboard/board
	@GetMapping("/board")
	public ModelAndView getAllBoard() {
		
		ModelAndView mav = new ModelAndView("board/boardlist");
		List<BoardVO> boardlist =  boardService.getAllBoard();
		//WEB-INF/jsp/ board/boardlist  .jsp
		mav.addObject("boardlist", boardlist);
		return mav;
	}
}
