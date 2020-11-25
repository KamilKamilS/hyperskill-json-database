package client;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.sun.source.tree.Scope;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    private static Message msg = new Message();

    public static void main(String[] args) {

        String address = "127.0.0.1";
        int port = 23456;
        String answer;


        JCommander.newBuilder()
                .addObject(msg)
                .build()
                .parse(args);


        try (
                Socket clientSocket = new Socket(InetAddress.getByName(address), port);
                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())
        ) {
            System.out.println("Client started!");

            // Sending a request to the server
            final String message = String.format("%s %s %s", msg.getType(), msg.getIndex(), msg.getContent());

            System.out.println("Sent: " + message.trim());
            output.writeUTF(message);

            // Getting answer from server
            String receivedMessage = input.readUTF();
            System.out.println("Received: " + receivedMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        closeSocket();
    }



//    private static void closeSocket() {
//        try {
//            clientSocket.close();
//        } catch (Exception ignored) {
//        }
//    }


    /**
     * Creating a socket to connect to the server
     */
//    private static void createSocket() {
//        final String address = "127.0.0.1";
//        final int port = 23456;
//        while (true) {
//            try {
//                clientSocket = new Socket(InetAddress.getByName(address), port);
//                return;
//            } catch (Exception e) {
//                System.out.println("\n" + e + "\n[CLIENT] Can't connect to the server");
//            }
//
//        }
//    }
}
