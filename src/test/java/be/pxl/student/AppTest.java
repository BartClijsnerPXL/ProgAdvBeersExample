package be.pxl.student;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

	App app;
	Connection connection;

	@Before
	public void setUp() throws Exception {
		app = new App ();
		connection = ConnectionFactory.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:StudentDB.sql';MODE=MySQL");

	}

	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	public void it_should_return_hello() {
		Assert.assertEquals("Hello", app.sayHello());
	}

	@Test
	public void it_should_return_hello_world() {
		Assert.assertEquals("Hello World", app.sayHelloWorld());
	}

	@Test
	public void it_should_have_a_valid_connection() throws SQLException {
		Assert.assertTrue(connection.isValid(0));
	}

	@Test
	public void it_should_return_result_list() throws SQLException {
		List<String> beers = app.getBeerNames(connection);
		Assert.assertFalse(beers.isEmpty());
	}

	@Test
	public void should_get_price_jupiler_2_55() throws SQLException {
		Assert.assertEquals(2.55f,app.getBeerPrice(connection, "Jupiler"), 0.01f);
	}

	@Test
	public void should_update_price_jupiler() throws SQLException {
		String beerName = "Jupiler";
		app.updateBeerPrice(connection, beerName, 3.0f);
		Assert.assertEquals(3.0f,app.getBeerPrice(connection, beerName), 0.01f);
	}
}
