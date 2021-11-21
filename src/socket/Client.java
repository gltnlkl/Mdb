package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	
	private static Client instance = null;
	
	private Client() {
		
	}

	public static Client getInstance() {
		
		if (instance == null) {
			instance = new Client();
		}
		return instance;
	}

	public void runClient () {

		try {

			String receiveMassege =""; // mesaj almak icin
			String sendMassege = ""; // mesaj gondermek

			// port acilimi yapiyoruz
			Socket socket = new Socket("localhost", SocketPort.PORT);

			// client veri gonderecek
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);


			System.out.println("\n!!!!Lütfen tüm sorgu sonucu icin 30 sn bekleyiniz!!!!\n\nSabriniz icin tesekkurler\n\nSistem iyilestirme calismalari devam etmektedir =)\n\nLütfen sorgu icin aktor ismi giriniz");
			

			while (!sendMassege.equals("0")) {
				
				// clienttan veri alimi
				sendMassege = bufferedReader.readLine();
				printWriter.println(sendMassege);
				printWriter.flush(); // bunu yaparak mesaji tazeleyerek bosaltiyoruz
				

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
		
		

	}
	

}