package ru.dz.lessons.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by blvp on 13.03.15.
 */
@Configuration
@ComponentScan(basePackages = {
        "ru.dz.lessons.service"
})
public class CoreConfig {
}
