package altyndev.spring_security.service.impl;

import altyndev.spring_security.config.JwtService;
import altyndev.spring_security.dto.AuthResponse;
import altyndev.spring_security.dto.AuthenticateRequest;
import altyndev.spring_security.dto.RegisterRequest;
import altyndev.spring_security.model.User;
import altyndev.spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements altyndev.spring_security.service.AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponse(token, user.getRole());
    }

    @Override
    public AuthResponse authenticate(AuthenticateRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        User user = userRepository.findByUsername(request.username()).orElseThrow();

        return new AuthResponse(
                jwtService.generateToken(user),
                user.getRole()
        );
    }
}
