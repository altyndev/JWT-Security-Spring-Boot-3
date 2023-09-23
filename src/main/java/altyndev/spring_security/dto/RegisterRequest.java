package altyndev.spring_security.dto;

import altyndev.spring_security.enums.Role;

public record RegisterRequest(

        String name,
        String username,
        String password,
        Role role
) {
}
