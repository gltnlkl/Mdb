package com.gulukal.myMdb.dto;

import java.io.Serializable;


public class MovieCommonProperty extends CommonProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String primaryTitle;
	private String genres;
	private String startYear;
	private String endYear;

	public MovieCommonProperty() {
		this.primaryTitle = "";
		this.genres = "";
		this.startYear = "";
		this.endYear = "";
	}

	public MovieCommonProperty(String primaryTitle) {

		this.primaryTitle = primaryTitle;

	 }

	public MovieCommonProperty(String startYear, String primaryTitle) {

		this.primaryTitle = primaryTitle;
		this.startYear = startYear;
	}
	
	public MovieCommonProperty(String primaryTitle,String genres,String startYear ) {

		this.primaryTitle = primaryTitle; 
		this.startYear = startYear;
		this.genres = genres;
	}

	public MovieCommonProperty(String id, String primaryTitle, String genres, String startYear, String endYear) {
		super(id);
		this.primaryTitle = primaryTitle;
		this.genres = genres;
		this.startYear = startYear;
		this.endYear = endYear;
	}

	@Override
	public String toString() {
		return "MovieCommonProperty [primaryTitle=" + primaryTitle + ", genres=" + genres + ", startYear=" + startYear
				+ ", endYear=" + endYear + "]";
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

}
