package org.example.datasources;

import org.example.ApplicationPropertiesPlaceholder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProgrammicRegistrationTest {
    @Test
    void xmlConfigTest() {
        final var context = new GenericApplicationContext();
        context.registerBean(ApplicationPropertiesPlaceholder.class);
        context.registerBean(ProgrammicConfigurationSQLiteConnection.class);
        context.refresh();

        final var bean = context.getBean(ProgrammicConfigurationSQLiteConnection.class);

        assertNotNull(bean.getDataSource());
        assertEquals("app", bean.getLogin());
        assertEquals("pass", bean.getPassword());
    }
}
