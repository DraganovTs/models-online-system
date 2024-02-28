package com.models.online.system.download.service.messaging.publisher.kafka;

import com.models.online.system.download.service.domain.config.DownloadServiceConfigData;
import com.models.online.system.download.service.domain.event.DownloadCancelledEvent;
import com.models.online.system.download.service.domain.ports.output.messaeg.publisher.payment.DownloadCancelPaymentRequestMessagePublisher;
import com.models.online.system.download.service.messaging.mapper.DownloadMessagingDataMapper;
import com.models.online.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelDownloadKafkaMessagePublisher implements DownloadCancelPaymentRequestMessagePublisher {

    private final DownloadMessagingDataMapper downloadMessagingDataMapper;
    private final DownloadServiceConfigData downloadServiceConfigData;
    private final KafkaProducer<String, PaymentRequestAvroModel> kafkaProducer;
    private final DownloadKafkaMessageHelper downloadKafkaMessageHelper;

    public CancelDownloadKafkaMessagePublisher(DownloadMessagingDataMapper downloadMessagingDataMapper,
                                               DownloadServiceConfigData downloadServiceConfigData,
                                               KafkaProducer<String, PaymentRequestAvroModel> kafkaProducer,
                                               DownloadKafkaMessageHelper downloadKafkaMessageHelper) {
        this.downloadMessagingDataMapper = downloadMessagingDataMapper;
        this.downloadServiceConfigData = downloadServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.downloadKafkaMessageHelper = downloadKafkaMessageHelper;
    }


    @Override
    public void publish(DownloadCancelledEvent domainEvent) {
        String downloadId = domainEvent.getDownload().getId().getValue().toString();
        log.info("Received DownloadCancelledEvent for download id: {}", downloadId);

        try {
            PaymentRequestAvroModel paymentRequestAvroModel = downloadMessagingDataMapper
                    .downloadCancelledEventToPaymentRequestAvroModel(domainEvent);

            kafkaProducer.send(downloadServiceConfigData.getPaymentRequestTopicName(),
                    downloadId,
                    paymentRequestAvroModel,
                    downloadKafkaMessageHelper.getKafkaCallback(downloadServiceConfigData.getPaymentRequestTopicName(),
                            paymentRequestAvroModel,
                            downloadId,
                            "PaymentRequestAvroModel"));

            log.info("PaymentRequestAvroModel sent to Kafka for download id: {}", paymentRequestAvroModel.getDownloadId());
        } catch (Exception e) {
            log.error("Error while sending PaymentRequestAvroModel message" +
                    "to kafka whit download id: {}, error: {}", downloadId, e.getMessage());
        }

    }


}
