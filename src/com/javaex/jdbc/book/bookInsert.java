package com.javaex.jdbc.book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bookInsert {	
public static void main(String []args) {

		String title ="햇님 달님 ";
		String pubs= "정관장";
		String indate = "2017/08/19";
		int aid = 39;
		// TODO Auto-generated method stub
		//0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
				//1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				System.out.println("드라이버 로딩 ");
				//2. Connection 얻어오기
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn=DriverManager.getConnection(url,"webdb","webdb");
				
				System.out.println("접속 성공 ");
				
				
				//3. SQL문 준비 / 바인딩 / 실행
				String query = "insert into book VALUES(SEQ_BOOK_ID.NEXTVAL,"
						+ "?,?,?,?)";
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, title);
				pstmt.setString(2, pubs);
				pstmt.setString(3, indate);
				pstmt.setInt(4, aid);
				
				int countdb = pstmt.executeUpdate();
				System.out.println("처리한 쿼리 개수 : "+countdb);
				// 4.결과처리
				
				
		}catch(ClassNotFoundException e) {
		
			System.out.println("드라이버 로딩  실패 "+e);
			
		}catch(SQLException e ) {
			System.out.println("sql문의 실패  "+e);
		}finally {
			//5. 자원정리
					try {
						
						if(pstmt != null) {
						 pstmt.close();
						}
						if(conn != null) {
						 conn.close();
							}
						}
					catch(SQLException e) {
					System.out.println("sql문의 실패  "+e);
											}
			
		}//finally 괄호 
	}//main
}
