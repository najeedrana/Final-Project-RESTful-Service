package com.studentapi.database;

import org.h2.jdbcx.JdbcDataSource;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Creates the H2 data source used by the application. */
public final class Database {
    private Database() { }

    /** Creates a persistent file-backed H2 data source. */
    public static DataSource createFileDataSource() {
        try {
            Files.createDirectories(Path.of("data"));
        } catch (IOException exception) {
            throw new IllegalStateException("Could not create the database folder", exception);
        }
        return createDataSource("jdbc:h2:file:./data/studentdb;DB_CLOSE_ON_EXIT=FALSE");
    }

    /** Creates a data source for the supplied JDBC URL (also used by isolated tests). */
    public static DataSource createDataSource(String jdbcUrl) {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(jdbcUrl);
        dataSource.setUser("sa");
        dataSource.setPassword("");
        return dataSource;
    }
}
