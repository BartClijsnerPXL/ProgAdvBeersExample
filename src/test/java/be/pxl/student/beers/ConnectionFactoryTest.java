package be.pxl.student.beers;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest {

	@Test
	@Ignore
	public void should_have_valid_connection() throws Exception {
		Connection connection = ConnectionFactory.getConnection(
				Utils.createJdbcUrl("192.168.33.22", "StudentDB"),
				"admin",
				"admin");
		Assert.assertTrue(connection.isValid(0));
	}

	@Test
	public void it_should_have_a_valid_connection() throws SQLException {
		Connection connection = ConnectionFactory.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:StudentDB.sql';MODE=MySQL");
		Assert.assertTrue(connection.isValid(0));
	}

}
