package org.example.programmatic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;

@Getter
@RequiredArgsConstructor
public class ProgrammicConfigurationSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;
}
