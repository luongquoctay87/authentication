package com.service.auth.service;

import com.service.auth.dao.request.SignInRequest;
import com.service.auth.dao.request.SignUpRequest;
import com.service.auth.dao.response.TokenResponse;

public interface AuthenticationService {

    TokenResponse signUp(SignUpRequest request);

    TokenResponse signIn(SignInRequest request);
}
