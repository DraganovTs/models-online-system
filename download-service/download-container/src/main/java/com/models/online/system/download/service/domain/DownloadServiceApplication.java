package com.models.online.system.download.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories(basePackages = "com.models.online.system.download.service.dataaccess")
@EntityScan(basePackages = "com.models.online.system.download.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.models.online.system")
public class DownloadServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DownloadServiceApplication.class, args);
    }
}
