package com.models.online.system.download.service.domain.dto.message;

import com.models.online.system.domain.valueobject.DownloadApprovelStatus;

import java.time.Instant;
import java.util.List;

public class CategoryApproveResponse {
    private String id;
    private String sagaId;
    private String downloadId;
    private String categoryId;
    private Instant createdAt;
    private DownloadApprovelStatus downloadApprovelStatus;
    private List<String> failureMessages;
}
