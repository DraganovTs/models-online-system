package com.models.online.system.download.service.domain.dto.create;

import com.models.online.system.domain.valueobject.DownloadStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateDownloadResponse {
    @NotNull
    private final UUID downloadTrackingId;
    @NotNull
    private final DownloadStatus downloadStatus;
    @NotNull
    private final String message;
}
