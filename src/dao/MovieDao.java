package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import dto.ActorDto;
import dto.MovieDto;
import general.projectInformation.ProjectInformation;

public class MovieDao implements Readable<MovieDto>{
	

	private static List<MovieDto> listMovie;

	private static String pathMovies = ProjectInformation.getString("DatabaseInformation.PATH_MOVIES_TSV");

	@Override
	public void object(List<ActorDto> t) {

		listMovie = new ArrayList<MovieDto>();

		readLocalFile(t);

		if (!listMovie.isEmpty())

			for (int i = 0; i < listMovie.size(); i++) {
				
				System.out.println(listMovie.get(i)); 

			}
	 }


	@Override
	public void readLocalFile(List<ActorDto> t) {
		String row = "";

		int count = 0;

		String movieNum = t.get(0).getKnownForTitles().toString();

		String[] listMovieNum = movieNum.split(",");

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathMovies))) {

			while ((row = bufferedReader.readLine()) != null) {

				count++;

				for (int i = 0; i < listMovieNum.length; i++) {

					String num = listMovieNum[i];

					if (row.toUpperCase().contains(num.toUpperCase())) {

						listMovie.add(lineToObject(row));

						break;
					}

				}

			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}
		
	}



	@Override
	public MovieDto lineToObject(String s) {
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

		MovieDto myMovie = new MovieDto(listSentence.get(1), listSentence.get(2), listSentence.get(3),
				listSentence.get(5), listSentence.get(8));

		return myMovie;
	}

	@Override
	public ActorDto readLocalFile(String s) {
		return null;
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public List<MovieDto> object(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}