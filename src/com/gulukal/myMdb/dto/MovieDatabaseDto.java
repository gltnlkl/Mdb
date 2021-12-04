package com.gulukal.myMdb.dto;

import java.io.Serializable;



public class MovieDatabaseDto extends MovieCommonProperty implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rating;
	private String tag;   // it can be actor or any comment like funny
	
	public MovieDatabaseDto() {
		this.rating = "";
		this.tag = "";
	}

	
	public MovieDatabaseDto(String primaryTitle) {
		super(primaryTitle);
		
	}
	
	
	public MovieDatabaseDto(String startYear, String primaryTitle) {
		super(startYear, primaryTitle);
		
	 }
	
	public MovieDatabaseDto(String id, String primaryTitle, String genres, String startYear, String endYear,
			String rating, String tag) {
		super(id, primaryTitle, genres, startYear, endYear);
		this.rating = rating;
		this.tag = tag;
	}

	@Override
	public String toString() {
		return getPrimaryTitle();}

	
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	

}
	
	
	

