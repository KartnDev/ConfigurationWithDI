package org.example.datasources;

import lombok.Getter;
import lombok.SneakyThrows;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.Driver;
import java.sql.DriverManager;

@Getter
public class XMLSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    @SneakyThrows
    public XMLSQLiteConnection(String login, String password) {
        this.login = login;
        this.password = password;
        dataSource = new SQLiteDataSource(new SQLiteConfig());
    }
}
