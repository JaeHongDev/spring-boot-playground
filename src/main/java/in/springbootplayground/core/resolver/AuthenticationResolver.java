package in.springbootplayground.core.resolver;

import in.springbootplayground.core.attributes.Authentication;
import in.springbootplayground.core.attributes.User;
import in.springbootplayground.core.infrastructure.MemberRepository;
import in.springbootplayground.core.infrastructure.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class AuthenticationResolver implements HandlerMethodArgumentResolver {

    private final TokenRepository tokenRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        return parameter.getParameterType().equals(Authentication.class) &&
                parameter.hasParameterAnnotation(User.class);
    }

    @Override
    public Authentication resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) throws InterruptedException {

        var authorization = webRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if(Strings.isBlank(authorization)) {
            return new Authentication(0L);
        }

        Thread.sleep(100);


        var token = authorization.substring("Bearer ".length());
        var memberId = Long.parseLong(token);

        tokenRepository.findById(memberId)
                .orElseThrow(()-> new IllegalArgumentException("사용자가 없습니다."));

        return new Authentication(memberId);
    }
}
