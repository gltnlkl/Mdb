package com.gulukal.myMdb.dto;

import java.io.Serializable;


public class MovieDto extends MovieCommonProperty implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titleType;
	private String origanalTitle;
	private String isAdult;
	private String runtimeMinutes;
	
	public MovieDto() {
		this.titleType = "";
		this.origanalTitle = "";
		this.isAdult = "";
		this.runtimeMinutes = "";
	}
	

	


	public MovieDto(String id, String titleType,String primaryTitle,String origanalTitle, String isAdult,String startYear, String endYear, 
			 String runtimeMinutes, String genres) {
		super(id, primaryTitle, genres, startYear, endYear);
		this.titleType = titleType;
		this.origanalTitle = origanalTitle;
		this.isAdult = isAdult;
		this.runtimeMinutes = runtimeMinutes;
	 }

	public MovieDto(String titleType,String primaryTitle,String origanalTitle, String startYear, String genres) {
		super(primaryTitle, genres, startYear);
		this.titleType = titleType;
		this.origanalTitle = origanalTitle;
	}


	@Override
	public String toString() {
		return  "\n\t\tFilm Adi : " + origanalTitle.toUpperCase() + "\n\t\tFilm Yili : "+   getStartYear() +  "\n\t\tFilm Turu : " 
				
				+ getGenres() +"\n" ;
	}


	public String getTitleType() {
		return titleType;
	}


	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}


	public String getOriganalTitle() {
		return origanalTitle;
	}


	public void setOriganalTitle(String origanalTitle) {
		this.origanalTitle = origanalTitle;
	}


	public String getIsAdult() {
		return isAdult;
	}


	public void setIsAdult(String isAdult) {
		this.isAdult = isAdult;
	}


	public String getRuntimeMinutes() {
		return runtimeMinutes;
	}


	public void setRuntimeMinutes(String runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}
	
	
	
	
	
	
	
	

}
