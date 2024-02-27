package com.models.online.system.download.service.domain;

import com.models.online.system.download.service.domain.entity.Category;
import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.event.DownloadCancelledEvent;
import com.models.online.system.download.service.domain.event.DownloadCreatedEvent;
import com.models.online.system.download.service.domain.event.DownloadPaidEvent;

import java.util.List;

public interface DownloadDomainService {

    DownloadCreatedEvent validateAndInitiateDownload(Download download, Category category);

    DownloadPaidEvent payDownload(Download download);

    void approveDownload(Download download);

    DownloadCancelledEvent cancelDownloadPayment(Download download, List<String> failureMessages);

    void cancelDownload(Download download, List<String> failureMessages);
}
