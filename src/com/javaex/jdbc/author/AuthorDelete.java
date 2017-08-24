package com.javaex.jdbc.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDelete {

	public static void main(String[] args) {
		
		
			//다필요없어서 다 지움 
		
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
				String query = "DELETE FROM author WHERE author_id = 12";
				pstmt = conn.prepareStatement(query);
				
				
				//insert 에  유동적인 문장 설정을 위해 들어갔던것이 없어짐 
				
				int countdb = pstmt.executeUpdate();
				System.out.println("처리한 쿼리 개수 : "+countdb);
				
				
				
				
				System.out.println();
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
		
	
		
	}//메인의 괄호

}//클래스 괄호 



