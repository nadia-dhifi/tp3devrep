package activité3;


	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;

	public class serveur{
	    public static void main(String[] args) {
	        int port = 1234; // Port sur lequel le serveur écoute
	        
	        try {
	            ServerSocket serverSocket = new ServerSocket(port);
	            System.out.println("Serveur en attente de connexions...");

	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                System.out.println("Nouveau client connecté depuis : " + clientSocket.getRemoteSocketAddress());

	                // Créer un thread pour gérer la communication avec le client
	                Thread clientThread = new client(clientSocket);
	                clientThread.start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


