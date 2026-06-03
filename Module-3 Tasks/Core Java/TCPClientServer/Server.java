package TCPClientServer;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            String message;

            while (true) {

                message = input.readLine();
                System.out.println("Client: " + message);

                if (message.equalsIgnoreCase("exit"))
                    break;

                System.out.print("Server: ");
                output.println(sc.nextLine());
            }

            socket.close();
            serverSocket.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }
}