package org.example.solidprinciples.singletonDesignPattern.ThreadSafePerformant;

public class DBConnection {
    private static DBConnection connObject;
    private DBConnection() {
    }
    public static DBConnection getInstance() {
        if(connObject == null){
            synchronized (DBConnection.class) {
                if(connObject == null)
                {
                    connObject = new DBConnection();
                }
            }
        }
        return connObject;
    }
}

