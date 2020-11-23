package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static int PORT = 34522;
    private static String address = "127.0.0.1";

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT,50, InetAddress.getByName(address))) {
            System.out.println("Server started!");
                try (
                        Socket socket = server.accept();
                        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                        ) {
                    String message = inputStream.readUTF();
                    System.out.println("Recieved: " + message);
                    String [] messageArray = message.split(" ");
                    String outputMessage = "A record # 12 was sent!";

                    outputStream.writeUTF(outputMessage);
                    System.out.print("Sent: " + outputMessage);
                }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

