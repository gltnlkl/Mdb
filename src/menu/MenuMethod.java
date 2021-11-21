package menu;

import java.util.ArrayList;

import controller.MovieDatabaseController;
import dto.MovieDatabaseDto;
import general.g11N.GlobalString;
import general.utills.GenUtil;
import general.utills.MyUtil;
import socket.Client;
import socket.Server;

public class MenuMethod {

	// globalization yapilmayacak tek method !!!

	public void movieDBqueryWyear(GlobalString globalization) {

		String year = String.valueOf(GenUtil.readInt(globalization.getString("Globalization.YEAR_QUERY")));

		String type1 = "Animation";
		String type2 = "Comedy";
		String type3 = "Action";
		String type4 = "Drama";
		String type5 = "Crime";

		System.out.println("\t\t" + type1 + "\n");
		queryWyearAndType(year, type1, globalization);
		System.out.println("\t\t" + type2 + "\n");
		queryWyearAndType(year, type2, globalization);
		System.out.println("\t\t" + type3 + "\n");
		queryWyearAndType(year, type3, globalization);
		System.out.println("\t\t" + type4 + "\n");
		queryWyearAndType(year, type4, globalization);
		System.out.println("\t\t" + type5 + "\n");
		queryWyearAndType(year, type5, globalization);

	}

	public void queryWyearAndType(String year, String type, GlobalString globalization) {

		MovieDatabaseController movieDatabaseController = new MovieDatabaseController();

		ArrayList<MovieDatabaseDto> movieDBqueryWyearList = new ArrayList<MovieDatabaseDto>();

		movieDBqueryWyearList = movieDatabaseController.movieListQueryWyear(year, type, globalization);

		for (int i = 0; i < movieDBqueryWyearList.size(); i++) {

			String[] movieName = movieDBqueryWyearList.get(i).toString().split("\\(");

			System.out.println("\t\t\t" + movieName[0] + "\n");
		}

	}

	public String movieDBqueryWtypeSelection(GlobalString globalization) {

		MenuItems menuItems = new MenuItems();

		return MyUtil.showMenuReturnString(globalization.getString("Globalization.TYPE_QUERY"),
				menuItems.movieTypeSelectionMenuItems(), globalization);

	}

	public void movieDBqueryWtype(GlobalString globalization) {

		MovieDatabaseController movieDatabaseController = new MovieDatabaseController();

		ArrayList<MovieDatabaseDto> movieDBqueryWyearList = new ArrayList<MovieDatabaseDto>();

		movieDBqueryWyearList = movieDatabaseController.movieListQueryWtype(movieDBqueryWtypeSelection(globalization),
				globalization);

		for (int i = 0; i < movieDBqueryWyearList.size(); i++) {

			System.out.println("\t\t" + movieDBqueryWyearList.get(i).getStartYear() + "-"
					+ movieDBqueryWyearList.get(i).getPrimaryTitle() + "-" + movieDBqueryWyearList.get(i).getTag()
					+ "\n");

		}

	}

	public void ratingDBquerryWtitle(GlobalString globalization) {

		String movieName = GenUtil.readString(globalization.getString("Globalization.MOVIE_NAME"));

		MovieDatabaseController movieDatabaseController = new MovieDatabaseController();

		String maxRating = movieDatabaseController.ratingDBquerryWtitleMax(movieName, globalization);
		String minRating = movieDatabaseController.ratingDBquerryWtitleMin(movieName, globalization);

		System.out.println("\n\t\t" + movieName + " " + globalization.getString("Globalization.MOVIE_RATE") + "\n\n\t\t"
				+ globalization.getString("Globalization.MAX") + ": " + maxRating + "\n\n\t\t"
				+ globalization.getString("Globalization.MIN") + ": " + minRating + "\n");

	}

	public void actorQueryWclient() {

		Server srv = new Server();
//		Client clt = new Client();

		Thread s = new Thread(srv);
		s.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

//		Thread c = new Thread(clt);
//		c.run();
		
	    Client.getInstance().runClient();

	}

	public void createDatabase(GlobalString globalization) {
		// TODO Auto-generated method stub
		
	}

	public void deleteDatabase(GlobalString globalization) {
		// TODO Auto-generated method stub
		
	}

}
