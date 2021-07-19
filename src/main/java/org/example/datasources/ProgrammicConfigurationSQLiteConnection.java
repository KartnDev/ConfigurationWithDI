package org.example.datasources;

import lombok.Getter;
import org.example.ApplicationPropertiesPlaceholder;

import javax.sql.DataSource;
import java.util.Objects;

@Getter
public class ProgrammicConfigurationSQLiteConnection {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public ProgrammicConfigurationSQLiteConnection(ApplicationPropertiesPlaceholder propertySourcePlaceholder,
                                                   DataSource dataSource) {
        final var props = propertySourcePlaceholder.getAppliedPropertySources().get("localProperties");
        assert props != null;
        this.login = Objects.requireNonNull(props.getProperty("login")).toString();
        this.password = Objects.requireNonNull(props.getProperty("password")).toString();
        this.dataSource = dataSource;
    }
}
