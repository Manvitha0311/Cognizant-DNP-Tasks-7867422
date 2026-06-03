//35-1
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String received;
        String toSend;

        while (true) {
            received = in.readLine();
            if (received == null || received.equalsIgnoreCase("exit")) {
                System.out.println("Client disconnected.");
                break;
            }
            System.out.println("Client: " + received);

            System.out.print("Server: ");
            toSend = keyboard.readLine();
            out.println(toSend);

            if (toSend.equalsIgnoreCase("exit")) {
                break;
            }
        }

        socket.close();
        serverSocket.close();
    }
}