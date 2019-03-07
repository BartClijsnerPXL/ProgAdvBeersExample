package be.pxl.student;

public class Utils {

	public static String createJdbcUrl (String server, String databasename) {
		return "jdbc:mysql://"+server+"/"+databasename;
	}

}
