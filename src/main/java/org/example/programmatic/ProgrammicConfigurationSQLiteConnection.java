package org.example.programmatic;

import lombok.Getter;

import javax.sql.DataSource;

@Getter
public class ProgrammicConfigurationSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public ProgrammicConfigurationSQLiteConnection(String login, String password, DataSource dataSource) {
        this.login = login;
        this.password = password;
        this.dataSource = dataSource;
    }
}
