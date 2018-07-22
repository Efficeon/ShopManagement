package dao.jdbc;

import util.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConnectionJdbcDao {
    protected Connection connection;

    private ConnectionProvider connectionProvider = new ConnectionProvider();


    public void init() {
        connection = connectionProvider.getConnection();
    }

    protected PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
                connectionProvider.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}