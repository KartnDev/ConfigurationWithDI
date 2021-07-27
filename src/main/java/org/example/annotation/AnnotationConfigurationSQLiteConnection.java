package org.example.annotation;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Getter
public class AnnotationConfigurationSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public AnnotationConfigurationSQLiteConnection(@Value("${login}") String login,
                                                   @Value("${password}") String password,
                                                   DataSource dataSource) {
        this.login = login;
        this.password = password;
        this.dataSource = dataSource;
    }
}
