package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*DAO : 데이터 접근 객체의 약자, 실제로 데이터베이스에 접근을 해서 바로 빼올 수 있게 해주는 역할을 하는 클래스*/

public class BbsDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// BbsDAO class에서는 여러개의 메서드가 사용되기 때문에, 
	// 접근에 마찰이 일어나지 않기 위해 PreparedStatement는 각각 메서드 안에서 초기화
	public String getDate() { //게시판 작성시, 시간을 DB에 넣는 메서드
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // 데이터베이스 오류
	}
	
	public int getNext() { //게시판 작성시, 시간을 DB에 넣는 메서드
		String SQL = "SELECT bbsID FROM BBS ORDER By bbsID DESC";
		// 게시글 번호는 1부터 늘어나야 되기때문에 새로 생성할 때, 마지막에 쓰인 글을 가져와서 그 번호의 +1을 해야됨
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 게시글이 첫 게시물인 경우
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
}
