package be.pxl.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

	public String sayHello() {
		return "Hello";
	}
	public String sayHelloWorld() {
		return "Hello World";
	}

	public List<String> getBeerNames(Connection connection) throws SQLException {
		List<String> beerNames = new ArrayList<>();
		String queryString = "select * from Beers;";
		try (ResultSet resultSet = connection.prepareStatement(queryString).executeQuery()) {
			while (resultSet.next()) {
				beerNames.add(resultSet.getString("Name"));
			}
		}
		return beerNames;
	}

	public float getBeerPrice(Connection connection, String beerName) throws SQLException {
		String queryString = "Select Price from Beers where name=?";

		try(PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {
			preparedStatement.setString(1, beerName);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.first();
			return resultSet.getFloat(1);
		}
	}

	public int updateBeerPrice(Connection connection, String beerName, float price) throws SQLException {
		String updateQuery = "update Beers set price=? where Name=?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)){
			preparedStatement.setFloat(1, price);
			preparedStatement.setString(2, beerName);
			return preparedStatement.executeUpdate();
		}
	}
}
