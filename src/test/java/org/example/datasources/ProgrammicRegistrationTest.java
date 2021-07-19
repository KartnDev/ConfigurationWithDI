package org.example.datasources;

import org.example.ApplicationPropertiesPlaceholder;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericApplicationContext;
import org.sqlite.SQLiteDataSource;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProgrammicRegistrationTest {
    @Test
    void programmicConfigTest() {
        final var context = new GenericApplicationContext();
        context.registerBean(ApplicationPropertiesPlaceholder.class);
        context.registerBean("dataSource", SQLiteDataSource.class, (Supplier<SQLiteDataSource>) SQLiteDataSource::new);
        context.registerBean(ProgrammicConfigurationSQLiteConnection.class);
        context.refresh();

        final var bean = context.getBean(ProgrammicConfigurationSQLiteConnection.class);

        assertNotNull(bean.getDataSource());
        assertEquals("app", bean.getLogin());
        assertEquals("pass", bean.getPassword());
    }
}
