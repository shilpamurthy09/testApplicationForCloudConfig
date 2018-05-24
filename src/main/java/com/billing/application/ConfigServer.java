package com.billing.application;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;

/**
 * Created by shilpa on 5/24/18.
 */

@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,PersistenceExceptionTranslationAutoConfiguration.class})
public class ConfigServer {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ConfigServer.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
