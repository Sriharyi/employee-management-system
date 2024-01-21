package com.sriharyi.ems.authentication.service;

import com.sriharyi.ems.authentication.dto.AuthenticateRequest;
import com.sriharyi.ems.authentication.dto.AuthenticateResponse;
import com.sriharyi.ems.authentication.dto.RegisterRequest;

public interface AuthenticationService {

    public AuthenticateResponse register(RegisterRequest request);

    public AuthenticateResponse authenticate(AuthenticateRequest request);

}