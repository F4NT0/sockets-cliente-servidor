package Java.Sockets.UDP;

import java.io.*;
import java.net.*;
 
public class UDPClient {
	public static void main(String args[]) throws Exception {
 
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
 
		DatagramSocket clientSocket = new DatagramSocket();
 
		String servidor = "localhost";
		int porta = 9876;
 
		InetAddress IPAddress = InetAddress.getByName(servidor);
 
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
 
		// System.out.println("Digite o texto a ser enviado ao servidor: ");
		// String sentence = inFromUser.readLine();
		// sendData = sentence.getBytes();
		// DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, porta);

		System.out.println("Digite o nome do Arquivo que deseja enviar [teste-pequeno | teste-grande]");
		String nameFile = inFromUser.readLine();
		String file = "Arquivos-de-teste/" + nameFile + ".txt";
		BufferedReader readFile = new BufferedReader(new FileReader(file));
		// Basico caso não tenha dados
		String sentence = "Arquivo Não Lido";
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, porta);
		while(true){
			sentence = readFile.readLine();
			sendData = sentence.getBytes();
			if(sentence.equals("end")){
				break;
			}
		    sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, porta);
		}
		readFile.close();
		System.out.println("Enviando pacote UDP para " + servidor + ":" + porta);
		clientSocket.send(sendPacket);	
 
		DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
 
		clientSocket.receive(receivePacket);
		System.out.println("Pacote UDP recebido...");
 
		String modifiedSentence = new String(receivePacket.getData());
 
		System.out.println("Texto recebido do servidor:" + modifiedSentence);
		clientSocket.close();
		System.out.println("Socket cliente fechado!");
	}
}