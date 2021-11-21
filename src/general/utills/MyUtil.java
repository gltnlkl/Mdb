package general.utills;

import java.util.Map;
import java.util.Scanner;

import general.g11N.GlobalString;
import menu.MenuMethod;

public class MyUtil {

	MenuMethod menuMethod = new MenuMethod();

	// suitable util class which is included methods for MyMDB project

	public static int showMenuI2(String title, String title1, Map<Integer, String> menu) {

		printLine(24);

		printTitle(title, 24);

		printTitle(title1, 24);

		for (Map.Entry<Integer, String> entry : menu.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			print(String.format("%02d . %-30s ", key, val), 2, true);

		}
		printLine(24);
		return selectDigitSecim();
	}

	// baslik ekleme
	public static void printTitle(String msg, int length) {

		printLine(length);
		int center = (Math.round(length + 10) / 2);
		int end = (length + 10) - (center + msg.length());
		print(String.format("%." + center + "s%s%" + end + "s", "", msg, ""), 2, true);
		printLine(length);
	}

	// baslik ve menu icin cizgiler olusturma
	public static void printLine(int msgLong) {

		int lineLong = (msgLong % 2 == 0) ? msgLong + 20 : msgLong + 20;
		StringBuilder line = new StringBuilder();
		line.append("\t\t");
		for (int i = 0; i < lineLong; i++) {
			line.append("-");
		}
		System.out.printf("%s\n", line);
	}

	// baslik ve menu icin print methodu
	public static void print(String msg, int tabCount, boolean ln) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < tabCount; i++) {
			b.append("\t");
		}
		b.append(msg);
		b.append(ln ? "\n" : "");
		System.out.print(b);

	}

	public static int selectDigitSecim() {
		Scanner input = new Scanner(System.in);

		do {

			try {

				int inputInt = input.nextInt();
				return inputInt;

			} catch (Exception e) {
				System.out.println("Lutfen belirtilen degerlerden secim yapiniz.\nTekrar Deneyiniz.");
				input.nextLine();
				input.close();

			}

		} while (true);
	}

	// menu olusturma return int
	public static int showMenuI(String title, Map<Integer, String> menu , GlobalString globalization ) {

	
		printTitle(title, 24);

		for (Map.Entry<Integer, String> entry : menu.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			print(String.format("%02d . %-30s ", key, val), 2, true);

		}
		printLine(24);
		System.out.println(globalization.getString("Globalization.SELECT_VALUE_FROM_MENU"));
		printLine(24);
		return selectDigitSecim();
	}
	
	
	public static String showMenuReturnString(String title, Map<Integer, String> menu , GlobalString globalization ) {

		
		printTitle(title, 24);

		for (Map.Entry<Integer, String> entry : menu.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			print(String.format("%02d . %-30s ", key, val), 2, true);

		}
		printLine(24);
		System.out.println(globalization.getString("Globalization.SELECT_VALUE_FROM_MENU"));
		printLine(24);
		
		
		return menu.get(selectDigitSecim())  ;  
	}
	
	

	


}
