package client;

import server.ClientInterface;
import server.DatabaseDao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(InetAddress.getByName(SERVER_ADDRESS), SERVER_PORT);
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                ) {

            System.out.println("Client started!");
            String message = "Give me a record # 12";

            outputStream.writeUTF(message);
            System.out.println("Sent: " + message);
            String recievedMessage = inputStream.readUTF();

            System.out.println("Received: " + recievedMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
