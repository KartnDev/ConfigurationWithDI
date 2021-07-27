package org.example.datasources;

import org.example.programmatic.ProgrammicConfigurationSQLiteConnection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProgrammicRegistrationTest {
    @Test
    void programmicConfigTest() {
        final var context = new GenericApplicationContext();
        context.registerBean(SQLiteDataSource.class);
        context.registerBean(PropertySourcesPlaceholderConfigurer.class, () -> {
            final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
            configurer.setLocations(new ClassPathResource("connection.properties"));
            return configurer;
        });
        context.registerBean(ProgrammicConfigurationSQLiteConnection.class,
                "${login}", "${password}", new RuntimeBeanReference(DataSource.class));
        context.refresh();

        final var bean = context.getBean(ProgrammicConfigurationSQLiteConnection.class);

        assertNotNull(bean.getDataSource());
        assertEquals("app", bean.getLogin());
        assertEquals("pass", bean.getPassword());
    }
}
