package api.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class HttpNotFoundException extends ResponseStatusException {
    public HttpNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}