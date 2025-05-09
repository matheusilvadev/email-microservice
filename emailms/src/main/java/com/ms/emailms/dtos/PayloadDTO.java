package com.ms.emailms.dtos;

import java.util.UUID;

public record PayloadDTO(UUID userId,
                         String emailTo,
                         String subject,
                         String text) {
}
