package org.example.annotation;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPropertiesPlaceholder extends PropertySourcesPlaceholderConfigurer {
    public ApplicationPropertiesPlaceholder(){
        setLocation(new ClassPathResource("connection.properties"));
    }
}
