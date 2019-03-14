package be.pxl.student.beers;

public class Utils {

	public static String createJdbcUrl (String server, String databasename) {
		return "jdbc:mysql://"+server+"/"+databasename;
	}

}
