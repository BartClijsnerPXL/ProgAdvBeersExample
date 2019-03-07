package be.pxl.student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;

public class AppTestIntegration {

	Connection connection;

	@Test
	@Ignore
	public void should_have_valid_connection() throws Exception {
		connection = ConnectionFactory.getConnection(
				Utils.createJdbcUrl("192.168.33.22", "StudentDB"),
				"admin",
				"admin");
		Assert.assertTrue(connection.isValid(0));

	}
}
