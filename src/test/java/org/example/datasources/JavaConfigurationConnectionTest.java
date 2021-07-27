package org.example.datasources;

import org.example.javaconfiguration.JavaConfigurationSQLiteConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JavaConfigurationConnectionTest {

    @Test
    void javaConfigurationSQLiteConnection() {
        final var context = new AnnotationConfigApplicationContext("org.example.javaconfiguration");
        final var connection = context.getBean(JavaConfigurationSQLiteConnection.class);

        assertNotNull(connection.getDataSource());
        assertEquals("app", connection.getLogin());
        assertEquals("pass", connection.getPassword());
    }
}