package org.example.datasources;

import org.example.xml.XMLSQLiteConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class XMLSQLiteConnectionTest {
    @Test
    void xmlConfigTest() {
        final var context = new ClassPathXmlApplicationContext("beans.xml");
        final var bean = context.getBean(XMLSQLiteConnection.class);

        assertNotNull(bean.getDataSource());
        assertEquals("app", bean.getLogin());
        assertEquals("pass", bean.getPassword());
    }
}