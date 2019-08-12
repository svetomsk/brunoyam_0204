package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSide {
    private ServerSocket server;
    private AcceptingThread acceptingThread;
    public ServerSide(int port) throws IOException {
        server = new ServerSocket();
        server.setReuseAddress(true);
        server.bind(new InetSocketAddress("localhost", port));
        // start accepting thread
        acceptingThread = new AcceptingThread(server);
        acceptingThread.start();
    }

    public void join() throws InterruptedException {
        acceptingThread.join();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSide server = new ServerSide(12345);
        server.join();
//        Socket connection = server.accept();
//        System.out.println("accepted client");
//        ConsoleOutputThread outputThread = new ConsoleOutputThread(connection);
//        InputThread inputThread = new InputThread(connection);
//
//        outputThread.start();
//        inputThread.start();
//        Scanner sc = new Scanner(connection.getInputStream());
//        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//
//        while(true) {
//            String input = sc.nextLine();
//            System.out.println("Recieved from client: " + input);
//            if (input.equals("exit")) {
//                break;
//            }
//            input = input.toUpperCase() + "\n";
//            out.writeBytes(input);
//        }
//        outputThread.join();
//        inputThread.join();
//        server.close();
//        connection.close();
    }
}
