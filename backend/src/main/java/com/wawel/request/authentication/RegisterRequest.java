package com.wawel.request.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
