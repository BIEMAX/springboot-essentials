package academy.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
public class UserInactiveException extends Exception {
    public UserInactiveException() {
        super("The user is no longer active");
    }
}
