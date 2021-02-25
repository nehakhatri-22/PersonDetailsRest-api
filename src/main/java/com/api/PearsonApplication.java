package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(scanBasePackages={
        "com.api.example"})
public class PearsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PearsonApplication.class, args);
    }

}