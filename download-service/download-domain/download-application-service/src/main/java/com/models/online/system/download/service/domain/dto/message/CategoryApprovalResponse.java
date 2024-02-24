package com.models.online.system.download.service.domain.dto.message;

import com.models.online.system.domain.valueobject.DownloadApprovalStatus;

import java.time.Instant;
import java.util.List;

public class CategoryApprovalResponse {
    private String id;
    private String sagaId;
    private String downloadId;
    private String categoryId;
    private Instant createdAt;
    private DownloadApprovalStatus downloadApprovalStatus;
    private List<String> failureMessages;
}
