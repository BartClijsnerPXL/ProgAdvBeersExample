package be.pxl.student.beers;

import static org.junit.Assert.assertTrue;

import be.pxl.student.beers.entity.BeersDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class BeersDAOTest {

	BeersDAO dao;
	Connection connection;

	@Before
	public void setUp() throws Exception {
		dao = new BeersDAO ();
		connection = ConnectionFactory.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:StudentDB.sql';MODE=MySQL");
	}

	@Test
	public void it_should_return_result_list() throws Exception {
		List<String> beers = dao.getBeerNames(connection);
		Assert.assertFalse(beers.isEmpty());
	}

	@Test
	public void should_get_price_jupiler_2_55() throws Exception {
		Assert.assertEquals(2.55f, dao.getBeerPrice(connection, "Jupiler"), 0.01f);
	}

	@Test
	public void should_update_price_jupiler() throws Exception {
		String beerName = "Jupiler";
		dao.updateBeerPrice(connection, beerName, 3.0f);
		Assert.assertEquals(3.0f, dao.getBeerPrice(connection, beerName), 0.01f);
	}
}
