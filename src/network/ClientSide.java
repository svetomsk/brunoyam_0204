package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    private Socket connection;
    private ConsoleOutputThread outputThread;
    private InputThread inputThread;
    private InetSocketAddress address;

    public ClientSide(String host, int port) throws IOException {
        connection = new Socket();
        address = new InetSocketAddress(host, port);
    }

    public void connect() throws IOException {
        connection.connect(address);
        System.out.println("Connected to server");
        outputThread = new ConsoleOutputThread(connection);
        inputThread = new InputThread(connection);
        outputThread.start();
        inputThread.start();
    }

    public void join() throws InterruptedException, IOException {
        outputThread.join();
        inputThread.join();
        connection.close();
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        ClientSide client = new ClientSide("localhost", 12345);
        client.connect();
        client.join();
//        Scanner sc = new Scanner(connection.getInputStream());
//        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//        Scanner input = new Scanner(System.in);
//        while(true) {
//            String message = input.nextLine() + "\n";
//            out.writeBytes(message);
//            if(message.equals("exit\n")) {
//                break;
//            }
//
//            String answer = sc.nextLine();
//            System.out.println("From server: " + answer);
//        }

//        outputThread.join();
//        inputThread.join();
//        connection.close();
    }
}
