package altyndev.spring_security.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/greeting")
public class GreetingApi {

    @GetMapping("/public")
    @PreAuthorize("hasAuthority('USER')")
    public String hello() {

        return "PUBLIC";
    }

    @GetMapping("/protected")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String protectedHello() {

        return "PROTECTED";
    }
}
