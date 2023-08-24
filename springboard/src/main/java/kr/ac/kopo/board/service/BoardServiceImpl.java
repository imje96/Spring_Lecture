package kr.ac.kopo.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;


    @Override
    public List<BoardVO> getAllBoard() {
        List<BoardVO> boardList = boardDAO.getAllPost();
        return boardList;
    }


    @Override
    public BoardVO getPostbyNo(int no) {
        // boardDAO에게 시킨다
        // 이미 가지고 있는 boardDAO 멤버변수를 가지고 시킴
        BoardVO board = boardDAO.getPostbyNo(no);
        return board;
    }
    
	@Override
	public void writeNewPost(BoardVO boardVO) {
		  boardDAO.writeNewPost(boardVO);
	}

}