package org.example.datasources;

import org.example.programmatic.ProgrammicConfigurationSQLiteConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProgrammicRegistrationTest {
    @Test
    void programmicConfigTest() {
        final var context = new GenericApplicationContext();
        context.registerBean(SQLiteDataSource.class);
        context.registerBean(PropertySourcesPlaceholderConfigurer.class, () -> {
            PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
            configurer.setLocations(new ClassPathResource("connection.properties"));
            return configurer;
        });
        context.refresh();
        context.registerBean(ProgrammicConfigurationSQLiteConnection.class, () -> {
            final var dataSource = context.getBean(DataSource.class);
            final var propertySource = context
                    .getBean(PropertySourcesPlaceholderConfigurer.class)
                    .getAppliedPropertySources()
                    .stream()
                    .filter(propertySourceList -> propertySourceList.getName().equals("localProperties"))
                    .findFirst()
                    .orElseThrow();

            final String login = Optional.ofNullable(propertySource.getProperty("login")).orElseThrow().toString();
            final String password = Optional.ofNullable(propertySource.getProperty("password")).orElseThrow().toString();

            return new ProgrammicConfigurationSQLiteConnection(login, password, dataSource);
        });

        final var bean = context.getBean(ProgrammicConfigurationSQLiteConnection.class);

        assertNotNull(bean.getDataSource());
        assertEquals("app", bean.getLogin());
        assertEquals("pass", bean.getPassword());
    }
}
