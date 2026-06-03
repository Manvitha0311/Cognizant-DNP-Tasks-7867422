package TCPClientServer;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            String message;

            while (true) {

                System.out.print("Client: ");
                output.println(sc.nextLine());

                message = input.readLine();
                System.out.println("Server: " + message);

                if (message.equalsIgnoreCase("exit"))
                    break;
            }

            socket.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}