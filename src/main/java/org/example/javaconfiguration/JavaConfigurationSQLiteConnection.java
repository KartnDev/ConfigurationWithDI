package org.example.javaconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;

@Getter
@RequiredArgsConstructor
public class JavaConfigurationSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;
}
