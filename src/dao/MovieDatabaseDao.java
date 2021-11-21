package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MovieDatabaseDto;
import general.g11N.GlobalString;

public class MovieDatabaseDao implements Inquirable<MovieDatabaseDto> {

	public ArrayList<MovieDatabaseDto> movieDBListQueryWyear(String year, String movieType,
			GlobalString globalization) {

		ArrayList<MovieDatabaseDto> movieList = new ArrayList<MovieDatabaseDto>();

		MovieDatabaseDto mdt;

		try (Connection connection = getInterfaceConnection()) {

			String sql = "SELECT DISTINCT title FROM movies WHERE (title LIKE CONCAT( '%',?,'%')) AND (genres LIKE CONCAT( '%',?,'%')) ORDER BY title LIMIT 10;";
			String sql1 = "SELECT DISTINCT title FROM movies WHERE (title LIKE  ? ) AND (genres LIKE  ?) ORDER BY title LIMIT 10;";

			
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, "%"+year+"%");
			preparedStatement.setString(2, "%"+movieType+"%");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				mdt = new MovieDatabaseDto();
 
				mdt.setPrimaryTitle(resultSet.getString("title"));

				movieList.add(mdt);

			 }

		} catch (SQLException e) {
			System.out.println(e.getMessage() + (globalization.getString("Globalization.ERROR_OCCURRED")));
			e.printStackTrace();
		}

		return movieList;
	}

	public ArrayList<MovieDatabaseDto> movieDBListQueryWtype(String movieType, GlobalString globalization) {

		ArrayList<MovieDatabaseDto> movieList = new ArrayList<MovieDatabaseDto>();

		MovieDatabaseDto mdt;

		try (Connection connection = getInterfaceConnection()) {

			String sql = "SELECT DISTINCT split_part ((split_part(title::TEXT,'(', 2) )::TEXT, ')',1 ) as movie_year, split_part(title::TEXT,'(', 1) as title,tag  FROM tags as t ,movies as m WHERE m.movie_id=t.movie_id and genres LIKE CONCAT( '%',?,'%') LIMIT 10 ;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, movieType);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				mdt = new MovieDatabaseDto();

				mdt.setStartYear(resultSet.getString("movie_year"));
				mdt.setPrimaryTitle(resultSet.getString("title"));
				mdt.setTag(resultSet.getString("tag"));
			

				movieList.add(mdt);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + (globalization.getString("Globalization.ERROR_OCCURRED")));
			e.printStackTrace();
		}

		return movieList;
	}

	public String ratingDBquerryWtitleMin(String movieName, GlobalString globalization) {

		MovieDatabaseDto mdt;
		String raiting = "";

		try (Connection connection = getInterfaceConnection()) {

			String sql = " SELECT MIN (rating) FROM ratings r, movies m WHERE r.movie_id =m.movie_id AND m.title  LIKE CONCAT( '%',?,'%');";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, movieName);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				mdt = new MovieDatabaseDto();

				mdt.setRating(resultSet.getString("min"));

				raiting = mdt.getRating();

				return raiting;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + (globalization.getString("Globalization.ERROR_OCCURRED")));
			e.printStackTrace();

		}
		return raiting;

	}

	public String ratingDBquerryWtitleMax(String movieName, GlobalString globalization) {

		MovieDatabaseDto mdt;
		String raiting = "";

		try (Connection connection = getInterfaceConnection()) {

			String sql = " SELECT MAX (rating) FROM ratings r, movies m WHERE r.movie_id =m.movie_id AND m.title  LIKE CONCAT( '%',?,'%');";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, movieName);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				mdt = new MovieDatabaseDto();

				mdt.setRating(resultSet.getString("max"));

				raiting = mdt.getRating();

				return raiting;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + (globalization.getString("Globalization.ERROR_OCCURRED")));
			e.printStackTrace();

		}
		return raiting;

	}

	@Override
	public boolean insert(MovieDatabaseDto t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(MovieDatabaseDto t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MovieDatabaseDto t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<MovieDatabaseDto> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
