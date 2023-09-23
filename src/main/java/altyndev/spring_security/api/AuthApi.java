package altyndev.spring_security.api;

import altyndev.spring_security.dto.AuthResponse;
import altyndev.spring_security.dto.AuthenticateRequest;
import altyndev.spring_security.dto.RegisterRequest;
import altyndev.spring_security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthenticateRequest request) {

        return authService.authenticate(request);
    }
}
