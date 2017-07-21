package com.javaex.jdbc.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class friend {
public static void main (String []args) {
	//0. import java.sql.*;
	Connection conn = null;
	PreparedStatement pstmt =null;

	//1. JDBC 드라이버 (Oracle) 로딩

	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	System.out.println("드라이버 로딩");
	//2. Connection 얻어오기
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	conn=DriverManager.getConnection(url,"webdb","webdb");
	
	System.out.println("접속성공");
	//3. SQL문 준비 / 바인딩 / 실행
	String query ="insert into friend values('주이슬',24,'부산')";
	pstmt=conn.prepareStatement(query);
	
	int countdb = pstmt.executeUpdate();
	System.out.println(countdb +"처리한 갯수 ");
	}
	
	// 4.결과처리
	catch(ClassNotFoundException e) {
		System.out.println(e);
	}
	catch(SQLException e) {
		System.out.println(e);
	}
	//5. 자원정리
	finally {
		try {
			if(pstmt!= null) {
				pstmt.close();
				
			}
			if(conn != null) {
				conn.close();
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

	
}
}
