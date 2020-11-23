package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static int PORT = 34500;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                        ) {
                    String message = inputStream.readUTF();
                    outputStream.writeUTF(message);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

