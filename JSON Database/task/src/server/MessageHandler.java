package server;

public class MessageHandler {

    Database database;
    String type;
    int index;
    String content;

    public MessageHandler(Database database) {
        this.database = database;
    }

    public String process(String msg) {
        String[] msgArray = msg.split(" ");
        type = msgArray[0];
        if (type.equals("exit")) {
            return "EXIT";
        }

        if (msgArray.length > 1) {
            try {
                index = Integer.parseInt(msgArray[1]);
            } catch (Exception e) {
                return "ERROR";
            }
        }

        if (index < 1 || index >= database.array.length) {
            return "ERROR";
        } else {
            index--;
        }

        switch (type) {
            case "get":
                return database.getData(index).equals("") ? "ERROR" : database.getData(index);
            case "set":
                database.setData(index, content);
                return "OK";
            case "delete":
                database.deleteData(index);
                return "OK";
            default:
                return "ERROR";
        }
    }

}
