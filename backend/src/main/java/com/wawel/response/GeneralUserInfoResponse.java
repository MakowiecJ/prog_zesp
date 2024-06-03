package com.wawel.response;

import com.wawel.entity.auth.Role;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GeneralUserInfoResponse {
    private Long userId;
    private String username;
    private String email;
    private String token;
    private Set<Role> roles;
}
