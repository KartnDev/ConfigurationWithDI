package org.example.datasources;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnnotationConfigurationSQLiteConnectionTest {

    @Test
    void annotationConfigurationConnectionTest() {
        final var context = new AnnotationConfigApplicationContext("org.example");
        final var bean = context.getBean(AnnotationConfigurationSQLiteConnection.class);

        assertNotNull(bean.getDataSource());
        assertEquals("app", bean.getLogin());
        assertEquals("pass", bean.getPassword());
    }
}