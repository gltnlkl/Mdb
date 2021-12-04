package com.gulukal.myMdb.main;

	
	import java.util.Random;

	public class Generator {
		
		
		public static String generateRandomName(int len) {
			String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
	          +"lmnopqrstuvwxyz!@#$%&";
			Random rnd = new Random();
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(chars.charAt(rnd.nextInt(chars.length())));
			return sb.toString();
		}
		
		public static void main(String[] args) {

			System.out.println(generateRandomName(5));
		}
	}


