package com.gulukal.myMdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gulukal.myMdb.dto.MovieDatabaseDto;

public class DatabaseDao implements Inquirable<MovieDatabaseDto> {
	
	
	public void createDatabase() {   // DATABASE YOK IKEN NASIL OLUSTURABILIRIM ?? 

		try (Connection connection = getInterfaceConnection()) {

			String sql = "CREATE DATABASE \"myMdb\" WITH  OWNER = postgres ENCODING = 'UTF8' CONNECTION LIMIT = -1;";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);


			preparedStatement.executeUpdate();
			
			System.out.println("Database olusturuldu");

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}
	 }

	
	public void createDatabaseTables() {

		try (Connection connection = getInterfaceConnection()) {

			String sql = " BEGIN; CREATE TABLE IF NOT EXISTS public.movies(  movie_id integer NOT NULL, title character varying, genres character varying, PRIMARY KEY (movie_id));CREATE TABLE IF NOT EXISTS public.ratings(user_id integer,movie_id integer,rating double precision,\"timestamp\" integer);CREATE TABLE IF NOT EXISTS public.tags( user_id integer,movie_id integer,tag character varying,\"timestamp\" integer);ALTER TABLE public.tags ADD FOREIGN KEY (movie_id) REFERENCES public.movies (movie_id) NOT VALID;ALTER TABLE public.ratings ADD FOREIGN KEY (movie_id) REFERENCES public.movies (movie_id) NOT VALID;END; ";
		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

//			preparedStatement.setString(1, databaseName);
//
			preparedStatement.executeUpdate();
			
			System.out.println("Database de tablolar olusturuldu");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}
	}
	
	
	public void importFilesToTheDatabaseTable() {

		try (Connection connection = getInterfaceConnection()) {

			String sql = " COPY movies(movie_id,title,genres) FROM 'D:\\GULUKAL_JAVA_BOOST\\03_HOMEWORK\\MyMDB\\ml-latest-small\\movies.csv' DELIMITER ',' CSV HEADER; COPY ratings(user_id,movie_id,rating,timestamp) FROM 'D:\\GULUKAL_JAVA_BOOST\\03_HOMEWORK\\MyMDB\\ml-latest-small\\ratings.csv' DELIMITER ',' CSV HEADER; COPY tags(user_id,movie_id,tag,timestamp) FROM 'D:\\GULUKAL_JAVA_BOOST\\03_HOMEWORK\\MyMDB\\ml-latest-small\\tags.csv' DELIMITER ',' CSV HEADER; ";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

//			preparedStatement.setString(1, databaseName);
//
			preparedStatement.executeUpdate();

			System.out.println("Database e dosyalar yuklendi");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}
	}
	
	
	public void deleteDatabase() {
		try (Connection connection = getInterfaceConnection()) {

			String sql = "DROP DATABASE \"myMdb\" ;";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}

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
