package mybatis;

import java.util.*;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {

	private SqlSession sqlSession;

	// 생성자 생성
	public BoardDAO() {

	}

	public BoardDAO(SqlSession session) {
		this.sqlSession = session;
	}

	// db에 sql 호출
	public void work() {
//      insertNewPost();
//	   selectAllPost();
//	   selectbyName();
//	   selectbyName2();
//	   selectbyNo();
//		updateTitle();		
		System.out.println("시작");
		//selectAllPost();
		
//		selectDynamicSQL();
//		System.out.println("나중");		
//		selectAllPost();
//		selectDynamicSQLif();
//		selectDforeach();
		selectDforeach2();
	}
	
	public void selectDforeach2() { //foreach
		BoardVO b1 = new BoardVO();
		int[] a1 = {1,2,3,4,5,6,7};
		b1.setNumbers(a1);
		
		List<BoardVO> boardlist
		= sqlSession.selectList("mybatis.BoardDAO.selectDforeach2");
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
	
	public void selectDforeach() { //foreach
		int[] a1 = {1,2,3,4,5,6};
		List<BoardVO> boardlist
		= sqlSession.selectList("mybatis.BoardDAO.selectDforeach1", a1);
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
	
	public void selectDynamicSQLif() {
		//id="selectDSQLif"
		//
		
			BoardVO board = new BoardVO();
			board.setTitle("좋은아침");
			List<BoardVO> boardlist
			
			= sqlSession.selectList("mybatis.BoardDAO.selectDSQLif1", board); 
//			= sqlSession.selectList("mybatis.BoardDAO.selectDSQLif1", "좋은아침"); 
			

			for (BoardVO boardVO : boardlist) {
					System.out.println(boardVO);
				}
	}
	
	
	public void selectDynamicSQL2() {
		// 홍길동이 쓴 "이벤트 공지" 글 찾아
		BoardVO inputboardVO = new BoardVO();
		inputboardVO.setTitle("이벤트 공지");
		inputboardVO.setWriter("홍길동");
		List<BoardVO> boardlist = 
		sqlSession.selectList("mybatis.BoardDAO.selectDSQL", inputboardVO);
		
		for (BoardVO resultboardVO : boardlist) {
			System.out.println(resultboardVO);
		}
	}
	
	public void selectDynamicSQL() {
		// 홍길동이 쓴 "이벤트 공지" 글 찾아
		BoardVO inputboardVO = new BoardVO();
		inputboardVO.setTitle("이벤트 공지");
		inputboardVO.setWriter("홍길동");
		List<BoardVO> boardlist = 
		sqlSession.selectList("mybatis.BoardDAO.selectDSQL", inputboardVO);
		
		for (BoardVO resultboardVO : boardlist) {
			System.out.println(resultboardVO);
		}
	}
		
	public void deletebyName() {
		sqlSession.delete("mybatis.BoardDAO.deletebyName", "이호창");
		sqlSession.commit();
	}
	
	public void deletebyNo() {
		sqlSession.delete("mybatis.BoardDAO.deletebyName", "이호창");
		sqlSession.commit();
	}
	
	public void updateTitle() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("바뀐 제목입니다");
		boardVO.setNo(1);
		sqlSession.update("mybatis.BoardDAO.updateTitle", boardVO);
		sqlSession.commit();
	}
	

	public void selectbyNo2() {
//		Map을 resultType으로 준다
		Map<String, Object> map = sqlSession.selectOne("mybatis.BoardDAO.selectbyNo2", 10);
		Set<String> keyset = map.keySet(); // {no, title, writer}
		for (String key : keyset) {
			System.out.println(key + " : " + map.get(key));
		}

	}

	public void selectbyNo() {
		BoardVO board = sqlSession.selectOne("mybatis.BoardDAO.selectbyNo", 10);
		System.out.println(board);
	}

	public void selectbyName2() {
		List<BoardVO> boardlist = sqlSession.selectList("mybatis.BoardDAO.selectbyName", "홍길동");

		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}

	public void selectbyName() {
		BoardVO boardVO1 = new BoardVO();
		boardVO1.setWriter("홍길동");
		// mapper의 namespace.id
		// 입력값으로는 홍길동이 들어있는 boardVO를 넘길게
		List<BoardVO> boardlist = sqlSession.selectList("mybatis.BoardDAO.selectbyName", boardVO1);

		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}

	public void selectAllPost() {
//		BoardVO boardVO = new BoardVO();
		
		// selectList는 리턴해줄 때 list형태로 해줌
		// selectOne은 한 개만 리턴해줌
		List<BoardVO> boardlist = sqlSession.selectList("mybatis.BoardDAO.selectAll");

		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}

	}

	public void insertNewPost() {
		// namespace + id의 조합
//	   sqlSession.insert("mybatis.BoardDAO.insertNewPost");
//	   sqlSession.commit();
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("두번째 제목이요");
		boardVO.setWriter("임지은");
		boardVO.setContent("내용이요");
		sqlSession.insert("mybatis.BoardDAO.insertNewPost2", boardVO);
		sqlSession.commit();
	}

}