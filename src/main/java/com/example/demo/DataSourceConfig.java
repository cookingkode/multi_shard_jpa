package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

/**
 * Created by jpairaiturkar on 5/17/17.
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private ShardProperties shardProperties;

    @Bean(name = { "dataSource", "dataSource1" })
    @ConfigurationProperties(prefix = "spring.shard.datasource1")
    public DataSource dataSource1() {
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.shardProperties.getDatasource1().getClassLoader())
                .driverClassName(this.shardProperties.getDatasource1().getDriverClassName())
                .username(this.shardProperties.getDatasource1().getUsername())
                .password(this.shardProperties.getDatasource1().getPassword())
                .url(this.shardProperties.getDatasource1().getUrl());
        return factory.build();
    }

    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.shard.datasource2")
    public DataSource dataSource2() {
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.shardProperties.getDatasource2().getClassLoader())
                .driverClassName(this.shardProperties.getDatasource2().getDriverClassName())
                .username(this.shardProperties.getDatasource2().getUsername())
                .password(this.shardProperties.getDatasource2().getPassword())
                .url(this.shardProperties.getDatasource2().getUrl());
        return factory.build();
    }


}
