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

	@Before
	public void setUp() throws Exception {
		app = new App();
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

}
