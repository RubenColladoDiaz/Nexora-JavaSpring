package com.nexora.api.core.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest (
        @NotBlank @Size(max = 100) String name,
        @NotBlank @Size(min = 8, max = 72) String password
) {}