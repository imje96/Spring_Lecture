package kr.ac.kopo.board.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import kr.ac.kopo.board.vo.*;

@Repository
public class BoardDAOImpl implements BoardDAO {


	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private BoardDAO boradDAO;
	
	@Override
	public List<BoardVO> getAllPost() {
		List<BoardVO> boardlist
		= sqlSessionTemplate.selectList("springboard.board.dao.BoardDAO.selectAll");
		//mybatis가 아는 이름. sql 문의 이름 mapper.xml 
		
		return boardlist;
	}
	
    @Override
    public BoardVO getPostbyNo(int no) {
        BoardVO boardVO =
                sqlSessionTemplate.selectOne("springboard.board.dao.BoardDAO.selectbyNo", no);
        return boardVO;
    }

    @Override
    public void writeNewPost(BoardVO boardVO) {
        sqlSessionTemplate.insert("springboard.board.dao.BoardDAO.insert", boardVO);
    }

	@Override
	public void increaseCount(int no) {
			sqlSessionTemplate.update("springboard.board.dao.BoardDAO.increaseCount",no);
	}

	@Override
	public void decreaseCount(int no) {
		sqlSessionTemplate.update("springboard.board.dao.BoardDAO.decreaseCount",no);
	}

}
