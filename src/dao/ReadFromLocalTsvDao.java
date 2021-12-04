package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.ActorDto;
import dto.MovieDto;
import general.projectInformation.ProjectInformation;
import general.utills.GenUtil;

public class ReadFromLocalTsvDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static List<MovieDto> listMovie;

	private static String pathNames = ProjectInformation.getString("DatabaseInformation.PATH_NAMES_TSV");

	private static String pathMovies = ProjectInformation.getString("DatabaseInformation.PATH_MOVIES_TSV");
	
	


	public static void main(String[] args) {

		String actorName = GenUtil.readString("Lutfen aratmak istediginiz aktor ismini giriniz.");

		ActorDto actorObject = readActorName(actorName);

		movie(actorObject);

	 }
	
	
	
	public static ActorDto fileToActor(String row) {

		List<String> listSentence = new ArrayList<>();

		char[] ListLetter = row.toCharArray();

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

	public static ActorDto readActorName(String name) {

		String row = "";

		int count = 0;

		ActorDto actor = null;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathNames))) {

			while ((row = bufferedReader.readLine()) != null) {

				count++;

				if (row.toLowerCase().contains(name.toLowerCase())) {

					actor = fileToActor(row);

					System.out.println(actor);

					break;
				}

			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return actor;

	}
	
	
	
	/// 
	
	
	

	public static void movie(ActorDto actorName) {

		listMovie = new ArrayList<MovieDto>();

		readMovieMovies(actorName);

		if (!listMovie.isEmpty())

			for (int i = 0; i < listMovie.size(); i++) {

				System.out.println(listMovie.get(i));

			}
	}

	public static List<MovieDto> readMovieMovies(ActorDto actorName) {

		String row = "";

		int count = 0;

		String movieNum = actorName.getKnownForTitles().toString();

		String[] listMovieNum = movieNum.split(",");

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathMovies))) {

			while ((row = bufferedReader.readLine()) != null) {

				count++;

				for (int i = 0; i < listMovieNum.length; i++) {

					String num = listMovieNum[i];

					if (row.toUpperCase().contains(num.toUpperCase())) {

						listMovie.add(lineToMovie(row));

						break;
					}

				}

			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return listMovie;

	}

	public static MovieDto lineToMovie(String row) {

		List<String> listSentence = new ArrayList<>();

		char[] ListLetter = row.toCharArray();

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

		MovieDto myMovie = new MovieDto(listSentence.get(1), listSentence.get(2), listSentence.get(3),
				listSentence.get(5), listSentence.get(8));

		return myMovie;
	}

}