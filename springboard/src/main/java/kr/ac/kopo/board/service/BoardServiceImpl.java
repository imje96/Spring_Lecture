package kr.ac.kopo.board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import kr.ac.kopo.board.dao.*;
import kr.ac.kopo.board.vo.*;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getAllBoard() {
		// BoardDAO에 일을 시킴. data 가져와
		// 가공함
		List<BoardVO> boardlist = boardDAO.getAllPost();
		return boardlist;
	}

}
