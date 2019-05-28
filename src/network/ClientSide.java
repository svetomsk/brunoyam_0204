package network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 1234));
        System.out.println("Connected to server");
        InputThread input = new InputThread(socket);
        OutputThread output = new OutputThread(socket);

        input.start();
        output.start();

        Thread.sleep(10000);

        input.stopThread();
        output.stopThread();

//        Scanner sc = new Scanner(socket.getInputStream());
//        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
//
//        writer.writeBytes("Hello world\n");
//
//        String answer = sc.nextLine();
//        System.out.println("From server: " + answer);
//
//        socket.close();
    }
}
