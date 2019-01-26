import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
    private static ConnectionManager instance;

    private final Connection connection;

    private ConnectionManager() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:./test");

    }

    public static ConnectionManager getConnection() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void close() throws SQLException {
        connection.close();
    }

    public Connection connection() {
        return connection;
    }
}
