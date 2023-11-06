package activite32;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(12345); // Port d'écoute du serveur

            System.out.println("Serveur en attente de connexions...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion : " + clientSocket.getInetAddress());

                // Créez un thread pour gérer la communication avec le client
                CalculatorThread clientThread = new CalculatorThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class CalculatorThread extends Thread {
    private Socket clientSocket;

    public CalculatorThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {
                // Attendre l'objet d'opération du client
                Object obj = in.readObject();

                if (obj instanceof Operation) {
                    Operation operation = (Operation) obj;

                    // Effectuer le calcul
                    double result = operation.calculate();

                    // Envoyer le résultat au client
                    out.writeObject(result);
                } else {
                    // Gérer l'erreur si l'objet reçu n'est pas de type Operation
                    System.err.println("Objet inattendu reçu du client.");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
