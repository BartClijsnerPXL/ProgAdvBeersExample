package be.pxl.student.beers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection(String jdbcUrl) throws SQLException {
		return DriverManager.getConnection(jdbcUrl, null, null);
	}

	public static Connection getConnection(String jdbcUrl, String username, String password) throws SQLException {
		return DriverManager.getConnection(jdbcUrl, username, password);
	}


}
