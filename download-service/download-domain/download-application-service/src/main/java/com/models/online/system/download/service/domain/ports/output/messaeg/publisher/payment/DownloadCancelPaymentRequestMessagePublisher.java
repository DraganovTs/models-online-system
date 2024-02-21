package com.models.online.system.download.service.domain.ports.output.messaeg.publisher.payment;

import com.models.online.system.domain.event.publisher.DomainEventPublisher;
import com.models.online.system.download.service.domain.event.DownloadCancelEvent;

public interface DownloadCancelPaymentRequestMessagePublisher extends DomainEventPublisher<DownloadCancelEvent> {
}
