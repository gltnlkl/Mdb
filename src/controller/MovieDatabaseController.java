package controller;

import java.util.ArrayList;
import java.util.List;

import dao.Inquirable;
import dao.MovieDatabaseDao;
import dto.MovieDatabaseDto;
import general.g11N.GlobalString;

public class MovieDatabaseController implements Inquirable<MovieDatabaseDto>{
	
	private MovieDatabaseDto movieDatabaseDto;
	private MovieDatabaseDao movieDatabaseDao;
	private List<MovieDatabaseDto> movieDBList;
	
	
	public MovieDatabaseController() {
		movieDatabaseDto = new MovieDatabaseDto();
		movieDatabaseDao = new MovieDatabaseDao();
		movieDBList = new ArrayList<MovieDatabaseDto>();
	 }
	
	
	
	public ArrayList<MovieDatabaseDto> movieListQueryWyear(String year , String movieType,GlobalString globalization) {
		return movieDatabaseDao.movieDBListQueryWyear(year, movieType, globalization);
	}
	
	public ArrayList<MovieDatabaseDto> movieListQueryWtype(String movieType, GlobalString globalization) {
		return movieDatabaseDao.movieDBListQueryWtype( movieType, globalization);
	}

	
	public String ratingDBquerryWtitleMin(String movieName, GlobalString globalization ) {
		return movieDatabaseDao.ratingDBquerryWtitleMin(movieName,globalization);
		
	}
	
	public String ratingDBquerryWtitleMax(String movieName, GlobalString globalization ) {
		return movieDatabaseDao.ratingDBquerryWtitleMax(movieName,globalization);
		
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



	public MovieDatabaseDto getMovieDatabaseDto() {
		return movieDatabaseDto;
	}



	public void setMovieDatabaseDto(MovieDatabaseDto movieDatabaseDto) {
		this.movieDatabaseDto = movieDatabaseDto;
	}



	public MovieDatabaseDao getMovieDatabaseDao() {
		return movieDatabaseDao;
	}



	public void setMovieDatabaseDao(MovieDatabaseDao movieDatabaseDao) {
		this.movieDatabaseDao = movieDatabaseDao;
	}



	public List<MovieDatabaseDto> getMovieDBList() {
		return movieDBList;
	}



	public void setMovieDBList(List<MovieDatabaseDto> movieDBList) {
		this.movieDBList = movieDBList;
	}



	





	



	
	
	
	

}
