package activite32;
import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("adresse_ip_du_serveur", 12345); // Adresse IP du serveur et port

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Créez un objet d'opération et envoyez-le au serveur
            Operation operation = new Operation(5, 45, '+'); // Utilisation de '+' comme opérateur
            out.writeObject(operation);

            // Attendre la réponse du serveur
            double result = (Double) in.readObject();

            System.out.println("Résultat : " + result);

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
