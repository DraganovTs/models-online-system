package com.models.online.system.download.service.messaging.listener.kafka;

import com.models.online.system.download.service.domain.ports.input.message.listener.categoryapproval.CategoryApprovalResponseMessageListener;
import com.models.online.system.download.service.messaging.mapper.DownloadMessagingDataMapper;
import com.models.online.system.kafka.comsumer.KafkaConsumer;
import com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel;
import com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CategoryApprovalResponseKafkaListener implements KafkaConsumer<CategoryApprovalResponseAvroModel> {

    private final CategoryApprovalResponseMessageListener categoryApprovalResponseMessageListener;
    private final DownloadMessagingDataMapper downloadMessagingDataMapper;

    public CategoryApprovalResponseKafkaListener(CategoryApprovalResponseMessageListener categoryApprovalResponseMessageListener,
                                                 DownloadMessagingDataMapper downloadMessagingDataMapper) {
        this.categoryApprovalResponseMessageListener = categoryApprovalResponseMessageListener;
        this.downloadMessagingDataMapper = downloadMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.category-approval-consumer-group-id}",
            topics = "${download-service.category-approval-response-topic-name}")
    public void receive(@Payload List<CategoryApprovalResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        log.info("{} number of category approval responses received whit keys: {}, partitions: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(categoryApprovalResponseAvroModel -> {
            if (DownloadApprovalStatus.APPROVED == categoryApprovalResponseAvroModel.getDownloadApprovalStatus()) {
                log.info("Processing approved download for download id: {}",
                        categoryApprovalResponseAvroModel.getDownloadId());
                categoryApprovalResponseMessageListener.downloadApproved(
                        downloadMessagingDataMapper.approvalResponseAvroModelToApprovalResponse(categoryApprovalResponseAvroModel));

            } else if (DownloadApprovalStatus.REJECTED == categoryApprovalResponseAvroModel.getDownloadApprovalStatus()) {
                log.info("Processing rejected download for download id: {} , whit failure messages: {}",
                        categoryApprovalResponseAvroModel.getDownloadId(),
                        categoryApprovalResponseAvroModel.getFailureMessages());
                categoryApprovalResponseMessageListener.downloadRejected(downloadMessagingDataMapper
                        .approvalResponseAvroModelToApprovalResponse(categoryApprovalResponseAvroModel));
            }
        });
    }
}
