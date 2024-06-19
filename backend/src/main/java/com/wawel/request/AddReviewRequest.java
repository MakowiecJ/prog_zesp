package com.wawel.request;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AddReviewRequest {
    private Long userId;
    private Long movieId;
    private Integer rating;
    private String reviewText;
}
