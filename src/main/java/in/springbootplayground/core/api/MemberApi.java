package in.springbootplayground.core.api;

import in.springbootplayground.core.api.payload.SignupRequest;
import in.springbootplayground.core.application.AuthService;
import in.springbootplayground.core.attributes.Authentication;
import in.springbootplayground.core.attributes.User;
import in.springbootplayground.core.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberApi {

    private final AuthService authService;

    @GetMapping
    public Long me(@User Authentication authentication) throws InterruptedException {
        Thread.sleep(100);
        return authService.me(authentication.id());
    }

    @PostMapping
    public Long signup(){
        return authService.signup();
    }
}

