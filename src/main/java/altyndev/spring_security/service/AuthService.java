package altyndev.spring_security.service;

import altyndev.spring_security.dto.AuthResponse;
import altyndev.spring_security.dto.AuthenticateRequest;
import altyndev.spring_security.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthenticateRequest request);
}
