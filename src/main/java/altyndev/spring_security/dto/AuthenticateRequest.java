package altyndev.spring_security.dto;

public record AuthenticateRequest(

        String username,
        String password
) {
}
