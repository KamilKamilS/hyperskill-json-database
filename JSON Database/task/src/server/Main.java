package server;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        String input = "";

        while(run) {
            input = scanner.nextLine();

            if (input.equals("exit")) {
                run = false;
                break;
            }
            System.out.println(ClientInterface.getMethodFromInput(input));


        }

    }
}

