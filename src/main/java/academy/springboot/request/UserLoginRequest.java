package academy.springboot.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginRequest {
    public final String user;
    public final String password;
}
