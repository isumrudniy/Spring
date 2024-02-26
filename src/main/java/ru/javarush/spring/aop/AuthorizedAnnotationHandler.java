package ru.javarush.spring.aop;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.javarush.spring.exception.NotAuthorizedException;

@Aspect
@Component
@RequiredArgsConstructor
public class AuthorizedAnnotationHandler {
    private final HttpServletRequest request;

    @Value("${security.auth.token}")
    private String authToken;

    @Around("@annotation(ru.javarush.spring.aop.annotation.Authorized)")
    public Object handlerAuthorized(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!authToken.equals(request.getHeader("X-Auth-Token"))) {
            throw new NotAuthorizedException("Not authorized");
        }
        return joinPoint.proceed();
    }

}
