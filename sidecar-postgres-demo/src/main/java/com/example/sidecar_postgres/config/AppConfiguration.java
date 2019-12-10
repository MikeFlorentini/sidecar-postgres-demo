/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sidecar_postgres.config;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author mike
 */
@Configuration
@EnableConfigurationProperties({DataSourceProperties.class})
public class AppConfiguration {
     
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);
    
    @Autowired
    private DataSourceProperties dsProperties;
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @Value("${sidecar.appName:POSTGRES-DB_REPLICATION}")
    private String dbServiceName;
    
    @Bean
    public DataSource dataSource() {
        LOGGER.info("Attempting to retrieve service metadata for '{}'", this.dbServiceName);
        ServiceInstance instance = this.discoveryClient.getInstances(this.dbServiceName).iterator().next();
        LOGGER.info("Found instance [host = {}, port = {}, serviceId = {}]", instance.getHost(), instance.getPort(), instance.getServiceId());
        return this.createDataSource(instance.getHost(), instance.getPort());
    }
    
    private DataSource createDataSource(String host, int port) {
        String jdbcUrl = String.format(this.dsProperties.getUrl(), host, port);
        LOGGER.info("Attempting connection using jdbc url '{}'", jdbcUrl);

        DataSourceBuilder factory = DataSourceBuilder
                .create()
                .url(jdbcUrl)
                .username(this.dsProperties.getUsername())
                .password(this.dsProperties.getPassword())
                .driverClassName(this.dsProperties.getDriverClassName());
        return factory.build();
    }

}
