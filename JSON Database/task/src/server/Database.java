package server;

public class Database {

    String[] array;

    public Database(int size) {
        this.array = new String[size];
    }

    public void setData(int index, String data) {
        this.array[index] = data;
    }


    public String getData(int index) {
        return this.array[index];
    }


    public boolean deleteData(int index) {
        if (index < 0 || index >= this.array.length) {
            return false;
        } else {
            this.array[index] = null;
            return true;
        }
    }
}
