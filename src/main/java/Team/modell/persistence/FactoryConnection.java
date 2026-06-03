package Team.modell.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FactoryConnection {
    private static Connection connection;

    FactoryConnection() {}

    public static Connection getConnection() throws SQLException {
        if(connection == null)
            connection = DriverManager.getConnection("jdbc:sqlite:team.db");
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

}
