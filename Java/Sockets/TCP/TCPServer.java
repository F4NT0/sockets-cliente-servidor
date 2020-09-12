package Java.Sockets.TCP;

import java.io.*; 
import java.net.*; 
class TCPServer { 
	 public static void main( String argv[]) throws Exception 
	 { 
		 String clientSentence; 
		 String response; 
		 ServerSocket welcomeSocket = new ServerSocket(6789); 
		 boolean start = true;
 
		 System.out.println("Servidor Iniciado!");			 		 
		 Socket connectionSocket = welcomeSocket.accept(); 			
					 
		while (start) { 
			try{
				System.out.println("Iniciado o Processo de Leitura");															
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				System.out.println("Carregado a Informação do Cliente: ");												
				while(true){
					clientSentence = inFromClient.readLine();
					if(!clientSentence.equals("end")){
						System.out.println("Valor Recebido: " + clientSentence);
						response = "[ OK ] | ";
			        	outToClient.writeBytes(response);
					}else{
						if(clientSentence.equals("end")){
							System.out.println("Processo de Leitura Finalizado!");
				            connectionSocket.close();
				            welcomeSocket.close();
				            start = false;
							break;
						}
					}
				}
			}catch(NullPointerException e){
				System.out.println("Processo de Leitura Finalizado!");
				connectionSocket.close();
				welcomeSocket.close();
				start = false;
			}	
		} 
	 } 
}