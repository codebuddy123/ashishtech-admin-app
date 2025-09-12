package com.ashishtech.admin.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * This configuration disables JPA for deployment without a database.
 * To enable JPA, remove this class or set spring.jpa.enabled=true
 */
@Configuration
@ConditionalOnProperty(name = "spring.jpa.enabled", havingValue = "false", matchIfMissing = true)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class DisableJpaConfig {
    // This class disables JPA auto-configuration for deployment without database
}
