package altyndev.spring_security.dto;

import altyndev.spring_security.enums.Role;

public record AuthResponse(

        String token,
        Role role
) {
}
