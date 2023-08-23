package kr.ac.kopo.test;

import static org.junit.Assert.assertNotNull;

import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import kr.ac.kopo.board.service.*;
import kr.ac.kopo.board.vo.*;

@ContextConfiguration(locations = {"classpath:config/spring/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SessionTest {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@Test
	public void BoardServiceTest() {
		
		List<BoardVO> boardlist = 
		boardServiceImpl.getAllBoard();
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardlist);
		}
	}
	
	@Ignore
	@Test
	public void sessionTemplateTest() {
		assertNotNull(sqlSessionTemplate);
	}
	
	@Test
	public void boardSelectAllTest() {
		List<BoardVO> boardlist = 
		sqlSessionTemplate.selectList
		("springboard.board.dao.BoardDAO.selectAll");
		
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
	

}
