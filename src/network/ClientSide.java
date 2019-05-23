package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 1234));

        Scanner sc = new Scanner(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

        writer.writeBytes("Hello world\n");

        String answer = sc.nextLine();
        System.out.println("From server: " + answer);

        socket.close();
    }
}
