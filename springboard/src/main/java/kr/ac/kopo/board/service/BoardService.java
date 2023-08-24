package kr.ac.kopo.board.service;

import java.util.*;

import kr.ac.kopo.board.vo.*;

public interface BoardService {
	List<BoardVO> getAllBoard();
	BoardVO getPostbyNo(int no);
	void writeNewPost(BoardVO boardVO);
}
