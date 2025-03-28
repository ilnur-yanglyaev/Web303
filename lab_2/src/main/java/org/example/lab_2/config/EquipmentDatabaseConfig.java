package org.example.lab_2.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "datasource.equipment")
public class EquipmentDatabaseConfig extends HikariConfig {
    @Bean
    @FlywayDataSource
    public DataSource equipmentDataSource() {
        return new HikariDataSource(this);
    }
}
