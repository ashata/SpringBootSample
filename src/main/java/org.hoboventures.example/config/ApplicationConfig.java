package org.hoboventures.example.config;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Asha on 12/2/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@PropertySource("exampleApp.properties")
@EnableScheduling
@EnableTransactionManagement
@EntityScan("org.hoboventures.example.domain")
@EnableJpaRepositories("org.hoboventures.example.dao")
@ComponentScan({"org.hoboventures.example", "org.hoboventures.example.config", "org.hoboventures.example.dao", "org.hoboventures.example.domain",
        "org.hoboventures.example.service", "org.hoboventures.example.service.impl", "org.hoboventures.example.util", "org.hoboventures.example.web"})
public class ApplicationConfig extends SpringBootServletInitializer {

    public static void main(String[] args){
        System.setProperty("spring.profiles.active", "test");
        configureApplication(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        //, ExampleApplicationConfig.class
        return builder.sources(ApplicationConfig.class, ExampleApplicationConfig.class).bannerMode(Banner.Mode.OFF);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //, ExampleApplicationConfig.class
        setRegisterErrorPageFilter(false);
        return configureApplication(builder);
    }
}
