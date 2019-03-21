package be.pxl.student.beers;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectFactoryTest {

	@Test
	@Ignore
	public void should_return_a_valid_connection_with_user_and_password() throws SQLException {
		Connection connection = ConnectionFactory.getConnection(
				Utils.createJdbcUrl("192.168.33.22", "StudentDB"),
				"admin",
				"admin");
		Assert.assertTrue(connection.isValid(0));
	}

	@Test
	public void should_return_a_valid_connection_with_jdbc_url_only() throws SQLException {
		Connection connection = ConnectionFactory.getConnection(
				"jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:StudentDB.sql';MODE=MySQL");
		Assert.assertTrue(connection.isValid(0));
	}

}
