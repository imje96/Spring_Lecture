package mybatis;

public class MybatisMain {

   public static void main(String[] args) {
      Config config = new Config();
      
      // 보드 DAO 내부에서 sql세션 가져오기
      BoardDAO boardDAO = new BoardDAO(config.getSqlSession());
      System.out.println("세션연결");
      boardDAO.work();
      System.out.println("연결종료");
   }

}