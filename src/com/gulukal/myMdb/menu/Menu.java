package com.gulukal.myMdb.menu;

import com.gulukal.myMdb.general.g11N.GlobalString;
import com.gulukal.myMdb.general.utills.MyUtil;

public class Menu {

	public void mainMenu() {

		MenuMethod menuMethod = new MenuMethod();

		LanguageMethod languageMethod = new LanguageMethod();

		MenuItem menuItems = new MenuItem();

		GlobalString globalization = languageMethod.g11n();

		boolean isloop = true;

		do {

			int inputNumber = MyUtil.showMenuI("MyMDB", menuItems.mainMenuItems(globalization), globalization);

			switch (inputNumber) {
			
		

			case 0:

				System.out.println(globalization.getString("Globalization.LIST_OF_MOVIES_BY_YEAR"));

				menuMethod.movieDBqueryWyear(globalization);

				break;
			case 1:

				System.out.println(globalization.getString("Globalization.LIST_OF_MOVIES_BY_GENRE"));

				menuMethod.movieDBqueryWtype(globalization);

				break;
			case 2:

				System.out.println(globalization.getString("Globalization.LIST_OF_MOVIES_BY_ACTOR"));

				menuMethod.actorQueryWclient();

				break;
			case 3:

				System.out.println(globalization.getString("Globalization.MOVIE_LOWEST_AND_HIGHEST_RATED"));

				menuMethod.ratingDBquerryWtitle(globalization);

				break;
			case 4:

				System.out.println(globalization.getString("Globalization.EXIT_NOTE_FOR_CONSOLE"));

				isloop = false;

				break;

			}
		} while (isloop);

	}

}
