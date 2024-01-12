package com.service.auth.dao.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
