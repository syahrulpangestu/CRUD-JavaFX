package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;
    public Connection getConnection(){
        String dbName ="jadwal_db";
        String userName ="root";
        String password ="";
        String url = "jdbc:mysql://localhost/"+dbName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
