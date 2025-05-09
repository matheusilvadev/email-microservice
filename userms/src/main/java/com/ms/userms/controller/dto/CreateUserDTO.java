package com.ms.userms.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
        @NotBlank String name,
        @NotBlank @Email String mail) {
}
