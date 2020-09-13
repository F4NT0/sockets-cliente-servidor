package Java.Sockets.TCP;

import java.io.*;
import java.net.*;
 
public class TCPClient {
 
	public static void main(String argv[]) throws Exception {
		// String sentence;
		String modifiedSentence;
 
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
 
		int porta = 6789;
		String servidor = "localhost";
 
		System.out.println("Conectando ao servidor " + servidor + ":" + porta);
 
		Socket clientSocket = new Socket(servidor, porta);
 
		// Envio de dados para o Servidor
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
 
		// Recebimento de Resposta do Servidor
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 
	    // Enviando Dados do Arquivo para o Servidor
		// System.out.println("Digite string a ser enviada para o servidor");
		// sentence = inFromUser.readLine();

		// -------- TESTE ---------------

		System.out.println("Digite o nome do Arquivo que deseja enviar [teste-pequeno | teste-grande]");
		String nameFile = inFromUser.readLine();
		String file = "Arquivos-de-teste/" + nameFile + ".txt"; 
		BufferedReader readFile = new BufferedReader(new FileReader(file));

		String sentence;
		while(true){
			sentence = readFile.readLine();
			if(sentence == null){
				break;
			}
			System.out.println("Dado sendo Enviado: " + sentence);
			outToServer.writeBytes(sentence + '\n');
			
		}
		readFile.close();
 
		// outToServer.writeBytes(sentence + '\n');
 
		modifiedSentence = inFromServer.readLine();
 
		System.out.println("Recebido do servidor: " + modifiedSentence);
 
		clientSocket.close();
 
	}
}