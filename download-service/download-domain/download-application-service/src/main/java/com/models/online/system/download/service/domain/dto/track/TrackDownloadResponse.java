package com.models.online.system.download.service.domain.dto.track;

import com.models.online.system.domain.valueobject.DownloadStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackDownloadResponse {
    @NotNull
    private final UUID downloadTrackingId;
    @NotNull
    private final DownloadStatus downloadStatus;
    private final List<String> failureMessages;
}
