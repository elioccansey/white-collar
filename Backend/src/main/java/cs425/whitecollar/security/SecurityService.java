package cs425.whitecollar.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SecurityService {

    public String authenticatedUser() {

        return (String) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}