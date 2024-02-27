package com.models.online.system.download.service.messaging.mapper;

import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.event.DownloadCancelledEvent;
import com.models.online.system.download.service.domain.event.DownloadCreatedEvent;
import com.models.online.system.kafka.download.avro.model.PaymentDownloadStatus;
import com.models.online.system.kafka.download.avro.model.PaymentRequestAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DownloadMessagingDataMapper {

    public PaymentRequestAvroModel downloadCreatedEventToPaymentRequestAvroModel(DownloadCreatedEvent downloadCreatedEvent) {
        Download download = downloadCreatedEvent.getDownload();
        return PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setCustomerId(download.getId().getValue().toString())
                .setDownloadId(download.getId().getValue().toString())
                .setPrice(download.getPrice().getAmount())
                .setCreatedAt(downloadCreatedEvent.getCreatedAt().toInstant())
                .setPaymentDownloadStatus(PaymentDownloadStatus.PENDING)
                .build();
    }

    public PaymentRequestAvroModel downloadCancelledEventToPaymentRequestAvroModel(DownloadCancelledEvent downloadCancelledEvent) {
        Download download = downloadCancelledEvent.getDownload();
        return PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setCustomerId(download.getId().getValue().toString())
                .setDownloadId(download.getId().getValue().toString())
                .setPrice(download.getPrice().getAmount())
                .setCreatedAt(downloadCancelledEvent.getCreatedAt().toInstant())
                .setPaymentDownloadStatus(PaymentDownloadStatus.CANCELLED)
                .build();
    }
}
