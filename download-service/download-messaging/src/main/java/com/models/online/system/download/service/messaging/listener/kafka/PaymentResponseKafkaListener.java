package com.models.online.system.download.service.messaging.listener.kafka;

import com.models.online.system.download.service.domain.ports.input.message.listener.payment.PaymentResponseMessageListener;
import com.models.online.system.download.service.messaging.mapper.DownloadMessagingDataMapper;
import com.models.online.system.kafka.comsumer.KafkaConsumer;
import com.models.online.system.kafka.download.avro.model.PaymentResponseAvroModel;
import com.models.online.system.kafka.download.avro.model.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PaymentResponseKafkaListener implements KafkaConsumer<PaymentResponseAvroModel> {

    private final PaymentResponseMessageListener paymentResponseMessageListener;
    private final DownloadMessagingDataMapper downloadMessagingDataMapper;

    public PaymentResponseKafkaListener(PaymentResponseMessageListener paymentResponseMessageListener,
                                        DownloadMessagingDataMapper downloadMessagingDataMapper) {
        this.paymentResponseMessageListener = paymentResponseMessageListener;
        this.downloadMessagingDataMapper = downloadMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}", topics = "${download-service.payment-response-topic-name}")
    public void receive(@Payload List<PaymentResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        log.info("{} number of payment responses received whit keys: {}, partitions: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(paymentResponseAvroModel -> {
            if(PaymentStatus.COMPLETED == paymentResponseAvroModel.getPaymentStatus()){
                log.info("Processing successful payment for download id: {}", paymentResponseAvroModel.getDownloadId());
                paymentResponseMessageListener.paymentCompleted(downloadMessagingDataMapper
                        .paymentResponseAvroModelToPaymentResponse(paymentResponseAvroModel));
            }else if (PaymentStatus.CANCELLED == paymentResponseAvroModel.getPaymentStatus()){
                log.info("Processing unsuccessful payment for download id: {}", paymentResponseAvroModel.getDownloadId());
                paymentResponseMessageListener.paymentCancelled(downloadMessagingDataMapper.
                        paymentResponseAvroModelToPaymentResponse(paymentResponseAvroModel));
            }
        });
    }
}
