package com.models.online.system.download.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "download-service")
public class DownloadServiceConfigData {
    private String paymentRequestTopicName;
    private String paymentResponseTopicName;
    private String categoryApprovalResponseTopicName;
    private String categoryApprovalRequestTopicName;
}
