package be.pxl.student.beers;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

	@Test
	public void it_should_create_jdbc_url() {
		String servername = "someservername";
		String databasename = "somedatabasename";
		Assert.assertEquals("jdbc:mysql://someservername/somedatabasename", Utils.createJdbcUrl(servername, databasename));
	}


}
