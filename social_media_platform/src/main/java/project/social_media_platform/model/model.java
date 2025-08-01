package project.social_media_platform.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class model {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "8888");
		System.out.println("連接成功");
	}

}
