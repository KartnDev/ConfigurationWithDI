package org.example.datasources;

import org.example.javaconfiguration.JavaConfigurationSQLiteConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class JavaConfigurationConnectionTest {

    @Test
    void javaConfigurationSQLiteConnection() {
        final var context = new AnnotationConfigApplicationContext("org.example.javaconfiguration");
        final var javaConfigurationSQLiteConnection
                = context.getBean("javaConfigurationSQLiteConnection", JavaConfigurationSQLiteConnection.class);
        final var javaConfigurationSQLiteConnectionOther
                = context.getBean("javaConfigurationSQLiteConnectionOther", JavaConfigurationSQLiteConnection.class);

        assertNotNull(javaConfigurationSQLiteConnection.getDataSource());
        assertEquals("app", javaConfigurationSQLiteConnection.getLogin());
        assertEquals("pass", javaConfigurationSQLiteConnection.getPassword());

        assertNotNull(javaConfigurationSQLiteConnectionOther.getDataSource());
        assertEquals("app", javaConfigurationSQLiteConnectionOther.getLogin());
        assertEquals("pass", javaConfigurationSQLiteConnectionOther.getPassword());

        assertNotEquals(javaConfigurationSQLiteConnectionOther, javaConfigurationSQLiteConnection);
    }
}