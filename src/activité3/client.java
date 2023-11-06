package activité3;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.net.Socket;

	public class client extends Thread {
	    private Socket clientSocket;
	    private static int clientCount = 0;

	    public client (Socket clientSocket) {
	        this.clientSocket = clientSocket;
	        clientCount++;
	    }
	    
	    @Override
	    public void run() {
	        try {
	            // Obtenez le flux de sortie pour envoyer des données au client
	            OutputStream outputStream = clientSocket.getOutputStream();

	            // Envoyez l'ordre de communication au client
	            String message = "Vous êtes le client #" + clientCount;
	            outputStream.write(message.getBytes());

	            // Ici, vous pouvez ajouter la logique de communication avec le client

	            // Fermez la connexion avec le client
	            clientSocket.close();
	        } catch (IOException e) {
	            e.printStackTrace();}
	    }}
	        
	    
	



