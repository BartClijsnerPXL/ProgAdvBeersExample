package be.pxl.student.repositories;

import be.pxl.student.exceptions.EntityNotFoundException;
import be.pxl.student.model.Beer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeerDAO {

	Connection connection;

	public BeerDAO(Connection connection) {
		this.connection = connection;
	}

	public List<String> getBeerNames() throws SQLException {
		List<String> beerNames = new ArrayList<>();
		String queryString = "select * from Beers;";
		try (ResultSet resultSet = connection.prepareStatement(queryString).executeQuery()) {
			while (resultSet.next()) {
				beerNames.add(resultSet.getString("Name"));
			}
		}
		return beerNames;
	}

	public float getBeerPrice(String beerName) throws SQLException {
		String query = "Select Price from Beers where name=?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, beerName);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.first();
			return resultSet.getFloat(1);
		}
	}

	public int updateBeerPrice(String beerName, float price) throws SQLException {
		String query = "update Beers set price=? where Name=?";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setFloat(1, price);
			stmt.setString(2, beerName);
			return stmt.executeUpdate();
		}
	}

	public Beer getBeerById(int id) throws SQLException, EntityNotFoundException {
		String query = "select * from Beers where id=?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.first()) {
				throw new EntityNotFoundException();
			}

			return new Beer(
					resultSet.getInt("Id"),
					resultSet.getString("Name"),
					resultSet.getFloat("Price")
			);

		}
	}

}
