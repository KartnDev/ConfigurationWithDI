package org.example.annotation;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Component
@Getter
public class AnnotationConfigurationSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    @SneakyThrows
    public AnnotationConfigurationSQLiteConnection(@Value("${login}") String login,
                                                   @Value("${password}") String password) {
        this.login = login;
        this.password = password;
        dataSource = new SQLiteDataSource(new SQLiteConfig());
    }
}
