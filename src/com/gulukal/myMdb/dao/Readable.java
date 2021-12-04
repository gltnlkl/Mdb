package com.gulukal.myMdb.dao;

import java.util.List;

import com.gulukal.myMdb.dto.ActorDto;

public interface Readable<T> {
	

	
	public List<T> object(String s);
	
	public void object(List<ActorDto> t);
	
	public ActorDto readLocalFile(String s);

	public T lineToObject(String s);

	void readLocalFile(List<ActorDto> t);


	
	

 }
