package menu;

import general.g11N.GlobalString;
import general.utills.MyUtil;

public class LanguageMethod {

	public GlobalString g11n() {

		MenuItems menuItems = new MenuItems();

		boolean isloop = false;
		do {
			int languageSelection = MyUtil.showMenuI2(

					"MyMDB UYGULAMASINA HOS GELDINIZ!", "Lutfen kullanmak istediginiz dili seciniz",

					menuItems.languageSelectionMenuItems());

			if (languageSelection == 0) {

				return new GlobalString("tr", "TR");

			} else if (languageSelection == 1) {

				return new GlobalString("en", "US");

			} else if (languageSelection == 2) {

				return new GlobalString("de", "DE");

			} else if (languageSelection == 3) {

				return new GlobalString("fr", "FR");

			} else {

				System.out.println("Lutfen gecerli bir deger giriniz");

				isloop = true;
			}
		} while (isloop);

		return new GlobalString();

	}
	
}
