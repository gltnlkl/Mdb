package com.gulukal.myMdb.controller;

import java.io.IOException;
import java.nio.CharBuffer;

import com.gulukal.myMdb.dao.MovieDao;

public class MovieController implements Readable {

	private MovieDao movieDao;

	public MovieController() {
		
		movieDao = new MovieDao();

	 }

	@Override
	public int read(CharBuffer cb) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}



}