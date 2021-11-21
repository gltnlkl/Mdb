package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import dao.ReadFromLocalTsvDao;
import dto.ActorDto;

public class Server implements Runnable {

	@Override
	public void run() {
		
		serverPro();

	}

	public void serverPro() {

		try {

			String receiveMassege = "";
			String sendMassege = "";

			ServerSocket serverSocket = new ServerSocket(SocketPort.PORT);

			System.out.println("Server is ready");

			Socket socket = serverSocket.accept();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			OutputStream outputStream = socket.getOutputStream();

			PrintWriter printWriter = new PrintWriter(outputStream, true);

			InputStream inputStream = socket.getInputStream();
			BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inputStream));
			
			

			while (!receiveMassege.equals("0")) {

				if ((receiveMassege = receiveRead.readLine()) != null && (!receiveMassege.equals("0"))) {

					ActorDto actorObject = ReadFromLocalTsvDao.readActorName(receiveMassege);

					ReadFromLocalTsvDao.movie(actorObject);
 
					System.out.println("Sorguya devam etmek icin lütfen aktor ismi giriniz.\nCikis icin 0.");
					
					printWriter.println(sendMassege);
					printWriter.flush();

				}
				
				
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Server server = new Server();
		server.serverPro();
	}

}
