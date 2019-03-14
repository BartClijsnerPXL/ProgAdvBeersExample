package be.pxl.student.beers.entity;

import be.pxl.student.beers.exceptions.BeersException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeersDAO {

	public List<String> getBeerNames(Connection connection) throws BeersException {
		List<String> beerNames = new ArrayList<>();
		String queryString = "select * from Beers;";
		try (ResultSet resultSet = connection.prepareStatement(queryString).executeQuery()) {
			while (resultSet.next()) {
				beerNames.add(resultSet.getString("Name"));
			}
		} catch (SQLException e) {
			throw new BeersException(e);
		}
		return beerNames;
	}

	public float getBeerPrice(Connection connection, String beerName) throws BeersException {
		String queryString = "Select Price from Beers where name=?";

		try(PreparedStatement preparedStatement = connection.prepareStatement(queryString)) {
			preparedStatement.setString(1, beerName);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.first();
			return resultSet.getFloat(1);
		} catch (SQLException e) {
			throw new BeersException(e);
		}
	}

	public int updateBeerPrice(Connection connection, String beerName, float price) throws BeersException {
		String updateQuery = "update Beers set price=? where Name=?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)){
			preparedStatement.setFloat(1, price);
			preparedStatement.setString(2, beerName);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new BeersException(e);
		}
	}


}
