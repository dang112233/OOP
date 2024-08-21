package oop.lab10.singleton.pseudocode;

public class Database {
    private static Database instance;

    private Database() {
        // Some initialization code, such as the actual
        // connection to a database server.
        // ...
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public void query(String sql) {
        // For instance, all database queries of an app go
        // through this method. Therefore, you can place
        // throttling or caching logic here.
        // ...
    }
}
