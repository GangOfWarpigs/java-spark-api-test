package org.example.core.tasks.shared.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlDbConnector implements DbConnector {
   private final String url;
   private final String user;
   private final String password;

    public PostgresqlDbConnector(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public Connection connect() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }
}
