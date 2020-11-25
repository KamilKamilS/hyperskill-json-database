package server;

public class Database {

    String[] array;

    public Database(int size) {
        this.array = new String[size];
    }

    public boolean setData(int index, String data) {
        if (index >= this.array.length) {
            return false;
        } else {
            this.array[index] = data;
            return true;
        }
    }


    public String getData(int index) {
        System.out.println("got index:" + index);
        if (index < 0 || index >= this.array.length) {
            return "";
        } else {
            return this.array[index];
        }
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
