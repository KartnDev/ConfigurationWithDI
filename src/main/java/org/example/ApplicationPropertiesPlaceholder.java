package org.example;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component("javaspring_ApplicationPropertiesPlaceholderConfigurer")
public class ApplicationPropertiesPlaceholder extends PropertySourcesPlaceholderConfigurer {
    public ApplicationPropertiesPlaceholder(){
        setLocation(new ClassPathResource("connection.properties"));
    }
}
