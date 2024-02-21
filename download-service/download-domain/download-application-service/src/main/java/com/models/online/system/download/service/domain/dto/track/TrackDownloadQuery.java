package com.models.online.system.download.service.domain.dto.track;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackDownloadQuery {
    @NotNull
    private final UUID downloadTrackingId;
}
