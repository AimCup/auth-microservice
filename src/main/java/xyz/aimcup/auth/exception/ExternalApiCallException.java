package xyz.aimcup.auth.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExternalApiCallException extends RuntimeException {

    public ExternalApiCallException() {
        super("External API call failed.");
    }
}
