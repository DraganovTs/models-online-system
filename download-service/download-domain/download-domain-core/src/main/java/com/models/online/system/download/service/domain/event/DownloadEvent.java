package com.models.online.system.download.service.domain.event;

import com.models.online.system.domain.event.DomainEvent;
import com.models.online.system.download.service.domain.entity.Download;

import java.time.ZonedDateTime;

public abstract class DownloadEvent implements DomainEvent<Download> {

    private final Download download;
    private final ZonedDateTime createdAt;

    public DownloadEvent(Download download, ZonedDateTime createdAt) {
        this.download = download;
        this.createdAt = createdAt;
    }

    public Download getDownload() {
        return download;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
