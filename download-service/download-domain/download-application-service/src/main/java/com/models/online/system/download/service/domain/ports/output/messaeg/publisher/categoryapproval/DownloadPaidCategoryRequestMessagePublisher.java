package com.models.online.system.download.service.domain.ports.output.messaeg.publisher.categoryapproval;

import com.models.online.system.domain.event.publisher.DomainEventPublisher;
import com.models.online.system.download.service.domain.event.DownloadPaidEvent;

public interface DownloadPaidCategoryRequestMessagePublisher extends DomainEventPublisher<DownloadPaidEvent> {
}
