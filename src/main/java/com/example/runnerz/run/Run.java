package com.example.runnerz.run;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime endedOn,
        @Positive
        Integer miles,
        Location location
//        @Version
//        Integer version
) {
    public Run {
        if (!startedOn.isBefore(endedOn)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
    }
}
