import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        int port = 1234;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = in.readLine();
                if (clientMessage != null) {
                    System.out.println("Client sent: " + clientMessage);

                    // Check if the message starts with "Hello My name is"
                    if (clientMessage.startsWith("Hello My name is")) {
                        String name = clientMessage.substring(18);
                        String response = "Walikum Salam " + name;
                        out.println(response);
                    } else {
                        out.println("Unknown message");
                    }
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
