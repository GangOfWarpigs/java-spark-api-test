package org.example.core.tasks.shared.postgresql;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnector {
    Connection connect() throws SQLException;
}
