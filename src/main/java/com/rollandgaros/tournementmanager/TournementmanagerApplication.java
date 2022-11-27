package com.rollandgaros.tournementmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan("com.rollandgaros.tournementmanager")
@EnableJpaRepositories("com.rollandgaros.tournementmanager")
@ComponentScan("com.rollandgaros")

public class TournementmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TournementmanagerApplication.class, args);
    }

}
