package org.example.javaconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;


@Configuration
public class ConnectionConfiguration {
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        final var configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("connection.properties"));
        return configurer;
    }

    @Bean
    public JavaConfigurationSQLiteConnection javaConfigurationSQLiteConnection(@Value("${login}") String login,
                                                                               @Value("${password}") String password) {
        return new JavaConfigurationSQLiteConnection(login, password, sqLiteDataSource());
    }

    @Bean
    public JavaConfigurationSQLiteConnection javaConfigurationSQLiteConnectionOther(SQLiteDataSource sqLiteDataSource,
                                                                                    @Value("${login}") String login,
                                                                                    @Value("${password}") String password) {
        return new JavaConfigurationSQLiteConnection(login, password, sqLiteDataSource);
    }

    @Bean
    public SQLiteDataSource sqLiteDataSource() {
        return new SQLiteDataSource(new SQLiteConfig());
    }
}
