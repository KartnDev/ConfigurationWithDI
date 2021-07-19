package org.example.datasources;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;

@Getter
@RequiredArgsConstructor
public class XMLSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;
}
