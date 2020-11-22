package server;


import java.util.Objects;

public class Database {

    private static String[] database;

    static {
        database = new String[100];
    }


    public static void setMethod(int index, String content) {
        database[index] = content;
    }

    public static String getMethod(int index) throws IllegalArgumentException {
        if (checkIfEmpty(index)) {
            throw new IllegalArgumentException();
        }
        return database[index];
    }

    public static void deleteMethod(int index) {
        database[index] = null;
    }


    private static boolean checkIfEmpty(int index) {
        return Objects.equals(database[index], null);
    }


}
