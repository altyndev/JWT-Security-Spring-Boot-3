package altyndev.spring_security.dto;

public record ExceptionResponse(

        String exceptionClassname,
        String message
) {
}