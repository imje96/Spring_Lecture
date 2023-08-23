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
	
	@Override
	public List<BoardVO> getAllPost() {
		List<BoardVO> boardlist
		= sqlSessionTemplate.selectList("springboard.board.dao.BoardDAO.selectAll");
		//mybatis가 아는 이름. sql 문의 이름 mapper.xml 
		
		return boardlist;
	}

}
