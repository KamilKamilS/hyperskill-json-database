package server;

import server.Database;
import server.DatabaseDao;

public class ClientInterface {

    private static DatabaseDao databaseDao;

    static {
        databaseDao = new DatabaseDao();
    }

    public static String getMethodFromInput(String input) {
        String[] inputArray = input.split(" ", 3);
        String method = inputArray[0];
        int index = Integer.valueOf(inputArray[1]) - 1;
        switch (method) {
            case "get":
                return databaseDao.getMethod(index);
            case "set":

                return databaseDao.setMethod(index, inputArray[2]);
            case "delete":
                return databaseDao.deleteMethod(index);
            default:
                return "ERROR";
        }
    }

}
