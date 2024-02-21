package com.models.online.system.download.service.domain.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserAddressInfo {
    @NotNull
    @Email
    private final String email;
    @NotNull
    @Max(value = 15)
    private final String country;
    @NotNull
    @Max(value = 15)
    private final String city;
}
