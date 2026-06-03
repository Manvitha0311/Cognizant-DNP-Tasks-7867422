//35-2
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to Server!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String toSend;
        String received;

        while (true) {
            System.out.print("Client: ");
            toSend = keyboard.readLine();
            out.println(toSend);

            if (toSend.equalsIgnoreCase("exit")) {
                break;
            }

            received = in.readLine();
            if (received == null || received.equalsIgnoreCase("exit")) {
                System.out.println("Server disconnected.");
                break;
            }
            System.out.println("Server: " + received);
        }

        socket.close();
    }
}