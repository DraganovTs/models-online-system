package com.models.online.system.download.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DownloadModel {
    @NotNull
    private final UUID modelId;
    @NotNull
    private final BigDecimal price;
}
