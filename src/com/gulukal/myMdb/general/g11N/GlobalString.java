package com.gulukal.myMdb.general.g11N;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class GlobalString {

	private static GlobalString instance;

	public static GlobalString getInstance() {

		if (instance == null) {
			instance = new GlobalString();
		}
		return instance;

	}

	private static final String BUNDLE_NAME = GlobalString.class.getPackageName() + ".Translate";  
	private ResourceBundle resourceBundle;

	public GlobalString(String language, String country) {

		Locale locale = new Locale(language.toLowerCase(), country.toUpperCase());
		this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);

	}

	public GlobalString(String language) {
		Locale locale = new Locale(language.toUpperCase());
		this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
	 }

	public GlobalString() {

		this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
	}

	public String getString(String key) {
		try {
			return this.resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
