package com.models.online.system.download.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public DownloadDomainService downloadDomainService(){
        return new DownloadDomainServiceImpl();
    }
}
