package Java.Example.TCP;

import java.io.*; 
import java.net.*; 
class TCPServer { 
	 public static void main( String argv[]) throws Exception 
	 { 
		 String clientSentence; 
		 String capitalizedSentence; 
		 ServerSocket welcomeSocket = new ServerSocket(6789); 
		 boolean start = true;
 
		 System.out.println("Servidor Iniciado!");			 		 
		 Socket connectionSocket = welcomeSocket.accept(); 			
					 
		while (start) { 
			try{
				System.out.println("Iniciado o Processo de Leitura");															
				BufferedReader inFromClient = new BufferedReader( 
				new InputStreamReader(connectionSocket.getInputStream()));
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				System.out.println("Carregado a Informação do Cliente: ");												
				clientSentence = inFromClient.readLine();
				System.out.println("Valor Recebido: " + clientSentence); 														
				capitalizedSentence = clientSentence.toUpperCase() + '\n';
				System.out.println("Valor a ser Enviado: " + capitalizedSentence); 
				outToClient.writeBytes(capitalizedSentence); 
				System.out.println("Enviado a Informação: " + capitalizedSentence);
			}catch(NullPointerException e){
				System.out.println("Processo de Leitura Finalizado!");
				start = false;
			}	
		} 
	 } 
}