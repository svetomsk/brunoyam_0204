package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSide {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        server.setReuseAddress(true);

        System.out.println("Server is ready to accept connection");
        Socket connection = server.accept();
        Scanner sc = new Scanner(connection.getInputStream());
        DataOutputStream writer = new DataOutputStream(connection.getOutputStream());

        String question = sc.nextLine();
        System.out.println("From client = " + question);
        writer.writeBytes(question.toUpperCase() + "\n");
        connection.close();
        server.close();
    }
}
