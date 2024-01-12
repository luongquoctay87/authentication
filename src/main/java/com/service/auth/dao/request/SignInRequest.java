package com.service.auth.dao.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SignInRequest implements Serializable {

    @NotBlank(message = "email must be not blank")
    private String email;

    @NotBlank(message = "password must be not blank")
    private String password;
}
