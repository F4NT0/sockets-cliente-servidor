package Java.Sockets.TCP;

import java.io.*; 
import java.net.*; 
public class TCPServer { 
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
				while(true){
					clientSentence = inFromClient.readLine();
					if(!clientSentence.equals("end")){
						System.out.println("[ VALOR RECEBIDO ] : " + clientSentence);
					}else{
						if(clientSentence.equals("end")){
							
							response = "[ OK ] Leitura Realizado com Sucesso";
							outToClient.writeBytes(response);
							
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