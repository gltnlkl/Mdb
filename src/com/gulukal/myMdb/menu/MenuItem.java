package com.gulukal.myMdb.menu;

import java.util.HashMap;
import java.util.Map;

import com.gulukal.myMdb.general.g11N.GlobalString;

public class MenuItem {

	protected Map<Integer, String> mainMenuItems(GlobalString globalization) {

		Map<Integer, String> mapList = new HashMap<Integer, String>();
		
		

		mapList.put(0, globalization.getString("Globalization.LIST_OF_MOVIES_BY_YEAR")); //$NON-NLS-1$
		mapList.put(1, globalization.getString("Globalization.LIST_OF_MOVIES_BY_GENRE")); //$NON-NLS-1$
		mapList.put(2, globalization.getString("Globalization.LIST_OF_MOVIES_BY_ACTOR")); //$NON-NLS-1$
		mapList.put(3, globalization.getString("Globalization.MOVIE_LOWEST_AND_HIGHEST_RATED")); //$NON-NLS-1$
		mapList.put(4, globalization.getString("Globalization.EXIT_THE_PROGRAM")); //$NON-NLS-1$

		return mapList;

	}

	// globalization yapilmayacak method
	protected Map<Integer, String> languageSelectionMenuItems() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Turkce");
		mapList.put(1, "Ingilizce");
		mapList.put(2, "Almanca");
		mapList.put(3, "Fransizca");

		return mapList;

	}

	protected Map<Integer, String> movieTypeSelectionMenuItems() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Animation");
		mapList.put(1, "Adventure");
		mapList.put(2, "Animation");
		mapList.put(3, "Children");
		mapList.put(4, "Comedy");
		mapList.put(5, "Crime");
		mapList.put(6, "Documentary");
		mapList.put(7, "Drama");
		mapList.put(8, "Fantasy");
		mapList.put(9, "Film-Noir");
		mapList.put(10, "Musical");
		mapList.put(11, "Mystery");
		mapList.put(12, "Romance");
		mapList.put(13, "Sci-Fi");
		mapList.put(14, "War");
		mapList.put(15, "Western");
		mapList.put(16, "Others");

		return mapList;

	}
}
