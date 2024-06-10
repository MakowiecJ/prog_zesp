package com.wawel.request;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
public class EditScreeningRequest {
    private UUID screenId;
    private OffsetDateTime startDate;
}
