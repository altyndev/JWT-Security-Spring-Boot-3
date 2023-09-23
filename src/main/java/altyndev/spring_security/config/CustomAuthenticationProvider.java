package altyndev.spring_security.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            UserDetailsService userDetailsService = getUserDetailsService();
            UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
        } catch (UsernameNotFoundException notFound) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        try {
            return super.authenticate(authentication);
        } catch (BadCredentialsException badCredentials) {
            throw new BadCredentialsException("Неправильный пароль");
        }
    }
}

