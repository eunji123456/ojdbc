package com.javaex.jdbc.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bookSelect {
	public static void main(String[] args) {
		
		ResultSet rs = null;
		
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
				String query = "select book_id ,title ,pubs ,pub_date,author_id from book";
				pstmt = conn.prepareStatement(query);
				
				
				//insert 에  유동적인 문장 설정을 위해 들어갔던것이 없어짐 
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int book_id= rs.getInt(1);
					String title = rs.getString(2);
					String pubs= rs.getString(3);
					String pub_date = rs.getString(4);
					int author_id = rs.getInt(5);
					System.out.println(book_id+"\t"
									   +title+"\t"
									   +pubs+"\t"
									   +pub_date+"\t"
									   +author_id+"\t");
					
				}
				
				
				
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
}
