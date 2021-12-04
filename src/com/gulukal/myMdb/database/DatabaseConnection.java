package com.gulukal.myMdb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	// com.gulukal.myMdb.database baglantisini kuracak class
	private Connection connection;

	// url username password cagirmak -- altta static ile obje olusturduk
	private static DatabaseInformation databaseInformation;

	// static -- nullPointer Excepitoni bunu yaparak engelliyoruz
	static {
		databaseInformation = new DatabaseInformation();
	}

	// com.gulukal.myMdb.database baglanmak icin zorunlu yerdir.
	private String url = databaseInformation.getUrl();
	private String userName = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();

	// singleton design pattern 1.ozellik
	private static DatabaseConnection instance;

	// singleton design pattern 2.ozellik
	private DatabaseConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			// System.out.println("postgresql-42.3.1 jar Driver Yuklendi");

			this.connection = DriverManager.getConnection(url, userName, password);
			// System.out.println("Basarili Baglanti.");

		} catch (Exception e) {
			System.out.println("Database Baglanti Sirasinda Hatalar Meydana Geldi");
			e.printStackTrace();
		 }
	}

	// singleton design pattern 3.ozellik
	// syncronized
	public static DatabaseConnection getInstance() {
		try {
			if (instance == null) {
				instance = new DatabaseConnection();
			} else

			if (instance.getConnection().isClosed()) {
				instance = new DatabaseConnection();
			}
		} catch (SQLException e) {

			System.out.println("Singleten Hatasi");
		}
		return instance;
	}

	// getter and setter
	public Connection getConnection() {
		return connection;
	}

}
