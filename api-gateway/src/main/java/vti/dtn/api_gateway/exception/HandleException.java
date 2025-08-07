package vti.dtn.api_gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vti.dtn.api_gateway.response.AuthenticationResponse;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException ex) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return new ResponseEntity<>(authenticationResponse, HttpStatus.UNAUTHORIZED);
    }
}
