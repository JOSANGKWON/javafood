package db연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO { //member 테이블에 CRUD를 하고 싶으면 MemberDAO를 사용하면 됨
	//DAO : Db Access Object
	//shop db member talbe 에 접근해서 처리하는 객체
	
	public void insert(String id, String pw, String name, String tel) {
		//JAVA-DB 연결 (JDBC) 4단계
		//1. 연결할 부품(커넥터, driver, 드라이버) 설정
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.커넥터 연결 성공");
			//패키지.대표클래스
			
			//외부 자원 연결(db,network,cpu,file...)
			//너무 위험한 상황
			//상황이 발생했을 때 어떻게 대처할지를 반드시 써주어야 함
			
			//2. 1번 설정을 커넥터로 db연결하고 승인
			// 		1) url - ip+prot+db명			
			// 		2) id, pw
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("2.shop db연결 성공");
			// 		3) 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into member values (?, ?, ?, ?)"; //따옴표 쓰지않음
			String site = "www.naver.com";
			//해당부품으로 만들어주어야 함
			//sql ==> PreparedStatment
			//site ==> URL
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); //물음표 번호 1번에 id에 저장한 변수값을 넣음
			ps.setString(2, pw); //물음표 번호 2번에 pw에 저장한 변수값을 넣음
			ps.setString(3, name); //물음표 번호 3번에 name에 저장한 변수값을 넣음
			ps.setString(4, tel); //물음표 번호 4번에 tel에 저장한 변수값을 넣음
			System.out.println("3. sql문 생성 성공");
			
			
			// 		4) 3번에서 생성된 sql문을 mysql로 전송
			ps.execute();
			System.out.println("4. SQL문 mysql로 전송 성공");
			
		} catch (Exception e) { //Exception == Error
			// TODO Auto-generated catch block
			e.printStackTrace();//에러정보 추척해서 프린트
			System.out.println("에러발생함");
		}
		
		
		
		
		
	}// insert

	public void delete(String id) {	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.커넥터 연결 성공");
			
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("2.shop db연결 성공");
			// 		3) 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "delete from member where id = ?"; 		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); //물음표 번호 1번에 id에 저장한 변수값을 넣음			 
			System.out.println("3. sql문 생성 성공");
			
			
			// 		4) 3번에서 생성된 sql문을 mysql로 전송
			ps.execute();
			System.out.println("4. SQL문 mysql로 전송 성공");
			
		} catch (Exception e) { //Exception == Error
			// TODO Auto-generated catch block
			e.printStackTrace();//에러정보 추척해서 프린트
			System.out.println("에러발생함");
		}
		
		
		
		
		
	}//delete	
	
	public void update(String tel, String id) {
		//JAVA-DB 연결 (JDBC) 4단계
		//1. 연결할 부품(커넥터, driver, 드라이버) 설정
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.커넥터 연결 성공");
			//패키지.대표클래스
			
			//외부 자원 연결(db,network,cpu,file...)
			//너무 위험한 상황
			//상황이 발생했을 때 어떻게 대처할지를 반드시 써주어야 함
			
			//2. 1번 설정을 커넥터로 db연결하고 승인
			// 		1) url - ip+prot+db명			
			// 		2) id, pw
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("2.shop db연결 성공");
			// 		3) 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update member set tel = ? where id = ?"; //따옴표 쓰지않음						
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tel); //물음표 번호 1번에 id에 저장한 변수값을 넣음
			ps.setString(2, id); //물음표 번호 2번에 pw에 저장한 변수값을 넣음
			System.out.println("3. sql문 생성 성공");
			
			
			// 		4) 3번에서 생성된 sql문을 mysql로 전송
			ps.execute();
			System.out.println("4. SQL문 mysql로 전송 성공");
			
		} catch (Exception e) { //Exception == Error
			// TODO Auto-generated catch block
			e.printStackTrace();//에러정보 추척해서 프린트
			System.out.println("에러발생함");
		}
		
		
		
		
		
	}// update
	
	
}
