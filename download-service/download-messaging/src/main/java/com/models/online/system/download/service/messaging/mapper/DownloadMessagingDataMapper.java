package com.models.online.system.download.service.messaging.mapper;

import com.models.online.system.download.service.domain.dto.message.PaymentResponse;
import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.event.DownloadCancelledEvent;
import com.models.online.system.download.service.domain.event.DownloadCreatedEvent;
import com.models.online.system.download.service.domain.event.DownloadPaidEvent;
import com.models.online.system.kafka.download.avro.model.*;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

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

    public CategoryApprovalRequestAvroModel
    downloadPaidEventToCategoryApprovalRequestAvroModel(DownloadPaidEvent downloadPaidEvent) {
        Download download = downloadPaidEvent.getDownload();
        return CategoryApprovalRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setDownloadId(download.getId().getValue().toString())
                .setCategoryId(download.getCategoryId().getValue().toString())
                .setModels(download.getItems().stream().map(downloadItem ->
                                Model.newBuilder()
                                        .setId(downloadItem.getModel().getId().getValue().toString())
                                        .build())
                        .collect(Collectors.toList()))
                .setPrice(download.getPrice().getAmount())
                .setCreatedAt(downloadPaidEvent.getCreatedAt().toInstant())
                .setDownloadApprovalStatus(DownloadApprovalStatus.PAID)
                .build();
    }

    public PaymentResponse paymentResponseAvroModelToPaymentResponse(PaymentResponseAvroModel
                                                                             paymentResponseAvroModel) {
        return PaymentResponse.builder()
                .id(paymentResponseAvroModel.getId())
                .sagaId(paymentResponseAvroModel.getSagaId())
                .paymentId(paymentResponseAvroModel.getPaymentId())
                .customerId(paymentResponseAvroModel.getCustomerId())
                .downloadId(paymentResponseAvroModel.getDownloadId())
                .price(paymentResponseAvroModel.getPrice())
                .createdAt(paymentResponseAvroModel.getCreatedAt())
                .paymentStatus(com.models.online.system.domain.valueobject.PaymentStatus.valueOf(
                        paymentResponseAvroModel.getPaymentStatus().name()))
                .failureMessages(paymentResponseAvroModel.getFailureMessages())
                .build();

    }
}
