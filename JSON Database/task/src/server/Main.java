package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Main {
//    static String[] database = new String[1000];
    static Database database;

    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 23456;
        String message;
        database = new Database(1000);
        MessageHandler msgHandler = new MessageHandler(database);


        try (
                ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address))
        )
        {
            System.out.println("Server started!");
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream()))
                {
                    message = input.readUTF();
//                    System.out.println("Received: " + query);

                    String result = process(message);
                    if (result.equals("EXIT")) {
                        output.writeUTF("OK");
                        System.exit(0);
                    }
//                    System.out.println("Sent: " + result);
                    output.writeUTF(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String process(String query) {
        String result;
        String[] queryParts = query.split("\\s+");
        int index;

        String command = queryParts[0];
        if (command.equals("exit")) {
            return "EXIT";
        }

        try {
            index = Integer.parseInt(queryParts[1]);
        } catch (Exception e)
        {
            return "ERROR";
        }

        if (index < 1 || index > database.array.length) { // Prevent OOB
            return "ERROR";
        } else {
            index--; // Zero-base the index.
        }

        switch (command) {
            case "set":
                database.array[index] = String.join(" ", Arrays.copyOfRange(queryParts, 2, queryParts.length));
                result = "OK";
                break;
            case "get":
                result = database.array[index].equals("") ? "ERROR" : database.array[index];
                break;
            case "delete":
                database.array[index] = "";
                result = "OK";
                break;
            default:
                result = "ERROR";
        }

        return result;
    }
}