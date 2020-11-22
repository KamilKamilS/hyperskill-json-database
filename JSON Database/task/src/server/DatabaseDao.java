package server;

public class DatabaseDao {

    public String setMethod(int index, String content) {
        if (validIndex(index)) {
            Database.setMethod(index, content);
            return "OK";
        }
        return "ERROR";
    }

    public String getMethod(int index, String content) {
        if (validIndex(index)) {
            try {
                Database.getMethod(index);
                return "OK";
            }catch (Exception e) {
                return "ERROR";
            }
        }
        return "ERROR";
    }

    public String deleteMethod(int index) {
        if (validIndex(index)) {
            Database.deleteMethod(index);
            return "OK";
        }
        return "ERROR";
    }

    private boolean validIndex(int index) {
        if (index >= 1 || index <= 100) {
            return true;
        }
        return false;
    }

}
