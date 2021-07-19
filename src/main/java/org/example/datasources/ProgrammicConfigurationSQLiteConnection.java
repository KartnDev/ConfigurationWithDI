package org.example.datasources;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.ApplicationPropertiesPlaceholder;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Getter
public class ProgrammicConfigurationSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public ProgrammicConfigurationSQLiteConnection(ApplicationPropertiesPlaceholder propertySourcePlaceholder) {
        final var props = propertySourcePlaceholder.getAppliedPropertySources().get("localProperties");
        assert props != null;
        this.login = Objects.requireNonNull(props.getProperty("login")).toString();
        this.password = Objects.requireNonNull(props.getProperty("password")).toString();
        this.dataSource = new SQLiteDataSource(new SQLiteConfig());
    }
}
