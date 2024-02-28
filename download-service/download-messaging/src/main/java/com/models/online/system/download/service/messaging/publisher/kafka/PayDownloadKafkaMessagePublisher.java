package com.models.online.system.download.service.messaging.publisher.kafka;

import com.models.online.system.download.service.domain.config.DownloadServiceConfigData;
import com.models.online.system.download.service.domain.event.DownloadPaidEvent;
import com.models.online.system.download.service.domain.ports.output.messaeg.publisher.categoryapproval.DownloadPaidCategoryRequestMessagePublisher;
import com.models.online.system.download.service.messaging.mapper.DownloadMessagingDataMapper;
import com.models.online.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PayDownloadKafkaMessagePublisher implements DownloadPaidCategoryRequestMessagePublisher {

    private final DownloadMessagingDataMapper downloadMessagingDataMapper;
    private final DownloadServiceConfigData downloadServiceConfigData;
    private final KafkaProducer<String, CategoryApprovalRequestAvroModel> kafkaProducer;
    private final DownloadKafkaMessageHelper downloadKafkaMessageHelper;

    public PayDownloadKafkaMessagePublisher(DownloadMessagingDataMapper downloadMessagingDataMapper,
                                            DownloadServiceConfigData downloadServiceConfigData,
                                            KafkaProducer<String, CategoryApprovalRequestAvroModel> kafkaProducer,
                                            DownloadKafkaMessageHelper downloadKafkaMessageHelper) {
        this.downloadMessagingDataMapper = downloadMessagingDataMapper;
        this.downloadServiceConfigData = downloadServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.downloadKafkaMessageHelper = downloadKafkaMessageHelper;
    }

    @Override
    public void publish(DownloadPaidEvent domainEvent) {
        String downloadId = domainEvent.getDownload().getId().getValue().toString();

        try {
            CategoryApprovalRequestAvroModel categoryApprovalRequestAvroModel =
                    downloadMessagingDataMapper.downloadPaidEventToCategoryApprovalRequestAvroModel(domainEvent);
            kafkaProducer.send(downloadServiceConfigData.getCategoryApprovalRequestTopicName(),
                    downloadId,
                    categoryApprovalRequestAvroModel,
                    downloadKafkaMessageHelper
                            .getKafkaCallback(downloadServiceConfigData.getPaymentResponseTopicName(),
                                    categoryApprovalRequestAvroModel,
                                    downloadId,
                                    "CategoryApprovalRequestAvroModel")
            );
            log.info("CategoryApprovalRequestAvroModel sent to kafka for download id: {}", downloadId);
        } catch (Exception e) {
            log.error("Error while sending CategoryApprovalRequestAvroModel message" +
                    "to kafka for download id: {}, error: {}", downloadId, e.getMessage());
        }
    }
}
