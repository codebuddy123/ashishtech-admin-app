package com.ashishtech.admin.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * This configuration class is used to disable JPA when deploying without a database.
 * To use it, set spring.profiles.active=no-db or set spring.jpa.enabled=false
 */
@Configuration
@ConditionalOnProperty(name = "spring.jpa.enabled", havingValue = "false", matchIfMissing = false)
@org.springframework.boot.autoconfigure.EnableAutoConfiguration(
    exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}
)
public class ConditionalJpaConfig {
    // Empty class, just used for configuration
}
