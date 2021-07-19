package org.example.datasources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class XMLSQLiteConnectionTest {

    @Test
    void xmlConfigTest() {
        final var context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("beans.xml");
        context.refresh();

        final var bean = context.getBean("xmlsqLiteConnection", XMLSQLiteConnection.class);

        assertNotNull(bean.getDataSource());
        assertEquals("app", bean.getLogin());
        assertEquals("pass", bean.getPassword());
    }
}