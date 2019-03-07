package be.pxl.student.repositories;

import be.pxl.student.App;
import be.pxl.student.ConnectionFactory;
import be.pxl.student.exceptions.EntityNotFoundException;
import be.pxl.student.model.Beer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class BeerDAOTest {

	BeerDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new BeerDAO(ConnectionFactory.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:StudentDB.sql';MODE=MySQL"));
	}


	@Test
	public void it_should_return_result_list() throws SQLException {
		List<String> beers = dao.getBeerNames();
		Assert.assertFalse(beers.isEmpty());
	}

	@Test
	public void should_get_price_jupiler_2_55() throws SQLException {
		Assert.assertEquals(2.55f,dao.getBeerPrice("Jupiler"), 0.01f);
	}

	@Test
	public void should_update_price_jupiler() throws SQLException {
		String beerName = "Jupiler";
		dao.updateBeerPrice( beerName, 3.0f);
		Assert.assertEquals(3.0f,dao.getBeerPrice(beerName), 0.01f);
	}

	@Test (expected = EntityNotFoundException.class)
	public void should_return_exception_for_beer_with_id_1() throws SQLException, EntityNotFoundException {
		Beer expectedBeer = new Beer(1, "", 0F);
		Beer actualBeer = dao.getBeerById(1);
		Assert.assertEquals(expectedBeer, actualBeer);
	}

	@Test
	public void should_return_beer_object_with_id_4() throws SQLException, EntityNotFoundException {
		Beer expectedBeer = new Beer(4, "A.C.O.", 2.75F);
		Beer actualBeer = dao.getBeerById(4);
		Assert.assertEquals(expectedBeer, actualBeer);
	}
}
