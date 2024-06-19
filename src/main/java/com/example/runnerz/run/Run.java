package com.example.runnerz.run;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime endedOn,
        @Positive
        Integer miles,
        Location location
) {
    public Run {
        if (!startedOn.isBefore(endedOn)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
    }
}
