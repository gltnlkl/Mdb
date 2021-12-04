package com.gulukal.myMdb.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.gulukal.myMdb.dto.ActorDto;
import com.gulukal.myMdb.general.projectInformation.ProjectInformation;

public class ActorDao implements Readable<ActorDto>{

	private static List<ActorDto> listActor;

	private static String pathNames = ProjectInformation.getString("DatabaseInformation.PATH_NAMES_TSV");
	
	
	
	@Override
	public List<ActorDto> object(String s) {
		
		
		listActor = new ArrayList<ActorDto>();

		readLocalFile(s);

		if (!listActor.isEmpty())

			System.out.println(listActor.get(0));

		return listActor;
	 }

	@Override
	public ActorDto readLocalFile(String s) {
		
		String row = "";

		int count = 0;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathNames))) {

			while ((row = bufferedReader.readLine()) != null) {

				count++;

				if (row.toLowerCase().contains(s.toLowerCase())) {

					listActor.add(lineToObject(row));
					
					
					break;
					
				}

			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return listActor.get(0);

		
	}

	@Override
	public ActorDto lineToObject(String s) {

		List<String> listSentence = new ArrayList<>();

		char[] ListLetter = s.toCharArray();

		StringBuilder sentence = new StringBuilder();

		for (int i = 0; i < ListLetter.length; i++) {
			char c = ListLetter[i];

			if (c != '\t') {

				sentence.append(c);

			} else {

				listSentence.add(sentence.toString());

				sentence = new StringBuilder("");
			}

		}

		listSentence.add(sentence.toString());

		ActorDto myActor = new ActorDto(listSentence.get(0), listSentence.get(1), listSentence.get(2),
				listSentence.get(3), listSentence.get(4), listSentence.get(5));

		return myActor;
	}

	@Override
	public void object(List<ActorDto> t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readLocalFile(List<ActorDto> t) {
		// TODO Auto-generated method stub
		
	}
}
