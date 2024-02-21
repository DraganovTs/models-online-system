package com.models.online.system.download.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateDownloadCommand {
    @NotNull
    private final UUID customerId;
    @NotNull
    private final UUID categoryId;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final List<DownloadModel> items;
    @NotNull
    private final UserAddressInfo downloadAddress;
}
