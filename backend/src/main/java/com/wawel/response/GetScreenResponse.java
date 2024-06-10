package com.wawel.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class GetScreenResponse {
    private UUID screenId;
    private String screenName;
}
