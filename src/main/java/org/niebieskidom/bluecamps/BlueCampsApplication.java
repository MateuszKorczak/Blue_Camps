package org.niebieskidom.bluecamps;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ComponentScan("org.niebieskidom")
public class BlueCampsApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BlueCampsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BlueCampsApplication.class, args);
    }

}
