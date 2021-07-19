package org.example.datasources;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Getter
@RequiredArgsConstructor
public class JavaConfigurationSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;
}
