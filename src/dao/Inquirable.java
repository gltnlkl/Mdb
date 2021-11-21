package dao;


import java.sql.Connection;
import java.util.ArrayList;

import database.DatabaseConnection;

// CRUD generics DML

public interface Inquirable<T> {

	// govdesiz metodlar 
	
	public boolean insert(T t);

	public void update(T t);

	public void delete(T t);

	public ArrayList<T> list();
	
	

	// govdeli metot
	
	default Connection getInterfaceConnection() {
		return DatabaseConnection.getInstance().getConnection();
	 }
}
