package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {


	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	
	//19c ����
	
	//URL�� �������� ��ġ �����Ͽ� �׽�Ʈ
	private static final String url = "";
	private static final String user = "";
	private static final String pwd = "";
	private Connection con;
	private Statement stmt;

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle ����̹� �ε� ����");
			System.out.println("url : "+ url);
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
			stmt = con.createStatement();
			System.out.println("Statement ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}//end try
	}//end conn..

	
}