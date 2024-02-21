package com.models.online.system.download.service.domain.event;

import com.models.online.system.download.service.domain.entity.Download;

import java.time.ZonedDateTime;

public class DownloadPaidEvent extends DownloadEvent {


    public DownloadPaidEvent(Download download, ZonedDateTime createdAt) {
        super(download, createdAt);
    }
}
