import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;
        String clientMessage = "Hello My name is John"; // Change the name as needed

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(clientMessage);
            System.out.println("Sent to server: " + clientMessage);

            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
