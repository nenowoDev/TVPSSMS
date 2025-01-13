package config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String role = authentication.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .findFirst()
                .orElse("");

        String redirectUrl = "/";
        if (role.equals("ROLE_ADMIN")) {
            redirectUrl = "/SpringLabApp3/users/admin";
        } else if (role.equals("ROLE_TEACHER")) {
            redirectUrl = "/SpringLabApp3/users/teacher";
        } else if (role.equals("ROLE_STUDENT")) {
            redirectUrl = "/SpringLabApp3/users/student";
        }

        response.sendRedirect(redirectUrl);
    }
}
