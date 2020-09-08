package com.projects.springsecurityjwtexample.listener;

import com.projects.springsecurityjwtexample.domain.UserPrincipal;
import com.projects.springsecurityjwtexample.service.LogInAttemptService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationSuccessListener {

    private LogInAttemptService logInAttemptService;

    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
        Object pricipal = event.getAuthentication().getPrincipal();
        if (pricipal instanceof UserPrincipal) {
            UserPrincipal user = (UserPrincipal) event.getAuthentication().getPrincipal();
            logInAttemptService.evictUserFromLoginAttemptCache(user.getUsername());
        }
    }
}
